package bg.tuplovdiv.cookingrecipes.validations.passwardMatcher;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.UserRegisterForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatcher implements ConstraintValidator<PasswordMatch, UserRegisterForm> {

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterForm userRegisterModel, ConstraintValidatorContext context) {

        if (userRegisterModel.getPassword() != null &&
                userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword())) {
            return true;
        }

        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addPropertyNode(userRegisterModel.getConfirmPassword())
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
