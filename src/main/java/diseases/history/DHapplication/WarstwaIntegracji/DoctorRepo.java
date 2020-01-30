package diseases.history.DHapplication.WarstwaIntegracji;


import diseases.history.DHapplication.Pomoc.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByPzwNumber(String pzwNumber);
}
