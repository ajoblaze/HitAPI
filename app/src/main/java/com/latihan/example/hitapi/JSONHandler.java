package com.latihan.example.hitapi;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Created by Alvin on 28/06/2015.
 */
public class JSONHandler {
    public static ResObject parseJSON(String json){
        try {
            JSONObject obj = (JSONObject) new JSONTokener(json).nextValue();
            ResObject ro = new ResObject();

            ro.setAuthorizations_url(obj.getString("authorizations_url"));
            ro.setCode_search_url(obj.getString("code_search_url"));
            ro.setCurrent_user_authorizations_html_url(obj.getString("current_user_authorizations_html_url"));
            ro.setCurrent_user_url(obj.getString("current_user_url"));
            ro.setEmails_url(obj.getString("emails_url"));
            ro.setEmojis_url(obj.getString("emojis_url"));

            return ro;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
