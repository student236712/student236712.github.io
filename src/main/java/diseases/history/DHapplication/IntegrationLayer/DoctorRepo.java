package diseases.history.DHapplication.IntegrationLayer;


import diseases.history.DHapplication.Objects.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByPzwNumber(String pzwNumber);
}
