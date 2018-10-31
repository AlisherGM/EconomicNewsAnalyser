package com.alisher.service.service;

import com.alisher.service.dao.JdbcArticleDAO;
import com.alisher.service.pojo.Article;
import com.alisher.service.pojo.Articles;
import com.alisher.service.pojo.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class DBEditor {
    private static final String START_URL = "https://newsapi.org/v2/top-headlines?sources=google-news-ru&from=";
    private static final String TRANSIT_URL = "&to=";
    private static final String END_URL = "&apiKey=d969caa989484163b4e39a40ec0cacfe";
    private final JdbcArticleDAO jdbcArticleDAO;
    
    public void saveAllArticlesFromResource() {
        ArrayList<Resource> resources = jdbcArticleDAO.getAllResources();
        resources.forEach(resource -> saveSources(resource.getUrl()));
    }

    public ArrayList<Article> getRequestArticle(String from, String to){
        String url = START_URL + from + TRANSIT_URL + to + END_URL;
        RestTemplate restTemplate = new RestTemplate();
        Articles articles = restTemplate.getForObject(url, Articles.class);
        jdbcArticleDAO.insertIntoImportedSources(articles);
        return jdbcArticleDAO.getAllImportedSources();
    }

    private void saveSources(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Articles articles = restTemplate.getForObject(url, Articles.class);
//            jdbcArticleDAO.deleteAll();
            jdbcArticleDAO.insertIntoArticles(articles);
            jdbcArticleDAO.insertIntoPhrases(articles);
        } catch (Exception ignore) {
        }
    }
}
