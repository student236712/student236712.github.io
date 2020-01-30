package diseases.history.DHapplication.Pomoc.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

public class DoctorDTO implements Serializable {

    private Long id;

    private Set<VisitDTO> visits;
    private String pzwNumber;
    private LocalDate dateOfBirth;
    private char gender;
    private String firstName;
    private String secondName;
    private String surname;
    private String specialization;


    public DoctorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<VisitDTO> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitDTO> visits) {
        this.visits = visits;
    }

    public String getPzwNumber() {
        return pzwNumber;
    }

    public void setPzwNumber(String pzwNumber) {
        this.pzwNumber = pzwNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
