package diseases.history.DHapplication.WarstwaIntegracji;

import diseases.history.DHapplication.Pomoc.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

    Optional<Patient> findByNumberPesel(String numberPesel);

    Optional<Patient> findByIndividualNumber(String individualNumber);


    @Query(nativeQuery = true, value = "select * from patients where individual_number in (SELECT distinct p.individual_number FROM diseases_history.visits v join patients p on v.patient_id=p.id where doctor_id =(?1) )")
    List<Patient> findDoctorPatients(@Param("param") Long doctorId);
}
