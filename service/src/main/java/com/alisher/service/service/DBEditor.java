package com.alisher.service.service;


import com.alisher.service.dao.JdbcArticleDAO;
import com.alisher.service.pojo.Article;
import com.alisher.service.pojo.Articles;
import com.alisher.service.pojo.Resource;
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
public class DBEditor {
    @Autowired
    private JdbcArticleDAO jdbcArticleDAO;

    public void showAllArticles() {
        jdbcArticleDAO.getAllArticles().forEach(System.out::println);
    }

    public void saveAllArticlesFromResource() {
        ArrayList<Resource> resources = jdbcArticleDAO.getAllResources();
        resources.forEach(resource -> saveSources(resource.getUrl()));
    }

    private void saveSources(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Articles articles = restTemplate.getForObject(url, Articles.class);
//            jdbcArticleDAO.deleteAll();
            jdbcArticleDAO.insertIntoArticles(articles);
            jdbcArticleDAO.insertIntoPhrases(articles);
        } catch (Exception e) {

        }
    }
}
