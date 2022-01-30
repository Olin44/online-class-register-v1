package pl.olin44.onlineclassregister.peristence;

import jakarta.persistence.*;
import pl.olin44.onlineclassregister.domain.Gender;

import java.time.LocalDate;

@Entity
public class PersonEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String firstName;
    private String secondName;
    @Basic(optional = false)
    @Column(nullable = false)
    private String surname;
    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDate birthDate;
    @Basic(optional = false)
    @Column(nullable = false)
    private Gender gender;
    @Basic(optional = false)
    @Column(nullable = false)
    private String phoneNumber;
    @Basic(optional = false)
    @Column(nullable = false)
    private String email;

    public PersonEntity() {
    }

    public PersonEntity(String firstName, String secondName, String surname, LocalDate birthDate, Gender gender,
                        String phoneNumber, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
