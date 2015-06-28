package com.latihan.example.hitapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Alvin on 28/06/2015.
 */
public class HitAPI {

    public static String hit(String uri){
        BufferedReader br = null;
        String line;

        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();

            br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while((line=br.readLine()) != null){
                sb.append(line + "\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
