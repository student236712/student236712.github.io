package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


public class PatientDTO implements Serializable {
    private Long id;
    private String individualNumber;
    private String numberPesel;
    private LocalDate dateOfBirth;
    private char gender;
    private String firstName;
    private String secondName;
    private String surname;
    private String zipCode;
    private String city;
    private String street;
    private int houseNumber;
    private int flatNumber;

    private Set<DiseaseDTO> diseases;

    private Set<VisitDTO> visits;

    private Set<ProcedureDTO> procedures;

    private Set<HospitalTreatmentDTO> hospitalTreatments;


    public PatientDTO() {
    }

    public Set<DiseaseDTO> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<DiseaseDTO> diseases) {
        this.diseases = diseases;
    }

    public Set<VisitDTO> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitDTO> visits) {
        this.visits = visits;
    }

    public Set<ProcedureDTO> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<ProcedureDTO> procedures) {
        this.procedures = procedures;
    }

    public Set<HospitalTreatmentDTO> getHospitalTreatments() {
        return hospitalTreatments;
    }

    public void setHospitalTreatments(Set<HospitalTreatmentDTO> hospitalTreatments) {
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

    public void setDateOfBirth() {
        this.dateOfBirth = takeBirthDate();
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

    public LocalDate takeBirthDate() {
        int month;
        int year;
        int day;
        month = Integer.parseInt(numberPesel.substring(2, 4));
        year = Integer.parseInt(numberPesel.substring(0, 2));
        day = Integer.parseInt(numberPesel.substring(4, 6));
        if (month > 12) {
            month -= 20;
            year += 2000;
        } else {
            year += 1900;
        }

        return dateOfBirth = LocalDate.of(year, month, day);
    }


    public boolean isIdCorrect() {
        int[] arrray = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int x;
        int sum = 0;
        char[] charArray = numberPesel.toCharArray();
        for (int i = 0; i < 10; i++) {

            x = Integer.parseInt(String.valueOf(charArray[i]));
            x = (arrray[i] * x) % 10;
            sum += x;

        }
        return 10 - sum % 10 == Integer.parseInt(String.valueOf(charArray[10]));
    }

    public String getIndividualNumber() {
        return individualNumber;
    }

    public void setIndividualNumber(String individualNumber) {
        this.individualNumber = individualNumber;
    }


}

