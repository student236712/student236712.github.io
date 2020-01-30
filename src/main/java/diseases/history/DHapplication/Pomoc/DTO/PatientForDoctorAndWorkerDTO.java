package diseases.history.DHapplication.Pomoc.DTO;

import java.io.Serializable;
import java.time.LocalDate;


public class PatientForDoctorAndWorkerDTO implements Serializable {
    private Long id;
    private String individualNumber;
    private String numberPesel;
    private LocalDate dateOfBirth;
    private char gender;
    private String firstName;
    private String secondName;
    private String surname;


    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    public char getGender() {
        return gender;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getNumberPesel() {
        return numberPesel;
    }

    public void setNumberPesel(String numberPesel) {
        this.numberPesel = numberPesel;
    }


    public String getIndividualNumber() {
        return individualNumber;
    }

    public void setIndividualNumber(String individualNumber) {
        this.individualNumber = individualNumber;
    }

}

