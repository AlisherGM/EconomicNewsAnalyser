package com.alisher.service.controllers;

import com.alisher.service.dao.JdbcArticleDAO;
import com.alisher.service.pojo.Article;
import com.alisher.service.service.DBEditor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class ArticlesController {
    private final DBEditor dbEditor;
    private final JdbcArticleDAO jdbcArticleDAO;

    @GetMapping("/index")
    public String getHomePage(ModelMap model) {
        model.addAttribute("articlesFromServer", jdbcArticleDAO.getAllArticles().subList(1, 17));
        return "index";
    }

    @GetMapping("/phrases")
    public String getAllPhrases(ModelMap model) {
        dbEditor.saveAllArticlesFromResource();
        model.addAttribute("phrasesFromServer", jdbcArticleDAO.getAllPhrases());
        return "phrases";
    }

    @PostMapping("/phrasesByDate")
    public String getAllPhrasesByDatetime(@RequestBody String date, ModelMap model){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String to = dtf.format(now);
        String from = date.substring(10,20);
        System.out.println(to + " " + from);
        ArrayList<Article> list = dbEditor.getRequestArticle(from, to);
        model.addAttribute("phrasesFromServer", list.subList(2, list.size()));
        return "phrases";
    }
}


