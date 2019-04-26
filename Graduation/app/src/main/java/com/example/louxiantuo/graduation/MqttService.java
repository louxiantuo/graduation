package com.example.louxiantuo.graduation;

/**
 * Created by louxiantuo on 19-3-20.
 */

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;



/**
 * Created by surine on 2017/6/29.
 */

public class MqttService extends Service {
    private Client mClient;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //启动MQTT客户端
                mClient= new Client();
                mClient.start();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        startService(new Intent(this,MqttService.class));
    }

}