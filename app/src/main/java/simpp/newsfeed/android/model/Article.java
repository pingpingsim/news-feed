package simpp.newsfeed.android.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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
    private String source_url;
    //private Enclosure enclosures;

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

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    /*public Enclosure getEnclosures() {
        return enclosures;
    }

    public void setEnclosures(Enclosure enclosures) {
        this.enclosures = enclosures;
    }*/
}