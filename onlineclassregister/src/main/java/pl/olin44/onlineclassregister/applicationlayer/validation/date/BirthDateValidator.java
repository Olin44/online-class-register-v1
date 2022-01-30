package pl.olin44.onlineclassregister.applicationlayer.validation.date;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.olin44.onlineclassregister.applicationlayer.validation.text.ValidString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BirthDateValidator implements ConstraintValidator<ValidBirthDate, String> {

    private static final String BIRTH_DATE_PATTERN = "dd-MM-yyyy";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(BIRTH_DATE_PATTERN);

    @Override
    public boolean isValid(@ValidString String contactField,
                           ConstraintValidatorContext cxt) {
        try {
            return LocalDate.parse(contactField, formatter).isBefore(LocalDate.now());
        } catch (DateTimeParseException parseException) {
            return false;
        }
    }
}
