package diseases.history.DHapplication.PresentationLayer;


import diseases.history.DHapplication.BusinessLayer.PatientManager;
import diseases.history.DHapplication.Objects.DTO.PatientForDoctorAndWorkerDTO;
import diseases.history.DHapplication.Objects.DTO.PatientForRegistrantDTO;
import diseases.history.DHapplication.Objects.DTO.PatientForSearchingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/patient")
public class PatientApi {


    private PatientManager patientManager;


    @Autowired
    public PatientApi(PatientManager patientManager) {
        this.patientManager = patientManager;

    }


    @PostMapping("/add")
    public String addPatient(@ModelAttribute(value = "patient")
                                     PatientForRegistrantDTO patientForRegistrantDTO,
                             RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model) {

        Map<Boolean, List<String>> resultMap = patientManager.save(patientForRegistrantDTO, bindingResult);
        if (resultMap.containsKey(true)
        ) {
            redirectAttributes.addFlashAttribute("messages", resultMap.get(true));
            return "redirect:/addPatient";
        } else {
            model.addAttribute("messages", resultMap.get(false));
            return "AddPatient";
        }
    }


    @PostMapping("/search")
    public String searchByIndividualNumber(
            Model model, @ModelAttribute(value = "selectedPatient") PatientForSearchingDTO patientForSearchingDTO,
            RedirectAttributes redirectAttributes) {
        PatientForDoctorAndWorkerDTO patientDTO =
                patientManager.findByIndividualNumberForDoctorAndWorkerDTO
                        (patientForSearchingDTO.getIndividualNumber());
        if (patientDTO != null) {
            model.addAttribute("patient", patientDTO);
            return "DisplayPatient";
        } else {
            redirectAttributes.addFlashAttribute("message", "Patient doesn't found");
            return "redirect:/api/patient/getAllPatients";
        }

    }


    @GetMapping("/getAllPatients")
    public String getAllPatients(Model model) {
        List<PatientForSearchingDTO> patientForSearchingDTOList = patientManager.findAll();
        model.addAttribute("allPatients", patientForSearchingDTOList);
        PatientForSearchingDTO patientForSearchingDTO = new PatientForSearchingDTO();
        model.addAttribute("selectedPatient", patientForSearchingDTO);
        return "SearchPatient";
    }
}
