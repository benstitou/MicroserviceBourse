package com.neoxia.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="projection2", types= {Etudiant.class})
public interface EtudiantProjection {
	
	@Value("#{target.nom} #{target.prenom}")
	public String getFullName();

}
