package pl.olin44.onlineclassregister.applicationlayer;

import java.util.List;

public record IllegalFieldValues(List<FieldError> fieldErrors) {
    public record FieldError(String fieldName, String fieldInvalidMessage) {
    }
}
