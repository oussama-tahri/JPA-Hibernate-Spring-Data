package ma.emsi.jpa_hibernate_spring_data.repositories;

import ma.emsi.jpa_hibernate_spring_data.entities.Consultation;
import ma.emsi.jpa_hibernate_spring_data.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
