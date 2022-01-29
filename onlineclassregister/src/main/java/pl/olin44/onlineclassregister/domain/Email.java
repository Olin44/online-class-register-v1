package pl.olin44.onlineclassregister.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private final String email;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(RegexPattern.EMAIL);

    public Email(String email) {
        if(email == null) {
            throw new IllegalArgumentException("Address can't be null");
        }
        Matcher emailMatcher = EMAIL_PATTERN.matcher(email);
        if(!emailMatcher.matches()){
            throw new IllegalArgumentException("Illegal email address " + email);
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return email.equals(email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
