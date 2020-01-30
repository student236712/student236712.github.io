package diseases.history.DHapplication.Pomoc.DTO;

public class VisitSearchDTO {
    private String patientIndividualNumber;
    private String pzwNumber;
    private String visitDate;

    public VisitSearchDTO(String patientIndividualNumber, String pzwNumber, String visitDate) {
        this.patientIndividualNumber = patientIndividualNumber;
        this.pzwNumber = pzwNumber;
        this.visitDate = visitDate;
    }

    public VisitSearchDTO() {
    }

    public String getPatientIndividualNumber() {
        return patientIndividualNumber;
    }

    public void setPatientIndividualNumber(String patientIndividualNumber) {
        this.patientIndividualNumber = patientIndividualNumber;
    }

    public String getPzwNumber() {
        return pzwNumber;
    }

    public void setPzwNumber(String pzwNumber) {
        this.pzwNumber = pzwNumber;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
}
