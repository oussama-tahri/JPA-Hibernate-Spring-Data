package ma.emsi.jpa_hibernate_spring_data.service;

import jakarta.transaction.Transactional;
import ma.emsi.jpa_hibernate_spring_data.entities.Consultation;
import ma.emsi.jpa_hibernate_spring_data.entities.Medecin;
import ma.emsi.jpa_hibernate_spring_data.entities.Patient;
import ma.emsi.jpa_hibernate_spring_data.entities.RendezVous;
import ma.emsi.jpa_hibernate_spring_data.repositories.ConsultationRepository;
import ma.emsi.jpa_hibernate_spring_data.repositories.MedecinRepository;
import ma.emsi.jpa_hibernate_spring_data.repositories.PatientRepository;
import ma.emsi.jpa_hibernate_spring_data.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    PatientRepository patientRepository;
    MedecinRepository medecinRepository;
    ConsultationRepository consultationRepository;
    RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,
                               MedecinRepository medecinRepository,
                               ConsultationRepository consultationRepository,
                               RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }
}
