package pl.olin44.onlineclassregister.domain;

import java.util.Objects;
import java.util.Optional;

public class Person {

    private String firstName;
    private String secondName;
    private String surname;
    private BirthDate birthDate;
    private Gender gender;
    private PhoneNumber phoneNumber;
    private Email email;

    public Person(String firstName,
                  String secondName,
                  String surname,
                  String birthDate,
                  String gender,
                  String phoneNumber,
                  String email) {
        if(firstName == null) {
            throw new IllegalArgumentException("First name can't be null");
        }
        if(surname == null) {
            throw new IllegalArgumentException("Surname can't be null");
        }
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.birthDate = new BirthDate(birthDate);
        this.gender = Gender.valueOf(gender);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
    }

    public String getFirstName() {
        return firstName;
    }

    public Optional<String> getSecondNameOptional() {
        return Optional.ofNullable(secondName);
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && Objects.equals(secondName, person.secondName) && surname.equals(person.surname) && birthDate.equals(person.birthDate) && gender == person.gender && phoneNumber.equals(person.phoneNumber) && email.equals(person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, surname, birthDate, gender, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                '}';
    }
}
