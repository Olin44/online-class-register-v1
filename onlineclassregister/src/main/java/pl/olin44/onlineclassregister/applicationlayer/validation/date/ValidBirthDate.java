package pl.olin44.onlineclassregister.applicationlayer.validation.date;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.olin44.onlineclassregister.applicationlayer.validation.ValidationMessages;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BirthDateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBirthDate {

    String message() default ValidationMessages.INVALID_EMAIL_ERROR_MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}