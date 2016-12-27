package com.example.myapplication.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.Bean;
import com.example.myapplication.presenter.HomePresenter;
import com.example.myapplication.view.interfaces.HomeView;

public class MainActivity extends AppCompatActivity implements HomeView{

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attacView(this);
        homePresenter.lodDataFromServer();
    }

    @Override
    public void onSuccess(Bean bean) {
        Log.e("myMessage","activity onSuccess"+bean.getDatas().getClass_list().get(0).getGc_name());

    }
}
