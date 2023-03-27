package ma.emsi.jpa_hibernate_spring_data;

import ma.emsi.jpa_hibernate_spring_data.entities.*;
import ma.emsi.jpa_hibernate_spring_data.repositories.ConsultationRepository;
import ma.emsi.jpa_hibernate_spring_data.repositories.MedecinRepository;
import ma.emsi.jpa_hibernate_spring_data.repositories.PatientRepository;
import ma.emsi.jpa_hibernate_spring_data.repositories.RendezVousRepository;
import ma.emsi.jpa_hibernate_spring_data.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaHibernateSpringDataApplication {

//	@Autowired
//	private PatientRepository patientRepository;
	public static void main(String[] args) {

		SpringApplication.run(JpaHibernateSpringDataApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository) {
		return args -> {
			Stream.of("Hamza", "Nawfal", "Mohammed","Marouane")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setName(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(Math.random()>0.5 ? true : false);
						hospitalService.savePatient(patient);
					});

			Stream.of("Oussama", "Tahri")
					.forEach(name -> {
						Medecin medecin = new Medecin();
						medecin.setName(name);
						medecin.setSpecialite(Math.random()>0.5 ? "Cardiologue" : "Dentiste");
						medecin.setEmail(name+ (int) (Math.random() * 7) +"@gmail."+medecin.getSpecialite());
						hospitalService.saveMedecin(medecin);
					});

			Patient nawfal = patientRepository.findByName("Nawfal");
			Patient patient = patientRepository.findById(1L).orElse(null);
			Medecin oussama = medecinRepository.findByName("Oussama");

			// ----------------------------------------------------------------------------

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(nawfal);
			rendezVous.setMedecin(oussama);
			hospitalService.saveRendezVous(rendezVous);

			RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);

			// ----------------------------------------------------------------------------

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous);
			consultation.setRapport("tout est bien");
			hospitalService.saveConsultation(consultation);

		};

	}

//	@Override
//	public void run(String... args) throws Exception {
//		for (int i = 0; i < 100; i++){
//			patientRepository.save(
//					new Patient(null, "Oussama", new Date(), Math.random()>0.5 ? true:false, (int) (Math.random()*1000)));
//		}
//
//
//		Page<Patient> patients = patientRepository.findAll(PageRequest.of(0, 5));
//		System.out.println("Total pages: "+patients.getTotalPages());
//		System.out.println("Total elements: "+patients.getTotalElements());
//		System.out.println("Num page: " +patients.getNumber());
//		List<Patient> content = patients.getContent();
//		var byMalade = patientRepository.findByMalade(true, PageRequest.of(0,5));
//		byMalade.forEach(patient -> {
//			System.out.println("-----------------------------");
//			System.out.println(patient.getId());
//			System.out.println(patient.getName());
//			System.out.println(patient.getScore());
//			System.out.println(patient.getDateNaissance());
//			System.out.println(patient.isMalade());
//		});
//		System.out.println("******************************");
//		Patient patient = patientRepository.findById(1L).orElseThrow(() -> new RuntimeException("Patient not found"));
//
//		if (patient!= null) {
//			System.out.println(patient.getName());
//			System.out.println(patient.isMalade());
//		}
//		patient.setScore(777);
//		patientRepository.save(patient);
//		patientRepository.deleteById(1L);
//	}
}
