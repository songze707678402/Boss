package com.example.song;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private String JSON_URL = "http://op.juhe.cn/robot/index?info=%E4%BD%A0%E5%A5%BD&dtype=&loc=&lon=&lat=&userid=&key=5fa0f2822ec46e2e589b9a89be35a7b3";
    private TextView main_text;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_text = (TextView) findViewById(R.id.main_text);
        getHttp();

    }

    public void getHttp() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson =  new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                String text = bean.getResult().getText();
//                Message msg=Message.obtain();


                main_text.setText(text);
//                handler.sendMessage(msg);

            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        requestQueue.add(request);
    }
//    Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            Bean bean= (Bean) msg.obj;
//           bean.getResult().getText();
//
//        }
//    };


}
