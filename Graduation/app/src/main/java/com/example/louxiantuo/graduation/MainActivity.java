package com.example.louxiantuo.graduation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Client mClient = new Client();

    TextView textView_wifiState1;
    TextView textView_machineState1;

    int wifiState1 = 0;
    int machineState1 = 0;
    long ptime = System.currentTimeMillis();
    long ctime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        mClient.start();
        textView_wifiState1 = (TextView) findViewById(R.id.WifiState1);
        textView_machineState1 = (TextView) findViewById(R.id.MachineState1);
        textView_wifiState1.setText("设备未连接");
        textView_machineState1.setText("设备未启动");
        Button button_turnon1  = (Button) findViewById(R.id.TurnOn1);
        button_turnon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("1",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送成功",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff1 = (Button) findViewById(R.id.TurnOff1);
        button_turnoff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("0",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送成功",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_flash = (Button)findViewById(R.id.flash);
        button_flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("0",UrlData.topic_out);
                Toast.makeText(MainActivity.this,"刷新成功",Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void check(MessageEvent messageEvent)
    {
        String wifiState1_true = "WifiState1:true";
        //String wifiState1_flase = "WifiState1:flase";
        String machineState1_true = "MachineState1:true";
        String machineState1_flase = "MachineState1:flase";

        if(messageEvent.getMessage().equals(wifiState1_true))
        {
            if(wifiState1 == 0){
                textView_wifiState1.setText("设备已连接");
                wifiState1 = 1;
            }

            ptime = System.currentTimeMillis();
        }

        if((ctime = System.currentTimeMillis()) - ptime > 3000)
            if(wifiState1 == 1)
            {
                textView_wifiState1.setText("设备未连接");
                wifiState1 = 0;
            }

        if(messageEvent.getMessage().equals(machineState1_true))
            if (machineState1 == 0)
            {
                textView_machineState1.setText("设备已开启");
                machineState1 = 1;
            }

        if(messageEvent.getMessage().equals(machineState1_flase))
            if (machineState1 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState1.setText("设备未启动");
                machineState1 = 0;
            }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(final MessageEvent messageEvent) {
        //Toast.makeText(MainActivity.this,messageEvent.getMessage(),Toast.LENGTH_SHORT).show();
        new Thread(){
            @Override
            public void run()
            {
                check(messageEvent);
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
