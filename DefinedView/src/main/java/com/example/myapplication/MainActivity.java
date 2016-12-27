package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
//    private Custom custum;

    private Custum custum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custum = (Custum) findViewById(R.id.c);
        custum.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //得到点击点的坐标
                    float x = event.getX();
                    float y = event.getY();//
                    float radius = custum.getR();
                    //得到相对圆心的 x y的相对距离
                    float xx = Math.abs(x - radius);
                    float yy = Math.abs(y - radius);
                    //勾股定律 计算点击点到圆心点距离
                    double disstance = Math.sqrt(xx * xx + yy * yy);
                    //判断 距离小于半径 即在圆内
                    if (disstance < radius / 2) {
                        Toast.makeText(MainActivity.this, "在小圆内", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    if (disstance > radius / 2 && disstance < radius) {
                        Toast.makeText(MainActivity.this, "在圆环内", Toast.LENGTH_SHORT).show();
                        return true;
                    } else {
                        Toast.makeText(MainActivity.this, "在圆外", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });

    }



}
