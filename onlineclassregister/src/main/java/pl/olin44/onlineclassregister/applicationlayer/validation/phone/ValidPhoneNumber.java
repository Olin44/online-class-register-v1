package pl.olin44.onlineclassregister.applicationlayer.validation.phone;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.olin44.onlineclassregister.applicationlayer.validation.ValidationMessages;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {

    String message() default ValidationMessages.INVALID_PHONE_NUMBER_ERROR_MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}