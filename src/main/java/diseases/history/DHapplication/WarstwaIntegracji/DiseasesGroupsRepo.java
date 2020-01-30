package diseases.history.DHapplication.WarstwaIntegracji;

import diseases.history.DHapplication.Pomoc.Entity.DiseasesGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseasesGroupsRepo extends JpaRepository<DiseasesGroups, Long> {

     List<DiseasesGroups> findByDiseasesClassificationsDescription(String diseasesClassificationDescription);
}
