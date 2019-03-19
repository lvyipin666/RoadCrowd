package com.example.administrator.roadcrowd;

import android.os.Handler;
import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GetRoadThread extends Thread{
    private String url="http://118.25.27.11:8080/jsonProject/servlet/JsonAction";
    Map<String,String> map = new HashMap<String,String>();
    Handler handler;

    public GetRoadThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();
        map.put("action_flag", "yongdus");
        while (true){
            try {
                HttpUtils.postmap(url, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        try {
                            Message message = Message.obtain();
                            message.what=1;
                            message.obj=getBean(response.body().string());
                            handler.sendMessage(message);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },map);
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private RoadList getBean(String str)throws JSONException {
        JSONArray array = new JSONArray(str);
        RoadList list = new RoadList();
        List<RoadList.Road> items = new ArrayList<>();
        for (int i=0;i<array.length();i++){
            JSONObject jsonObject = array.getJSONObject(i);
            RoadList.Road road = new RoadList.Road();
            road.setRoadid(jsonObject.getString("id"));
            road.setRoadname(jsonObject.getString("roadname"));
            road.setStatus(jsonObject.getString("status"));
            items.add(road);
        }
        list.setList(items);
        return list;
    }
}
