package diseases.history.DHapplication.WarstwaIntegracji;

import diseases.history.DHapplication.Pomoc.Entity.ProceduresLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProceduresLibraryRepo extends JpaRepository<ProceduresLibrary,Long> {
}
