package pl.olin44.onlineclassregister.domain;

public class Student {
    private String firstName;
    private String secondName;
    private String surname;
    private String birthDate;
    private String gender;
    private String phoneNumber;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Student(String firstName, String secondName, String surname, String birthDate, String gender, String phoneNumber, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
