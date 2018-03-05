package com.neoxia;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.integration.annotation.IntegrationComponentScan;

import com.neoxia.dao.EtudiantRepository;
import com.neoxia.dao.FormationRepository;
import com.neoxia.entities.Etudiant;
import com.neoxia.entities.Formation;

@EnableEurekaClient
@IntegrationComponentScan
@SpringBootApplication
public class FormationsApplication implements CommandLineRunner {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;

	public static void main(String[] args) {
		SpringApplication.run(FormationsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Stream.of("Java", "JEE", "Spring", "SOA").forEach(f -> {
			Formation nf = new Formation();
			nf.setNom(f);
			nf.setDuree((int)Math.random() * 30);
			formationRepository.save(nf);
		});
		
		etudiantRepository.save(new Etudiant(null, "Anas", "Bens", new Formation(1L,null, 0, null) ));
		etudiantRepository.save(new Etudiant(null, "Amine", "AMINE", new Formation(1L,null, 34, null) ));
		etudiantRepository.save(new Etudiant(null, "Mohammed", "Mohamed", new Formation(1L,null, 45, null) ));
		etudiantRepository.save(new Etudiant(null, "Ahmed", "AHMED", new Formation(2L,null, 0, null) ));
		etudiantRepository.save(new Etudiant(null, "Musta", "MUSTA", new Formation(3L,null, 0, null) ));
		etudiantRepository.save(new Etudiant(null, "Youness", "BERK", new Formation(4L,null, 0, null) ));
		
//		formationRepository.findAll().forEach(f -> {
//			System.out.println(f.getId() + " -- " + f.getNom());
//		});
//		etudiantRepository.findAll().forEach(e -> System.out.println(e.getNom()));
	}
}
