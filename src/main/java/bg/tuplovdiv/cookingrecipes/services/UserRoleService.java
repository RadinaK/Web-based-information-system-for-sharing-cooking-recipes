package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.UserRoleModel;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.veiw.UserRoleViewDto;
import bg.tuplovdiv.cookingrecipes.domain.entities.UserRole;
import bg.tuplovdiv.cookingrecipes.domain.enums.Role;
import bg.tuplovdiv.cookingrecipes.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserRoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public Set<UserRoleModel> findAllRoles() {
        return this.roleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, UserRoleModel.class))
                .collect(Collectors.toSet());
    }

    public UserRoleModel findRoleByName(String name) {
        return this.modelMapper.map(this.roleRepository.findByRole(Role.valueOf(name))
                        .orElseThrow(NoSuchElementException::new),
                UserRoleModel.class);
    }
}
