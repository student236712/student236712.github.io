package diseases.history.DHapplication.Objects.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")

public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numberPesel;
    private LocalDate dateOfBirth;
    private String individualNumber;
    private char gender;
    private String firstName;
    private String secondName;
    private String surname;
    private String zipCode;
    private String city;
    private String street;
    private int houseNumber;
    private int flatNumber;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)

    private Set<Disease> diseases;
    @OneToMany(mappedBy = "patient")

    private Set<Visit> visits;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)

    private Set<Procedure> procedures;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)

    private Set<HospitalTreatment> hospitalTreatments;


    public Patient() {
    }


    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }

    public Set<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<Procedure> procedures) {
        this.procedures = procedures;
    }

    public Set<HospitalTreatment> getHospitalTreatments() {
        return hospitalTreatments;
    }

    public void setHospitalTreatments(Set<HospitalTreatment> hospitalTreatments) {
        this.hospitalTreatments = hospitalTreatments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
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
