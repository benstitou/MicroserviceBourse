package com.neoxia.web;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neoxia.dao.EtudiantRepository;
import com.neoxia.dao.FormationRepository;
import com.neoxia.entities.Etudiant;
import com.neoxia.entities.Formation;

@Component
@WebService(endpointInterface = "com.neoxia.web.ScolariteSoapService")
public class ScolariteSoapService {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;

	@WebMethod(operationName = "listEtudiants")
	public List<Etudiant> listEtudiants(){
		return etudiantRepository.findAll();
	}
	
	@WebMethod
	public Etudiant getEtudiant(@WebParam(name = "id") Long id) {
		return etudiantRepository.findOne(id);
	}
	
	@WebMethod
	public Formation saveFormation(@WebParam(name = "formation") Formation formation) {
		return formationRepository.save(formation);
	}
}
