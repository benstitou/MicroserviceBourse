package com.neoxia.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neoxia.ArticleClient;
import com.neoxia.dao.EtudiantRepository;
import com.neoxia.entities.Etudiant;
import com.neoxia.wsdl.AddArticleResponse;
import com.neoxia.wsdl.ArticleInfo;
import com.neoxia.wsdl.DeleteArticleResponse;
import com.neoxia.wsdl.GetArticleByIdResponse;
import com.neoxia.wsdl.ServiceStatus;
import com.neoxia.wsdl.UpdateArticleResponse;

@RestController
public class EtudiantRestController {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@GetMapping("/etudiants")
	public List<Etudiant> listEtudiants() {
		return etudiantRepository.findAll();
	}
	
	@GetMapping("/etudiants/{id}")
	public Etudiant getEtudiant(@PathVariable(name="id") Long id) {
		return etudiantRepository.findOne(id);
	}
	
	@PostMapping("/etudiants")
	public Etudiant saveEtudiant(@RequestBody Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
	
	@PutMapping("/etudiants/{id}")
	public Etudiant updateEtudiant(@PathVariable(name="id") Long id,@RequestBody Etudiant etudiant) {
		etudiant.setId(id);
		return etudiantRepository.save(etudiant);
	}
	
	@DeleteMapping("/etudiants/{id}")
	public boolean deleteEtudiant(@PathVariable(name="id") Long id) {
		etudiantRepository.delete(id);
		return true;
	}
	
	@GetMapping("/tests")
	public boolean test() {
		
		return true;
	}
	
	@Autowired
	private ArticleClient articleClient;
	
	@GetMapping("/getArticleById/{id}")
	public ArticleInfo getArticleById(@PathVariable(name="id") Long id) {
		
		GetArticleByIdResponse articleByIdResponse = articleClient.getArticleById(id);
		ArticleInfo articleInfo = articleByIdResponse.getArticleInfo();
		
		return articleInfo;
	}
	
	@PostMapping("/articles")
	public ArticleInfo saveArticle(@RequestBody ArticleInfo articleInfo) {
		
		AddArticleResponse addArticleResponse = articleClient.addArticle(articleInfo.getTitle(), articleInfo.getCategory());
		articleInfo = addArticleResponse.getArticleInfo();
		if (articleInfo != null) {
			System.out.println(
					articleInfo.getArticleId() + ", " + articleInfo.getTitle() + ", " + articleInfo.getCategory());
		}
		
		return articleInfo;
	}
	
	@PutMapping("/articles/{id}")
	public ArticleInfo updateArticle(@PathVariable(name="id") Long id,@RequestBody ArticleInfo articleInfo) {
		articleInfo.setArticleId(id);
		UpdateArticleResponse updateArticleResponse = articleClient.updateArticle(articleInfo);
		
		return articleInfo;
	}
	
	@DeleteMapping("/articles/{id}")
	public boolean deleteArticle(@PathVariable(name="id") Long id) {
		DeleteArticleResponse deleteArticleResponse = articleClient.deleteArticle(id);
		return true;
	}

}
