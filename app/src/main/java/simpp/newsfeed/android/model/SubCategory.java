package simpp.newsfeed.android.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by user on 9/3/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubCategory {
    private String category_id;
    private String display_subcategory_name;
    private String english_subcategory_name;
    private String subcategory_id;
    private String url_subcategory_name;

    public String getUrl_subcategory_name() {
        return url_subcategory_name;
    }

    public void setUrl_subcategory_name(String url_subcategory_name) {
        this.url_subcategory_name = url_subcategory_name;
    }

    public String getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(String subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public String getEnglish_subcategory_name() {
        return english_subcategory_name;
    }

    public void setEnglish_subcategory_name(String english_subcategory_name) {
        this.english_subcategory_name = english_subcategory_name;
    }

    public String getDisplay_subcategory_name() {
        return display_subcategory_name;
    }

    public void setDisplay_subcategory_name(String display_subcategory_name) {
        this.display_subcategory_name = display_subcategory_name;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
}
