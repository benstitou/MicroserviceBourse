package com.neoxia.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.neoxia.web.EtudiantRestService;

@Configuration
public class JerseyConfig {

	//@Bean
//	public ResourceConfig getJersey() {
//		ResourceConfig config = new ResourceConfig();
//		config.register(EtudiantRestService.class);
//		return config;
//	}
}
