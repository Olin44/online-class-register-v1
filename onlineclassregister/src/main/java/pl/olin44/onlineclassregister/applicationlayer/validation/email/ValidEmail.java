package pl.olin44.onlineclassregister.applicationlayer.validation.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.olin44.onlineclassregister.applicationlayer.validation.ValidationMessages;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {

    String message() default ValidationMessages.INVALID_EMAIL_ERROR_MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
