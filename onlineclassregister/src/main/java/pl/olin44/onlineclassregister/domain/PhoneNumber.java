package pl.olin44.onlineclassregister.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

    private final String phoneNumber;

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(RegexPattern.PHONE_NUMBER);

    public PhoneNumber(String phoneNumber) {
        if(phoneNumber == null) {
            throw new IllegalArgumentException("Phone number can't be null");
        }
        Matcher emailMatcher = PHONE_NUMBER_PATTERN.matcher(phoneNumber);
        if(!emailMatcher.matches()){
            throw new IllegalArgumentException("Illegal phone number" + phoneNumber);
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
