package bg.tuplovdiv.cookingrecipes.validations.checkUserExistance;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.UserLoginForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.UserModel;
import bg.tuplovdiv.cookingrecipes.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginForm> {

    private final UserService userService;

    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginForm userLoginModel, ConstraintValidatorContext constraintValidatorContext) {
        UserModel user = this.userService.findByUsername(userLoginModel.getUsername());

        return user.getId() != null
                && user.getPassword()
                .equals(userLoginModel.getPassword());
    }
}
