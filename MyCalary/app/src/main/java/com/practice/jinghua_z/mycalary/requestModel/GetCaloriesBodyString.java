package com.practice.jinghua_z.mycalary.requestModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nancy on 10/20/18.
 */

import org.json.JSONObject;

public class GetCaloriesBodyString {

    private String text;

    public GetCaloriesBodyString(String voiceInput) {
        this.text = voiceInput;
    }

    // Getter Methods
    public String getText() {
        return text;
    }

    // Setter Methods
    public void setText(String text) {
        this.text = text;
    }

}
