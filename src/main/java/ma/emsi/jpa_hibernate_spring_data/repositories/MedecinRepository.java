package ma.emsi.jpa_hibernate_spring_data.repositories;

import ma.emsi.jpa_hibernate_spring_data.entities.Medecin;
import ma.emsi.jpa_hibernate_spring_data.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    Medecin findByName(String name);
}
