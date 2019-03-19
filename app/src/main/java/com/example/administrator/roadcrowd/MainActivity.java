package com.example.administrator.roadcrowd;

import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView oneroad,tworoad,threeroad;
    private ImageView dt;
    private AnimationDrawable animationDrawable;
    private FrameLayout myFrameLayout;
    private FrameLayout yeFrameLayout;
    private String RoadStatus[]={"","","","","","",""};
    private MyView myView;
    private YeView yeView;
    private Handler handler;
    private List<RoadList.Road> list;
    private int NOTIFYID=12345;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        RoadList roadList = (RoadList)msg.obj;
                        list = roadList.getList();
                        for (int i=0;i<list.size();i++){
                            switch (Integer.parseInt(list.get(i).getStatus())){
                                case 1:
                                    RoadStatus[i]="畅通";
                                    break;
                                case 2:
                                    RoadStatus[i]="缓行";
                                    break;
                                case 3:
                                    RoadStatus[i]="一般拥堵";
                                    break;
                                case 4:
                                    RoadStatus[i]="拥堵";
                                    sendnotify(list.get(i).getRoadname());
                                    break;
                            }
                        }
                        oneroad.setText(RoadStatus[0]);
                        tworoad.setText(RoadStatus[1]);
                        threeroad.setText(RoadStatus[2]);
                        myView = new MyView(MainActivity.this,list);
                        myFrameLayout.addView(myView);
                        yeView = new YeView(MainActivity.this,list);
                        yeFrameLayout.addView(yeView);
                        break;
                }
            }
        };
    }

    private void sendnotify(String name) {
        //获取通知管理器，用于发送通知
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(MainActivity.this); // 创建一个Notification对象
        // 设置打开该通知，该通知自动消失
        notification.setAutoCancel(true);
        // 设置显示在状态栏的通知提示信息
        notification.setTicker("交通预警");
        // 设置通知的小图标
        notification.setSmallIcon(R.mipmap.ic_launcher);
        //设置下拉列表中的大图标
        notification.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        // 设置通知内容的标题
        notification.setContentTitle(name+"交通拥堵!");
        // 设置通知内容
        notification.setContentText(name+"交通拥堵，请大家绕行！");
        //设置发送时间
        notification.setWhen(System.currentTimeMillis());
        // 创建一个启动其他Activity的Intent
        //  Intent intent = new Intent(MainActivity.this, MessageActivity.class);
        // PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        //设置通知栏点击跳转
        // notification.setContentIntent(pi);
        //发送通知
        notificationManager.notify(NOTIFYID, notification.build());

    }

    private void initView() {
        oneroad = (TextView)findViewById(R.id.oneroad);
        tworoad = (TextView)findViewById(R.id.tworoad);
        threeroad = (TextView)findViewById(R.id.threeroad);
        myFrameLayout = (FrameLayout)findViewById(R.id.roaddraw);
        yeFrameLayout = (FrameLayout)findViewById(R.id.roadcolor);
        dt = (ImageView)findViewById(R.id.dt);
        dt.setImageResource(R.drawable.dt);
        animationDrawable =(AnimationDrawable)dt.getDrawable();
        animationDrawable.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        new GetRoadThread(handler).start();
    }
}
