package com.neoxia.web;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neoxia.dao.EtudiantRepository;
import com.neoxia.entities.Etudiant;

@Component
public class EtudiantRestService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@GET
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> listEtudiants() {
		return etudiantRepository.findAll();
	}
	
	@GET
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiant(@PathParam(value="id") Long id) {
		return etudiantRepository.findOne(id);
	}
	
	@POST
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant saveEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
	
	@PUT
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant updateEtudiant(@PathParam(value="id") Long id, Etudiant etudiant) {
		etudiant.setId(id);
		return etudiantRepository.save(etudiant);
	}
	
	@DELETE
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteEtudiant(@PathParam(value="id") Long id) {
		etudiantRepository.delete(id);
		return true;
	}

}
