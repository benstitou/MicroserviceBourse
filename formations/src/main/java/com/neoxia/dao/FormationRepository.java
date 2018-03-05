package com.neoxia.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.neoxia.entities.Etudiant;
import com.neoxia.entities.Formation;

@RepositoryRestResource
public interface FormationRepository extends JpaRepository<Formation, Long>{
	
	public Page<Etudiant> findByNomContains(@Param("mc") String mc, Pageable pageable);
	
	public Page<Etudiant> findByNomStartsWith(@Param("mc") String mc, Pageable pageable);

}
