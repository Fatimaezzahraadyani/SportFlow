package SportFlow.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


    public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegisterDto> {
        @Override
        public void initialize(PasswordMatch constraintAnnotation) {
            // No initialization needed
        }

        @Override
        public boolean isValid(RegisterDto registerDto, ConstraintValidatorContext context) {
            System.out.println(registerDto.getPassword());
            if (registerDto == null) {
                return true; // Ignore validation if the object is null
            }

            if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
                // ⚠️ This makes the error appear under "confirmPassword" instead of the class
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Passwords do not match")
                        .addPropertyNode("confirmPassword") // Associate error with confirmPassword field
                        .addConstraintViolation();

                return false;
            }
            return true;
        }
    }
