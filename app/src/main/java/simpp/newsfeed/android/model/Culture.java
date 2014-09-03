package simpp.newsfeed.android.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by user on 9/3/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Culture {
    private String culture_code;
    private String display_culture_name;
    private String english_culture_nam;

    public String getEnglish_culture_nam() {
        return english_culture_nam;
    }

    public void setEnglish_culture_nam(String english_culture_nam) {
        this.english_culture_nam = english_culture_nam;
    }

    public String getDisplay_culture_name() {
        return display_culture_name;
    }

    public void setDisplay_culture_name(String display_culture_name) {
        this.display_culture_name = display_culture_name;
    }

    public String getCulture_code() {
        return culture_code;
    }

    public void setCulture_code(String culture_code) {
        this.culture_code = culture_code;
    }
}


