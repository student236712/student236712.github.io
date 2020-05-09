package diseases.history.DHapplication.BusinessLayer;

import diseases.history.DHapplication.Objects.DTO.DiseasesClassificationsDTO;
import diseases.history.DHapplication.Objects.Entity.DiseasesClassifications;
import diseases.history.DHapplication.IntegrationLayer.DiseasesClassificationsRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class DiseasesClassificationsManager {
    DiseasesClassificationsRepo diseasesClassificationsRepo;

    private ModelMapper modelMapper = new ModelMapper();
    private Type listType = new TypeToken<List<DiseasesClassificationsDTO>>() {
    }.getType();

    @Autowired
    public DiseasesClassificationsManager(DiseasesClassificationsRepo diseasesClassificationsRepo) {
        this.diseasesClassificationsRepo = diseasesClassificationsRepo;
    }



    public List<DiseasesClassificationsDTO> findAll() {
        List<DiseasesClassifications> diseasesClassifications = diseasesClassificationsRepo.findAll();
        return modelMapper.map(diseasesClassifications, listType);

    }

}
