package com.latihan.example.hitapi.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.latihan.example.hitapi.HitAPI;
import com.latihan.example.hitapi.JSONHandler;
import com.latihan.example.hitapi.R;
import com.latihan.example.hitapi.ResObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {

    TextView tv;
    ListView lv;
    List<String> list;
    String targetUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textview);
        tv.setMovementMethod(new ScrollingMovementMethod());

        String earthquakeUri = "http://api.geonames.org/earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username=aporter";
        String apiGithubUri = "https://api.github.com";

        new HitTask().execute(apiGithubUri, "Param");

        lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(MainActivity.this, WebActivity.class);
                i.putExtra("targetUrl", targetUrl);
                startActivity(i);

//                Toast.makeText(getApplicationContext(),
//                        id+""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void appendText(String str){
        try {
            tv.append(str);
        }catch(NullPointerException e){
            tv.append("null");
        }
    }

    public void setTargetUrl(String url){
        targetUrl = url;
    }

    private class HitTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            return HitAPI.hit(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            //s = hasil return dari doInBackground
            ResObject ro = JSONHandler.parseJSON(s);
            String res = "";
            res += ro.getAuthorizations_url();
            res += "\n";
            res += ro.getCode_search_url();
            res += "\n";
            res += ro.getCurrent_user_authorizations_html_url();
            res += "\n";
            res += ro.getCurrent_user_url();
            res += "\n";
            res += ro.getEmails_url();
            res += "\n";
            res += ro.getEmojis_url();
            res += "\n";

            list = new ArrayList<>();
            list.add(ro.getAuthorizations_url());
            list.add(ro.getCode_search_url());
            list.add(ro.getCurrent_user_authorizations_html_url());
            list.add(ro.getCurrent_user_url());
            list.add(ro.getEmails_url());

            setTargetUrl(ro.getEmojis_url());

            setListAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list));
//            appendText(res);
        }
    }
}
