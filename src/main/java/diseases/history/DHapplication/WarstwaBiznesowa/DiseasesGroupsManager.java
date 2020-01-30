package diseases.history.DHapplication.WarstwaBiznesowa;

import diseases.history.DHapplication.WarstwaIntegracji.DiseasesGroupsRepo;
import diseases.history.DHapplication.Pomoc.DTO.DiseasesGroupsDTO;
import diseases.history.DHapplication.Pomoc.Entity.DiseasesGroups;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class DiseasesGroupsManager {
    DiseasesGroupsRepo diseasesGroupsRepo;
    private ModelMapper modelMapper = new ModelMapper();
    private Type listType = new TypeToken<List<DiseasesGroupsDTO>>() {
    }.getType();

    @Autowired
    public DiseasesGroupsManager(DiseasesGroupsRepo diseasesGroupsRepo) {
        this.diseasesGroupsRepo = diseasesGroupsRepo;
    }


    public List<DiseasesGroupsDTO> findByClassificationDescription(String description) {
        List<DiseasesGroups> diseasesGroups = diseasesGroupsRepo.findByDiseasesClassificationsDescription(description);

        return modelMapper.map(diseasesGroups, listType);

    }


}
