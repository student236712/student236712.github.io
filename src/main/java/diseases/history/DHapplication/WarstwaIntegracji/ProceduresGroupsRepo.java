package diseases.history.DHapplication.WarstwaIntegracji;

import diseases.history.DHapplication.Pomoc.Entity.ProceduresGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProceduresGroupsRepo extends JpaRepository<ProceduresGroups,Long> {



}
