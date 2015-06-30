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

import com.latihan.example.hitapi.CustomAdapter;
import com.latihan.example.hitapi.CustomBaseAdapter;
import com.latihan.example.hitapi.HitAPI;
import com.latihan.example.hitapi.JSONHandler;
import com.latihan.example.hitapi.R;
import com.latihan.example.hitapi.com.latihan.example.hitapi.object.JSONList;
import com.latihan.example.hitapi.com.latihan.example.hitapi.object.ResObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {

    TextView tv;
    ListView lv;
    List<String> list;
    List<ResObject> targetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textview);
        tv.setMovementMethod(new ScrollingMovementMethod());

        String uri = "https://api.github.com/users/rheno/repos";

        new HitTask().execute(uri, "Param");

        lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(MainActivity.this, WebActivity.class);
                i.putExtra("targetUrl", targetList.get(position).getHtml_url());
                startActivity(i);

//                Toast.makeText(getApplicationContext(),
//                        targetList.get(position), Toast.LENGTH_SHORT).show();
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

    public String elips(String str){
        if(str.length() > 10){
            str = str.substring(0, 10)+"...";
        }
        return str;
    }

    private class HitTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            return HitAPI.hit(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                //s = hasil return dari doInBackground
                ArrayList<ResObject> rol = JSONHandler.parseJSON(s);
//                String res;

//                list = new ArrayList<>();
//                targetList = new ArrayList<>();
//                for (int i = 0; i < rol.size(); i++) {
//                    res = "";
//                    res += "name = "+rol.get(i).getName();
//                    res += "\n";
//                    res += "avatar_url = "+rol.get(i).getOwner().getAvatar_url();
//                    res += "\n";
//                    res += "description = "+elips(rol.get(i).getDescription());
//                    list.add(res);
//                    targetList.add(rol.get(i).getHtml_url());
//                }

                setListAdapter(new CustomBaseAdapter(MainActivity.this, rol));
                targetList = rol;

            } catch (NullPointerException e){
                appendText("null");
            }
        }
    }
}
