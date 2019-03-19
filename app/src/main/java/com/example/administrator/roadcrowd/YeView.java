package com.example.administrator.roadcrowd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.List;

public class YeView extends View {
    int a[]=new int[7];
    private List<RoadList.Road>list;
    private Context context;

    public YeView(Context context, List<RoadList.Road> list) {
        super(context);
        this.list = list;
        this.context = context;
        for (int i=0;i<list.size();i++){
            a[i]=Integer.parseInt(list.get(i).getStatus());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint0 = new Paint();
        paint0.setAntiAlias(true);
        if (a[0]==1){
            paint0.setColor(getResources().getColor(R.color.green));
        }
        if (a[0]==2){
            paint0.setColor(getResources().getColor(R.color.yellow));
        }
        if (a[0]==3){
            paint0.setColor(getResources().getColor(R.color.orange));
        }
        if (a[0]==4){
            paint0.setColor(getResources().getColor(R.color.red));
        }
        paint0.setAlpha(255);

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

        canvas.drawRect(0,0,150,20,paint0);
        canvas.drawRect(150,0,300,20,paint1);
        canvas.drawRect(300,0,450,20,paint2);
    }
}
