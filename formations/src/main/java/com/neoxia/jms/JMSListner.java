package com.neoxia.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.neoxia.dao.EtudiantRepository;
import com.neoxia.entities.Etudiant;

@Component
public class JMSListner {
	
	@Autowired
	private EtudiantRepository etudiantRepository;

	@JmsListener(destination = "scolarite.queue")
	public void recieve(Message message) throws JMSException {
		if(message instanceof TextMessage) {
			String contenue = ((TextMessage) message).getText();
			System.out.println("======================================================");
			System.out.println("[Broker] ==== Reception de message : " + contenue);
			System.out.println("======================================================");
			Etudiant etudiant = new Etudiant();
			etudiant.setNom(contenue.split("_")[0]);
			etudiant.setPrenom(contenue.split("_")[1]);
			etudiantRepository.save(etudiant);
		}
	}
}
