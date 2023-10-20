package bg.tuplovdiv.cookingrecipes.validations.userExists;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.UserLoginForm;
import bg.tuplovdiv.cookingrecipes.domain.entities.User;
import bg.tuplovdiv.cookingrecipes.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public record LoginUserValidator(UserRepository userRepository,
                                 ModelMapper modelMapper)
        implements ConstraintValidator<ValidateLoginUser, UserLoginForm> {

    @Override
    public void initialize(ValidateLoginUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginForm userLogin, ConstraintValidatorContext constraintValidatorContext) {
        Optional<User> loginCandidate = this.userRepository.findByUsername(userLogin.getUsername());

        return loginCandidate.isPresent()
                && loginCandidate.get()
                .getPassword()
                .equals(userLogin.getPassword());
    }
}
