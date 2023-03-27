package ma.emsi.jpa_hibernate_spring_data.repositories;

import ma.emsi.jpa_hibernate_spring_data.entities.Medecin;
import ma.emsi.jpa_hibernate_spring_data.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
