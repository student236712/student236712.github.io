package diseases.history.DHapplication.Pomoc.DTO;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class PatientToCreateHistoryDTO implements Serializable {

    private Long id;
    private String individualNumber;
    private char gender;
    private int genderInt;

    private Set<DiseaseDTO> diseases;
    private Set<VisitDTO> visits;
    private Set<ProcedureDTO> procedures;
    private Set<HospitalTreatmentDTO> hospitalTreatments;



    private List<String> diseasesCategories;
    private List<String> diseasesGroups;
    private List<String> diseasesClassifications;


    private List<String> proceduresCategories;
    private List<String> proceduresGroups;

    public PatientToCreateHistoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndividualNumber() {
        return individualNumber;
    }

    public void setIndividualNumber(String individualNumber) {
        this.individualNumber = individualNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getGenderInt() {
        return genderInt;
    }

    public void setGenderInt(int genderInt) {
        this.genderInt = genderInt;
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

    public List<String> getDiseasesCategories() {
        return diseasesCategories;
    }

    public void setDiseasesCategories(List<String> diseasesCategories) {
        this.diseasesCategories = diseasesCategories;
    }

    public List<String> getDiseasesGroups() {
        return diseasesGroups;
    }

    public void setDiseasesGroups(List<String> diseasesGroups) {
        this.diseasesGroups = diseasesGroups;
    }

    public List<String> getDiseasesClassifications() {
        return diseasesClassifications;
    }

    public void setDiseasesClassifications(List<String> diseasesClassifications) {
        this.diseasesClassifications = diseasesClassifications;
    }

    public List<String> getProceduresCategories() {
        return proceduresCategories;
    }

    public void setProceduresCategories(List<String> proceduresCategories) {
        this.proceduresCategories = proceduresCategories;
    }

    public List<String> getProceduresGroups() {
        return proceduresGroups;
    }

    public void setProceduresGroups(List<String> proceduresGroups) {
        this.proceduresGroups = proceduresGroups;
    }


}
