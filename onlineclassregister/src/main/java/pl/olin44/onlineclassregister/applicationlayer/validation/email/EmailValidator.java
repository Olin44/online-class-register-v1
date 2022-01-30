package pl.olin44.onlineclassregister.applicationlayer.validation.email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.olin44.onlineclassregister.domain.RegexPattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField.matches(RegexPattern.EMAIL);
    }
}