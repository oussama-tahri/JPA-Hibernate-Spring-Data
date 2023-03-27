package ma.emsi.jpa_hibernate_spring_data.web;

import ma.emsi.jpa_hibernate_spring_data.entities.Patient;
import ma.emsi.jpa_hibernate_spring_data.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
