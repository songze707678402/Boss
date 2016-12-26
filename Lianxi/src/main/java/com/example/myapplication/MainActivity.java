package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    private EditText main_xingming;
    private EditText mima;
    private EditText main_nianling;
    private Button main_zhuce;
    private RadioGroup rg_sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        initData(View v);

    }



    private void initView() {
        main_xingming = (EditText) findViewById(R.id.main_xingming);
        mima = (EditText) findViewById(R.id.main_mima);
        main_nianling = (EditText)findViewById(R.id.mian_nianling);
        rg_sex = (RadioGroup)findViewById(R.id.rg_sex);
        main_zhuce = (Button)findViewById(R.id.main_zhuce);
    }
    public void initData(View v) {
        String name=main_xingming.getText().toString().trim();
        String str_age=main_nianling.getText().toString().trim();
        int age=0;
       if (!TextUtils.isEmpty(str_age)){
            age=Integer.parseInt(main_nianling.getText().toString().trim());

       }

        String password=mima.getText().toString().trim();
        int checkedRadioButtonId = rg_sex.getCheckedRadioButtonId();
        String sex=null;
        switch (checkedRadioButtonId){
            case R.id.rb_nan:
                sex="男";
                break;
            case R.id.rb_nv:
                sex="女";
                break;

        }
        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(str_age+"")||TextUtils.isEmpty(password)||TextUtils.isEmpty(sex)){
            Toast.makeText(this,"请将信息填写完整",Toast.LENGTH_LONG).show();
            return;
        }
        //将获取的信息跳转传到第二个Activity
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        //在意图上添加内容
        intent.putExtra("name",name);
        intent.putExtra("sex",sex);
        intent.putExtra("age",age);

        startActivity(intent);



    }





}
