package com.latihan.example.hitapi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Alvin on 28/06/2015.
 */
public class JSONHandler {
    public static ArrayList<ResObject> parseJSON(String json){

        ArrayList<ResObject> list = new ArrayList<>();
        ResObject ro;

        try {
            JSONArray ar = new JSONArray(json);

            for (int i=0; i< ar.length(); i++) {
                JSONObject obj = (JSONObject) ar.get(i);
                ro = new ResObject();

                ro.setName(obj.getString("name"));
                ro.setDescription(obj.getString("description"));
                ro.setHtml_url(obj.getString("html_url"));

                JSONObject owner = obj.getJSONObject("owner");
                ro.setAvatar_url(owner.getString("avatar_url"));

                list.add(ro);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
