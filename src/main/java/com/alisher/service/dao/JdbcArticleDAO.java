package com.alisher.service.dao;

import com.alisher.service.pojo.Article;
import com.alisher.service.pojo.Articles;
import com.alisher.service.pojo.Resource;
import com.alisher.service.pojo.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class JdbcArticleDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Random siq = new Random();

    //language=SQL
    private String getAllArticlesRequest = "select * from articles;";
    public ArrayList<Article> getAllArticles() {
        return new ArrayList<Article>(jdbcTemplate.query(getAllArticlesRequest, (rs, rowNum) -> {
            return new Article(
                    rs.getLong("id"),
                    new Source(rs.getString("source").toLowerCase(), rs.getString("source").toUpperCase()),
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("url"),
                    rs.getString("urltoimage"),
                    rs.getDate("publishedat")
            );
        }));
    }

    //language=SQL
    private String insertIntoArticlesRequest = "insert into articles(source, author, title, description, url, urltoimage, publishedat) values (?,?,?,?,?,?,?) on conflict do nothing;";
    public void insertIntoArticles(Articles articles) {
        List<Object[]> list = new ArrayList<>();
        for(Article article: articles.getArticles())
            list.add(new Object[]{article.getSource().getName(), article.getAuthor(), article.getTitle(), article.getDescription(), article.getUrl(), article.getUrlToImage(), article.getPublishedAt()});
        jdbcTemplate.batchUpdate(insertIntoArticlesRequest, list);
    }

    //language=SQL
    private String getAllResourcesRequest = "select * from resources";
    public ArrayList<Resource> getAllResources() {
        return new ArrayList<Resource>(jdbcTemplate.query(getAllResourcesRequest, ((resultSet, i) -> {
            return new Resource(
                    resultSet.getLong("id"),
                    resultSet.getString("url"),
                    resultSet.getString("description")
            );
        })));
    }


    //language=SQL
    private String insertIntoPhrasesRequest = "insert into phrases(article_id, description) values (?, ?) on conflict do nothing";
    public void insertIntoPhrases(Articles articles) {
        List<Object[]> list = new ArrayList<>();
        for(Article article: articles.getArticles())
            list.add(new Object[]{siq.nextInt(1000), article.getTitle()});
        jdbcTemplate.batchUpdate(insertIntoPhrasesRequest, list);
    }

    //language=SQL
    private String deleteAll="delete from phrases; delete from articles;";
    public void deleteAll(){
        jdbcTemplate.update(deleteAll);
    }

    //language=SQL
    private String getAllPhrasesRequest = "select * from phrases;";
    public ArrayList<Article> getAllPhrases() {
        return new ArrayList<Article>(jdbcTemplate.query(getAllArticlesRequest, (rs, rowNum) -> {
            return new Article(
                    rs.getLong("id"),
                    new Source(rs.getString("source").toLowerCase(), rs.getString("source").toUpperCase()),
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("url"),
                    rs.getString("urltoimage"),
                    rs.getDate("publishedat")
            );
        }));
    }

    public ArrayList<Article> getAllImportedSources() {
        return new ArrayList<Article>(jdbcTemplate.query(getAllArticlesRequest, (rs, rowNum) -> {
            return new Article(
                    rs.getLong("id"),
                    new Source(rs.getString("source").toLowerCase(), rs.getString("source").toUpperCase()),
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("url"),
                    rs.getString("urltoimage"),
                    rs.getDate("publishedat")
            );
        }));
    }

    //language=SQL
    private String insertIntoImportslesRequest = "insert into imports(source, author, title, description, url, urltoimage, publishedat) values (?,?,?,?,?,?,?) on conflict do nothing;";
    public void insertIntoImportedSources(Articles articles) {
        List<Object[]> list = new ArrayList<>();
        for(Article article: articles.getArticles())
            list.add(new Object[]{article.getSource().getName(), article.getAuthor(), article.getTitle(), article.getDescription(), article.getUrl(), article.getUrlToImage(), article.getPublishedAt()});
        jdbcTemplate.batchUpdate(insertIntoArticlesRequest, list);
    }
}