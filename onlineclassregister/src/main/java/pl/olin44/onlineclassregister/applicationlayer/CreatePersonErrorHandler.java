package pl.olin44.onlineclassregister.applicationlayer;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CreatePersonErrorHandler extends ResponseEntityExceptionHandler {

    private static final String EXCEPTION_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

    private String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(EXCEPTION_TIME_FORMAT);
        return formatter.format(LocalDateTime.now());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException methodArgumentNotValidException,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<IllegalFieldValues.FieldError> errors = new ArrayList<>();
        for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errors.add(createFieldError(error.getField(), error.getDefaultMessage()));
        }
        for (ObjectError error : methodArgumentNotValidException.getBindingResult().getGlobalErrors()) {
            errors.add(createFieldError(error.getObjectName(), error.getDefaultMessage()));
        }

        return handleExceptionInternal(methodArgumentNotValidException, errors, headers, HttpStatus.CONFLICT, request);
    }

    private IllegalFieldValues.FieldError createFieldError(String field, String defaultMessage) {
        return new IllegalFieldValues.FieldError(field, defaultMessage);
    }
}
