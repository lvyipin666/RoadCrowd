package com.example.administrator.roadcrowd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import java.util.List;

public class MyView extends View {
    int a[] = new int[7];//存放七条路的状态
    private List<RoadList.Road>list;
    private Context context;

    public MyView(Context context, List<RoadList.Road>list) {
        super(context);
        this.list = list;
        this.context = context;
        for (int i=0;i<list.size();i++){
            a[i]=Integer.parseInt(list.get(i).getStatus());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //学院路
        Paint paint0 = new Paint();
        paint0.setAntiAlias(true);//抗锯齿
        if (a[0] == 1){
            paint0.setColor(getResources().getColor(R.color.green));
        }
        if (a[0] == 2){
            paint0.setColor(getResources().getColor(R.color.yellow));
        }
        if (a[0] == 3){
            paint0.setColor(getResources().getColor(R.color.orange));
        }
        if (a[0] == 4){
            paint0.setColor(getResources().getColor(R.color.red));
        }
        paint0.setAlpha(255);
        paint0.setStrokeWidth(20);
        paint0.setStyle(Paint.Style.STROKE);
        Path path0 = new Path();
        path0.moveTo(300,80);
        path0.lineTo(300,450);
        canvas.drawPath(path0,paint0);
        //联想路
        Paint paint1 = new Paint();
        paint1.setAntiAlias(true);
        if (a[1]==1){
            paint1.setColor(getResources().getColor(R.color.green));
        }
        if (a[1]==2){
            paint1.setColor(getResources().getColor(R.color.yellow));
        }
        if (a[1]==3){
            paint1.setColor(getResources().getColor(R.color.orange));
        }
        if (a[1]==4){
            paint1.setColor(getResources().getColor(R.color.red));
        }
        paint1.setAlpha(255);
        paint1.setStrokeWidth(20);
        paint1.setStyle(Paint.Style.STROKE);
        Path path1 = new Path();
        path1.moveTo(520,80);
        path1.lineTo(520,450);
        canvas.drawPath(path1,paint1);
        //医院路
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        if (a[2]==1){
            paint2.setColor(getResources().getColor(R.color.green));
        }
        if (a[2]==2){
            paint2.setColor(getResources().getColor(R.color.yellow));
        }
        if (a[2]==3){
            paint2.setColor(getResources().getColor(R.color.orange));
        }
        if (a[2]==4){
            paint2.setColor(getResources().getColor(R.color.red));
        }
        paint2.setAlpha(255);
        paint2.setStrokeWidth(20);
        paint2.setStyle(Paint.Style.STROKE);
        Path path2 = new Path();
        path2.moveTo(520,480);
        path2.lineTo(520,840);
        canvas.drawPath(path2,paint2);
        //幸福路
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        if (a[3]==1){
            paint3.setColor(getResources().getColor(R.color.green));
        }
        if (a[3]==2){
            paint3.setColor(getResources().getColor(R.color.yellow));
        }
        if (a[3]==3){
            paint3.setColor(getResources().getColor(R.color.orange));
        }
        if (a[3]==4){
            paint3.setColor(getResources().getColor(R.color.red));
        }
        paint3.setAlpha(255);
        paint3.setStrokeWidth(20);
        paint3.setStyle(Paint.Style.STROKE);
        Path path3 = new Path();
        path3.moveTo(300,480);
        path3.lineTo(300,840);
        canvas.drawPath(path3,paint3);

        //环城快速路
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        if (a[4]==1){
            paint4.setColor(getResources().getColor(R.color.green));
        }
        if (a[4]==2){
            paint4.setColor(getResources().getColor(R.color.yellow));
        }
        if (a[4]==3){
            paint4.setColor(getResources().getColor(R.color.orange));
        }
        if (a[4]==4){
            paint4.setColor(getResources().getColor(R.color.red));
        }
        paint4.setAlpha(255);
        paint4.setStrokeWidth(20);
        paint4.setStyle(Paint.Style.STROKE);
        Path path4 = new Path();
        path4.moveTo(950,70);
        path4.lineTo(80,70);
        path4.lineTo(80,840);
        path4.lineTo(950,840);
        canvas.drawPath(path4,paint4);
        //环城高速
        Paint paint5 = new Paint();
        paint5.setAntiAlias(true);
        if (a[5]==1){
            paint5.setColor(getResources().getColor(R.color.green));
        }
        if (a[5]==2){
            paint5.setColor(getResources().getColor(R.color.yellow));
        }
        if (a[5]==3){
            paint5.setColor(getResources().getColor(R.color.orange));
        }
        if (a[5]==4){
            paint5.setColor(getResources().getColor(R.color.red));
        }
        paint5.setAlpha(255);
        paint5.setStrokeWidth(20);
        paint5.setStyle(Paint.Style.STROKE);
        Path path5 = new Path();
        path5.moveTo(950,70);
        path5.lineTo(950,840);
        canvas.drawPath(path5,paint5);
        //停车场路
        Paint paint6 = new Paint();    //创建一个画笔
        paint6.setAntiAlias(true);    //设置使用抗锯齿功能
        if (a[6] == 1){
            paint6.setColor(getResources().getColor(R.color.green));
        }
        if (a[6] == 2){
            paint6.setColor(getResources().getColor(R.color.yellow));
        }
        if (a[6] == 3){
            paint6.setColor(getResources().getColor(R.color.orange));
        }
        if (a[6] == 4) {
            paint6.setColor(getResources().getColor(R.color.red));
        }
        paint6.setAlpha(255);
        paint6.setStrokeWidth(20);        //设置笔触的宽度
        paint6.setStyle(Paint.Style.STROKE);    //设置填充样式为描边
        //绘制折线路径
        Path pathLine6 = new Path();        //创建并实例化一个Path对象
        pathLine6.moveTo(750, 70);        //设置起始点
        pathLine6.lineTo(750, 860);        //设置第一段直线的结束点
        canvas.drawPath(pathLine6, paint6);    //绘制路径


        //路名字
        Paint paintText = new Paint();        //创建一个采用默认设置的画笔
        paintText.setColor(Color.BLACK);        //设置画笔颜色
        paintText.setTextAlign(Paint.Align.LEFT);    //设置文字左对齐
        paintText.setTextSize(25);        //设置文字大小
        paintText.setAntiAlias(true);    //使用抗锯齿功能
        int x1 = 130;
        int x2 = 70;
        int x3 = 35;
        int x4 = 80;
        int x5 = 960;
        int x6 = 950;
        float[] pos1 = new float[]{x3+35, x2 + 40, x3+35, x2 + 80, x3+35, x2 + 120, x3+35, x2 + 160, x3+35, x2 + 200};    //定义代表文字位置的数组
        canvas.drawPosText("环城快速路", pos1, paintText);            //通过drawPosText()方法绘制文字
        float[] pos2 = new float[]{x1, x4, x1 + 40, x4, x1 + 80, x4, x1 + 120, x4, x1 + 160, x4};
        canvas.drawPosText("环城快速路", pos2, paintText);
        float[] pos3 = new float[]{x1, x5, x1 + 40, x5, x1 + 80, x5, x1 + 120, x5, x1 + 160, x5};    //定义代表文字位置的数组
        canvas.drawPosText("环城快速路", pos3, paintText);
        float[] pos4 = new float[]{x6, x2 + 40, x6, x2 + 80, x6, x2 + 120, x6, x2 + 160};    //定义代表文字位置的数组
        canvas.drawPosText("环城高速", pos4, paintText);
        float[] pos5 = new float[]{300, 160, 300, 200, 300, 240};    //定义代表文字位置的数组
        canvas.drawPosText("学院路", pos5, paintText);
        float[] pos6 = new float[]{520, 160, 520, 200, 520, 240};    //定义代表文字位置的数组
        canvas.drawPosText("联想路", pos6, paintText);
        float[] pos7 = new float[]{300, 580, 300, 620, 300, 660};    //定义代表文字位置的数组
        canvas.drawPosText("幸福路", pos7, paintText);
        float[] pos8 = new float[]{520, 580, 520, 620, 520, 660};    //定义代表文字位置的数组
        canvas.drawPosText("医院路", pos8, paintText);
    }

}
