package pl.olin44.onlineclassregister.applicationlayer.validation;

public final class ValidationMessages {

    private ValidationMessages() {
    }

    public static final String INVALID_EMAIL_ERROR_MESSAGE = "Invalid email, email must match OWASP standards";
    public static final String INVALID_TEXT_ERROR_MESSAGE = "Invalid text, text must be not null, not blank and has size between"
            + " {min} and {max}";
    public static final String INVALID_PHONE_NUMBER_ERROR_MESSAGE = "Invalid phone number, phone number must be formatted as phone number";
}
