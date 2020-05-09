package diseases.history.DHapplication.IntegrationLayer;

import diseases.history.DHapplication.Objects.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription,Long> {




}
