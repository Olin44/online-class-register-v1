package pl.olin44.onlineclassregister.applicationlayer.validation.text;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.olin44.onlineclassregister.applicationlayer.validation.ValidationConstants;
import pl.olin44.onlineclassregister.applicationlayer.validation.ValidationMessages;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidString {

    int min() default ValidationConstants.MIN_STRING_SIZE;

    int max() default ValidationConstants.MAX_STRING_SIZE;

    String message() default ValidationMessages.INVALID_TEXT_ERROR_MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
