package com.neoxia.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class BourseRestService {
	
	@Value("${test}")
	private String message;
	
	@RequestMapping(value = "/messages")
	public String testConf() {
		System.out.println("---------------------");
		System.out.println("[Reponse]");
		return message;
	}
}
