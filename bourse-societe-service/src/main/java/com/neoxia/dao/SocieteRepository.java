package com.neoxia.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.neoxia.entities.Societe;

@RepositoryRestResource
public interface SocieteRepository extends JpaRepository<Societe, Long>{
	@Query("select s from Societe s where s.nomSociete like :mc")
	public Page<Societe> societeParMC(@Param(value = "mc") String mc, Pageable pageable);
}
