package simpp.newsfeed.android.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by user on 9/3/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleList{


    private String description;
    private String syndication_url;
    private String title;
    private List<Article> articles;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSyndication_url() {
        return syndication_url;
    }

    public void setSyndication_url(String syndication_url) {
        this.syndication_url = syndication_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*



    */
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}