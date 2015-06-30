package com.latihan.example.hitapi;

import com.google.gson.Gson;
import com.latihan.example.hitapi.com.latihan.example.hitapi.object.JSONList;
import com.latihan.example.hitapi.com.latihan.example.hitapi.object.ResObject;

import java.util.ArrayList;

/**
 * Created by Alvin on 28/06/2015.
 */
public class JSONHandler {
    public static JSONList parseJSON(String json){

        JSONList list;
        Gson gson = new Gson();
        list = gson.fromJson(json, JSONList.class);

        return list;
    }
}
