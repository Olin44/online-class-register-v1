package pl.olin44.onlineclassregister.applicationlayer;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pl.olin44.onlineclassregister.util.StringConstants;

import java.text.MessageFormat;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CreatePersonCommandTest {

    public static final String CONSTRAIN_VIOLATION_MESSAGE = "Invalid value= ''{0}'', in field=''{1}'', message=''{2}''";
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @DisplayName("Test valid create person commands")
    @ParameterizedTest(name = "Create person command from line {index}")
    @CsvFileSource(resources = "/applicationlayer/validPersonCommand.csv", numLinesToSkip = 1)
    void testValidCreatePersonCommand(String firstName, String secondName, String surname, String birthDate,
                                      String gender, String phoneNumber, String email) {
        CreatePersonCommand createPersonCommand = new CreatePersonCommand(firstName, secondName, surname, birthDate, gender, phoneNumber, email);
        validator.validate(createPersonCommand);
        Set<ConstraintViolation<CreatePersonCommand>> violations = validator.validate(createPersonCommand);
        assertTrue(violations.isEmpty(), "Violations: " + StringConstants.NEW_LINE + getConstraintViolationDescription(violations));
    }

    public <T> String getConstraintViolationDescription(Set<ConstraintViolation<T>> violations) {
        return violations.stream()
                .map(this::convertConstrainViolationToString)
                .collect(Collectors.joining(StringConstants.NEW_LINE));
    }

    private <T> String convertConstrainViolationToString(ConstraintViolation<T> violation) {
        return MessageFormat.format(CONSTRAIN_VIOLATION_MESSAGE,
                violation.getInvalidValue(),
                violation.getPropertyPath(),
                violation.getMessage());
    }
}