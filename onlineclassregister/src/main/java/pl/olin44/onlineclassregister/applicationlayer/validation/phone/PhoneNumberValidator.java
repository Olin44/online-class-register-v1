package pl.olin44.onlineclassregister.applicationlayer.validation.phone;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.olin44.onlineclassregister.applicationlayer.validation.text.ValidString;
import pl.olin44.onlineclassregister.domain.RegexPattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public boolean isValid(@ValidString String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField.matches(RegexPattern.PHONE_NUMBER);
    }
}
