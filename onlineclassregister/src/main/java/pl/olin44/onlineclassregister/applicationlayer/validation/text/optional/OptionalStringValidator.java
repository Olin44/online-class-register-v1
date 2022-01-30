package pl.olin44.onlineclassregister.applicationlayer.validation.text.optional;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OptionalStringValidator implements ConstraintValidator<ValidOptionalString, String> {
    private int max;
    private int min;

    public void initialize(ValidOptionalString constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(@NotBlank @NotNull String contactField,
                           ConstraintValidatorContext cxt) {
        if(contactField == null) {
            return true;
        }
        return !contactField.isBlank()
                && contactField.length() > min
                && contactField.length() < max;

    }
}
