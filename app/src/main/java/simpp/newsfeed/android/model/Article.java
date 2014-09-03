package simpp.newsfeed.android.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by user on 9/3/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    private String url;
    private String title;
    private String summary;
    private String publish_date;
    private String author;
    private String source;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}