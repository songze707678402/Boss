package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();

        String name=intent.getStringExtra("name");
        String sex=intent.getStringExtra("sex");
        int age=intent.getIntExtra("age",-1);
        TextView main2_text=(TextView) findViewById(R.id.main2_text);
        main2_text.setText(name+":"+age+":"+sex);

    }
}
