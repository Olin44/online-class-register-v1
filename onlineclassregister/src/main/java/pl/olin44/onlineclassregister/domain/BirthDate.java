package pl.olin44.onlineclassregister.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class BirthDate {
    public static final String BIRTH_DATE_PATTERN = "dd-MM-yyyy";

    private final LocalDate birthDate;

    public BirthDate(String birthDateAsString) {
        if(birthDateAsString == null) {
            throw new IllegalArgumentException("Birth date can't be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(BIRTH_DATE_PATTERN);
        try {
            LocalDate birthDate = LocalDate.parse(birthDateAsString, formatter);
            if(birthDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Invalid birth date. Birth date can't be after current date");
            }
            this.birthDate = birthDate;
        } catch (DateTimeParseException dateTimeParseException) {
            throw new IllegalArgumentException("Invalid birth date format. Date format should be" + BIRTH_DATE_PATTERN);
        }
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate birthDate1 = (BirthDate) o;
        return birthDate.equals(birthDate1.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDate);
    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "birthDate=" + birthDate +
                '}';
    }
}
