package diseases.history.DHapplication.WarstwaBiznesowa;

import diseases.history.DHapplication.WarstwaIntegracji.MedicamentRepo;
import diseases.history.DHapplication.Pomoc.DTO.MedicamentDTO;
import diseases.history.DHapplication.Pomoc.Entity.Medicament;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class MedicamentManager {
    private MedicamentRepo medicamentRepo;
    private ModelMapper modelMapper = new ModelMapper();


    private Type listType = new TypeToken<List<MedicamentDTO>>() {
    }.getType();

    @Autowired
    public MedicamentManager(MedicamentRepo medicamentRepo) {
        this.medicamentRepo = medicamentRepo;
    }


    public List<MedicamentDTO> findAll() {
        List<Medicament> medicates = medicamentRepo.findAll();
        return modelMapper.map(medicates, listType);

    }

    public List<MedicamentDTO> findAllMedicamentsFromList(List<String> namesList) {
        List<Medicament> medicates = medicamentRepo.findAllMedicamentsFromList(namesList);
        return modelMapper.map(medicates, listType);

    }
}
