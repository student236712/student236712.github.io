package diseases.history.DHapplication.PresentationLayer;

import diseases.history.DHapplication.BusinessLayer.PatientManager;
import diseases.history.DHapplication.Objects.DTO.PatientDTO;
import diseases.history.DHapplication.Objects.DTO.PatientForDoctorAndWorkerDTO;
import diseases.history.DHapplication.Objects.DTO.PatientToCreateHistoryDTO;
import diseases.history.DHapplication.Objects.DTO.ProcedureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/api/history")
public class HistoryApi {

    private PatientManager patientManager;

    @Autowired
    public HistoryApi(PatientManager patientManager) {
        this.patientManager = patientManager;
    }

    @GetMapping("/diseasesHistory")
    public String createDiseasesHistory(@ModelAttribute(value = "patient")
                                                PatientForDoctorAndWorkerDTO patientForDoctorAndWorkerDTO,
                                        Model model) {

        PatientToCreateHistoryDTO patientDTO = patientManager.findByIndividualNumberCreateHistory(patientForDoctorAndWorkerDTO.getIndividualNumber());

        model.addAttribute("patient", patientDTO);

        return "WholeHistory";

    }

    @GetMapping("/showScatter")
    public String showScatter(Model model, @ModelAttribute(value = "patient") PatientDTO patient) {

        PatientToCreateHistoryDTO patientDTO = patientManager.findByIndividualNumberCreateHistory(patient.getIndividualNumber());
        Set<ProcedureDTO> procedureDTOSet = patientDTO.getProcedures();
        Map<LocalDate, Double> surveyMap = new LinkedHashMap<>();
        for (ProcedureDTO procedure : procedureDTOSet) {
            if (procedure.getProceduresLibrary().getIcdCode().equals("I09")) {
                surveyMap.put(procedure.getPerformanceDate(), procedure.getResult());
                model.addAttribute("maxRate", procedure.getProceduresLibrary().getProceduresResultsModeler().getUpperLimitMen());
                model.addAttribute("minRate", procedure.getProceduresLibrary().getProceduresResultsModeler().getLowerLimitMen());
                model.addAttribute("scatterTitle", procedure.getProceduresLibrary().getName());
            }
        }


        model.addAttribute("surveyMap", surveyMap);


        return "Scatter";
    }
}
