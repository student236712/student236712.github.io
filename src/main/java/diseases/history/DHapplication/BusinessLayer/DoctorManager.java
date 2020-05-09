package diseases.history.DHapplication.BusinessLayer;


import diseases.history.DHapplication.IntegrationLayer.DoctorRepo;
import diseases.history.DHapplication.Objects.DTO.DoctorDTO;
import diseases.history.DHapplication.Objects.Entity.Doctor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorManager {

    private DoctorRepo doctorRepo;
    private ModelMapper modelMapper = new ModelMapper();
    private Type listType = new TypeToken<List<DoctorDTO>>() {
    }.getType();


    @Autowired
    public DoctorManager(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }


    public Doctor findByPzwNumber(String pzwNumber) {

        Optional<Doctor> optionalDoctor = doctorRepo.findByPzwNumber(pzwNumber);
        return optionalDoctor.orElse(null);


    }

    public List<DoctorDTO> findAll() {
        List<Doctor> doctors = doctorRepo.findAll();
        return modelMapper.map(doctors, listType);

    }



}
