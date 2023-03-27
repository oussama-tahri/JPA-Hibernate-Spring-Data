package ma.emsi.jpa_hibernate_spring_data.service;

import ma.emsi.jpa_hibernate_spring_data.entities.Consultation;
import ma.emsi.jpa_hibernate_spring_data.entities.Medecin;
import ma.emsi.jpa_hibernate_spring_data.entities.Patient;
import ma.emsi.jpa_hibernate_spring_data.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    Consultation saveConsultation(Consultation consultation);
    RendezVous saveRendezVous(RendezVous rendezVous);
}
