package com.alisher.service.controllers;

import com.alisher.service.dao.JdbcArticleDAO;
import com.alisher.service.service.DBEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class ArticlesController {
    @Autowired
    private DBEditor dbEditor;

    @Autowired
    private JdbcArticleDAO jdbcArticleDAO;

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

    @PostMapping("/phrases")
    public String getAllPhrasesByDatetime(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date date, ModelMap model){
        System.out.println(date);
        model.addAttribute("phrasesFromServer", jdbcArticleDAO.getAllPhrases());
        return "phrases";
    }
}


