package pl.olin44.onlineclassregister.applicationlayer;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.olin44.onlineclassregister.domain.IllegalFieldValueError;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice(basePackageClasses={CreatePersonController.class})
public class CreatePersonErrorHandler {

    private static final String EXCEPTION_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

    @ExceptionHandler({ IllegalArgumentException.class})
    public ResponseEntity<IllegalFieldValueError> handleException(
            IllegalArgumentException ex, HttpServletRequest request) {
        return new ResponseEntity<>(createError(ex, request), HttpStatus.CONFLICT);

    }

    private IllegalFieldValueError createError(IllegalArgumentException ex, HttpServletRequest request) {
        return new IllegalFieldValueError(ex.getMessage(), getTime(),request.getRequestURI());
    }

    private String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(EXCEPTION_TIME_FORMAT);
        return formatter.format(LocalDateTime.now());
    }
}
