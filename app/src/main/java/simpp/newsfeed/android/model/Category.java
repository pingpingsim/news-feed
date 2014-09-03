package simpp.newsfeed.android.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by user on 9/3/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private String category_id;
    private String display_category_name;
    private String english_category_name;
    private String url_category_name;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDisplay_category_name() {
        return display_category_name;
    }

    public void setDisplay_category_name(String display_category_name) {
        this.display_category_name = display_category_name;
    }

    public String getEnglish_category_name() {
        return english_category_name;
    }

    public void setEnglish_category_name(String english_category_name) {
        this.english_category_name = english_category_name;
    }

    public String getUrl_category_name() {
        return url_category_name;
    }

    public void setUrl_category_name(String url_category_name) {
        this.url_category_name = url_category_name;
    }
}
