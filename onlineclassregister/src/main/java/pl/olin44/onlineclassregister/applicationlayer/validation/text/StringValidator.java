package pl.olin44.onlineclassregister.applicationlayer.validation.text;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StringValidator implements ConstraintValidator<ValidString, String> {
    private int max;
    private int min;

    public void initialize(ValidString constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(@NotBlank @NotNull String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField.length() > min
                && contactField.length() < max;
    }
}