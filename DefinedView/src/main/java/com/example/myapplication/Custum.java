package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 宋泽港 on 2016/12/27.
 */

public class Custum extends View{

    private Paint p;
    private Rect rect;
    private float r;
    private int width;
    private int height;

    public float getR() {
        return r;
    }

    public Custum(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public Custum(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }
    public Custum(Context context) {
        super(context,null);
    }
    //测量方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
      int widthSize=MeasureSpec.getSize(widthMeasureSpec);
//          heightMode = MeasureSpec.getMode(heightMeasureSpec);//
       // int heightSize= MeasureSpec.getSize(heightMeasureSpec);

       int width,height;
        if(widthMode == MeasureSpec.EXACTLY){
            width = widthSize;

            r = width/2;
        }else {
            width =100;
            r =width/2;
        }
        setMeasuredDimension(width,width);
    }
    //创建画笔
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Paint() p=new Paint();
        p= new Paint();
        rect= new Rect();
        width =getWidth();
        height =getHeight();
        p.setColor(Color.YELLOW);
        canvas.drawCircle(width/2,height/2,r,p);
        p.setColor(Color.BLUE);
        canvas.drawCircle(width/2,height/2,r/2,p);
        p.setColor(Color.BLACK);
        p.setTextSize(20);
        String str="下一步";
        p.getTextBounds(str,0,str.length(),rect);
        canvas.drawText(str,width/2-rect.width()/2,height/2+rect.height()/2,p);
    }//activitypackage



}
