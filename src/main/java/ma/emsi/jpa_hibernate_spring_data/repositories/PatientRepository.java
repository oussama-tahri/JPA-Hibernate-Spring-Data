package ma.emsi.jpa_hibernate_spring_data.repositories;

import ma.emsi.jpa_hibernate_spring_data.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByMalade(boolean m);
    Page<Patient> findByMalade(boolean m, Pageable pageable);
    List<Patient> findByMaladeAndScoreLessThan(boolean m, int score);
    List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNameLike(Date d1, Date d2, String name);
    @Query("select p from Patient p where p.name like :x and p.score< :y")
    List<Patient> chercherPatients(@Param("x") String nom, @Param("y") int scoreMin);

    Patient findByName(String name);

}
