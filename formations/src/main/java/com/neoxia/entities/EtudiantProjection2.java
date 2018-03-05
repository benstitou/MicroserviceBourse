package com.neoxia.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="projection1", types= {Etudiant.class})
public interface EtudiantProjection2 {
	public Long getId();
	public String getNom();

}
