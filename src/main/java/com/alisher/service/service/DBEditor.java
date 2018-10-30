package com.alisher.service.service;


import com.alisher.service.dao.JdbcArticleDAO;
import com.alisher.service.pojo.Article;
import com.alisher.service.pojo.Articles;
import com.alisher.service.pojo.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class DBEditor {
    private final JdbcArticleDAO jdbcArticleDAO;

    public void saveAllArticlesFromResource() {
        ArrayList<Resource> resources = jdbcArticleDAO.getAllResources();
        resources.forEach(resource -> saveSources(resource.getUrl()));
    }

    public ArrayList<Article> getRequestArticle(String from, String to){
        String url = "https://newsapi.org/v2/top-headlines?sources=google-news-ru&from=" + from + "&to=" + to + "&apiKey=d969caa989484163b4e39a40ec0cacfe";
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
