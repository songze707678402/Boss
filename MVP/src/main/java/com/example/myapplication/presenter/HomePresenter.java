package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.myapplication.application.ApplicationConstants;
import com.example.myapplication.model.api.OkHttpClientManager;
import com.example.myapplication.model.bean.Bean;
import com.example.myapplication.view.interfaces.HomeView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 宋泽港 on 2016/12/27.
 */

public class HomePresenter {
    private HomeView homeView;
    private OkHttpClientManager okHttpClientManager;
    Handler handler=new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if(msg.what==1){
                            Bean bean= (Bean) msg.obj;
                getHomeView().onSuccess(bean);
            }

        }
    };

    public void attacView(HomeView homeView){
        this.homeView=homeView;
    }
    public HomeView getHomeView(){
        return homeView;
    }
    public void lodDataFromServer(){
        String url= ApplicationConstants.LINK_MOBILE_CLASS;
        Request request=new Request.Builder().url(url).build();
        OkHttpClientManager.enqueue(request, new Callback() {
            //失败时执行的方法
            @Override
            public void onFailure(Call call, IOException e) {

            }
            //成功执行的代码
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str=response.body().string();
                Gson gson=new Gson();
                Bean bean=gson.fromJson(str,Bean.class);
                Message msg=handler.obtainMessage();
                msg.obj=bean;
                msg.what=1;
                handler.sendMessage(msg);

                //Log.e("nyMessage",""+str);
            }
        });
    }

}
