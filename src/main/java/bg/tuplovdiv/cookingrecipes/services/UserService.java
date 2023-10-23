package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RoleChangeForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.UserLoginForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.UserRegisterForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.UserModel;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.veiw.UserProfileModel;
import bg.tuplovdiv.cookingrecipes.domain.entities.User;
import bg.tuplovdiv.cookingrecipes.domain.entities.UserRole;
import bg.tuplovdiv.cookingrecipes.domain.enums.Role;
import bg.tuplovdiv.cookingrecipes.helpers.LoggedUser;
import bg.tuplovdiv.cookingrecipes.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserRoleService userRoleService,
                       ModelMapper modelMapper,
                       LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }


    //UserModel?
    public void registerUser(UserRegisterForm userRegister) {
        final UserModel userModel = this.modelMapper.map(userRegister, UserModel.class);

        userModel.setRoles(this.userRepository.count() == 0
                ? this.userRoleService.findAllRoles()
                : Set.of((this.userRoleService.findRoleByName("USER"))));

        final User userToSave = this.modelMapper.map(userModel, User.class);

        this.modelMapper.map(this.userRepository.saveAndFlush(userToSave), UserModel.class);
    }


//    public void loginUser(UserLoginForm userLogin) {
//        UserModel loginCandidate =
//                this.modelMapper.map(this.userRepository.findByUsername(userLogin.getUsername()).get(),
//                        UserModel.class);
//
//        this.loggedUser
//                .setId(loginCandidate.getId())
//                .setUsername(loginCandidate.getUsername())
//                .setRoleModels(loginCandidate.getRole());
//    }

    public UserModel loginUser(UserLoginForm userLogin) {
        Optional<User> loginCandidate = this.userRepository.findByUsername(userLogin.getUsername());

        UserModel userConfirmation = loginCandidate.isPresent()
                && loginCandidate.get().getPassword().equals(userLogin.getPassword())
                ? this.modelMapper.map(loginCandidate.get(), UserModel.class)
                : new UserModel();

        if (userConfirmation.isValid()) {
            this.loggedUser
                    .setId(userConfirmation.getId())
                    .setUsername(userConfirmation.getUsername())
                    .setRoleModels(userConfirmation.getRoles());
        }

        return userConfirmation;
    }

    public void logout() {
        this.loggedUser.clearFields();
    }

    public Set<Role> changeUserPermissions(Long userId,
                                           RoleChangeForm roleModelToSet,
                                           boolean shouldReplaceCurrentRoles) {

        User user = this.userRepository
                .findById(userId)
                .orElseThrow(NoSuchElementException::new);

        final UserRole roleToSave = this.modelMapper.map(this.userRoleService
                        .findRoleByName(roleModelToSet.getRoleName()),
                UserRole.class);

        if (shouldReplaceCurrentRoles) {
            user.setRoles(Set.of(roleToSave));
        } else {
            user.getRoles().add(roleToSave);
        }

        this.userRepository.saveAndFlush(user);

        return user.getRoles().stream().map(UserRole::getRole).collect(Collectors.toSet());
    }

    public UserModel findByUsername(String username) {
        return this.modelMapper
                .map(this.userRepository
                                .findByUsername(username)
                                .orElse(new User())
                        , UserModel.class);
    }

    public UserProfileModel getLoggedUserProfile() {
        return this.modelMapper.map(this.userRepository.findById(loggedUser.getId()), UserProfileModel.class);
    }
}
