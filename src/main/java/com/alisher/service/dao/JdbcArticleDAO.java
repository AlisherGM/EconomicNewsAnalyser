package com.alisher.service.dao;

import com.alisher.service.pojo.Article;
import com.alisher.service.pojo.Articles;
import com.alisher.service.pojo.Resource;
import com.alisher.service.pojo.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class JdbcArticleDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Random siq = new Random();

    //language=SQL
    private static final String GET_ALL_ARTICLES_REQUEST = "select " +
            "* " +
            "from articles;";

    //language=SQL
    private static final String INSERT_INTO_ARTICLES_REQUEST = "insert " +
            "into articles(" +
            "       source, " +
            "       author, " +
            "       title, " +
            "       description, " +
            "       url, " +
            "       urltoimage, " +
            "       publishedat" +
            "   ) " +
            "values " +
            "   (?,?,?,?,?,?,?) " +
            "on conflict do nothing;";

    //language=SQL
    private static final String GET_ALL_RESOURCES_REQUEST = "select * " +
            "from resources";

    //language=SQL
    private static final String INSERT_INTO_PHRASES_REQUEST = "insert " +
            "into phrases(" +
            "       article_id, " +
            "       description" +
            "   ) " +
            "values (?, ?) " +
            "on conflict do nothing";

    //language=SQL
    private static final String DELETE_ALL = "delete " +
            "from phrases; " +
            "delete from articles;";

    //language=SQL
    private static final String GET_ALL_PHRASES_REQUEST = "select " +
            "* " +
            "from phrases;";

    //language=SQL
    private static final String INSERT_INTO_IMPORTSLES_REQUEST = "insert " +
            "into imports(" +
            "       source, " +
            "       author, " +
            "       title, " +
            "       description, " +
            "       url, " +
            "       urltoimage, " +
            "       publishedat" +
            "   ) " +
            "values (?,?,?,?,?,?,?) " +
            "on conflict do nothing;";

    public ArrayList<Article> getAllArticles() {
        return new ArrayList<Article>(jdbcTemplate.query(GET_ALL_ARTICLES_REQUEST, (rs, rowNum) -> {
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

    public void insertIntoArticles(Articles articles) {
        List<Object[]> list = new ArrayList<>();
        for (Article article : articles.getArticles())
            list.add(new Object[]{article.getSource().getName(), article.getAuthor(), article.getTitle(), article.getDescription(), article.getUrl(), article.getUrlToImage(), article.getPublishedAt()});
        jdbcTemplate.batchUpdate(INSERT_INTO_ARTICLES_REQUEST, list);
    }

    public ArrayList<Resource> getAllResources() {
        return new ArrayList<>(jdbcTemplate.query(GET_ALL_RESOURCES_REQUEST, ((resultSet, i) ->
                new Resource(
                        resultSet.getLong("id"),
                        resultSet.getString("url"),
                        resultSet.getString("description")
                )
        )));
    }

    public void insertIntoPhrases(Articles articles) {
        List<Object[]> list = new ArrayList<>();
        for (Article article : articles.getArticles())
            list.add(new Object[]{siq.nextInt(1000), article.getTitle()});
        jdbcTemplate.batchUpdate(INSERT_INTO_PHRASES_REQUEST, list);
    }

    public void deleteAll() {
        jdbcTemplate.update(DELETE_ALL);
    }

    public ArrayList<Article> getAllPhrases() {
        return new ArrayList<>(jdbcTemplate.query(GET_ALL_ARTICLES_REQUEST, (rs, rowNum) ->
                new Article(
                        rs.getLong("id"),
                        new Source(rs.getString("source").toLowerCase(), rs.getString("source").toUpperCase()),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("url"),
                        rs.getString("urltoimage"),
                        rs.getDate("publishedat")
                )
        ));
    }

    public ArrayList<Article> getAllImportedSources() {
        return new ArrayList<Article>(jdbcTemplate.query(GET_ALL_ARTICLES_REQUEST, (rs, rowNum) ->
                new Article(
                        rs.getLong("id"),
                        new Source(rs.getString("source").toLowerCase(), rs.getString("source").toUpperCase()),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("url"),
                        rs.getString("urltoimage"),
                        rs.getDate("publishedat")
                )
        ));
    }

    public void insertIntoImportedSources(Articles articles) {
        List<Object[]> list = new ArrayList<>();
        for (Article article : articles.getArticles())
            list.add(new Object[]{article.getSource().getName(), article.getAuthor(), article.getTitle(), article.getDescription(), article.getUrl(), article.getUrlToImage(), article.getPublishedAt()});
        jdbcTemplate.batchUpdate(INSERT_INTO_ARTICLES_REQUEST, list);
    }
}