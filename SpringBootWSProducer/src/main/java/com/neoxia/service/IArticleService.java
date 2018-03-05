package com.neoxia.service;

import java.util.List;
import com.neoxia.entity.Article;

public interface IArticleService {
	List<Article> getAllArticles();

	Article getArticleById(long articleId);

	boolean addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(Article article);
}