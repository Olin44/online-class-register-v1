package pl.olin44.onlineclassregister.domain;

public record IllegalFieldValueError(String exceptionMessage, String localDateTime, String source) {
}
