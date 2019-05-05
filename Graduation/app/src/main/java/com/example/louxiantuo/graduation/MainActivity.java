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

    TextView textView_wifiState2;
    TextView textView_machineState2;
    int wifiState2 = 0;
    int machineState2 = 0;

    TextView textView_wifiState3;
    TextView textView_machineState3;
    int wifiState3 = 0;
    int machineState3 = 0;

    TextView textView_wifiState4;
    TextView textView_machineState4;
    int wifiState4 = 0;
    int machineState4 = 0;

    TextView textView_wifiState5;
    TextView textView_machineState5;
    int wifiState5 = 0;
    int machineState5 = 0;


    long ptime1 = System.currentTimeMillis();
    long ctime1;

    long ptime2 = System.currentTimeMillis();
    long ctime2;

    long ptime3 = System.currentTimeMillis();
    long ctime3;

    long ptime4 = System.currentTimeMillis();
    long ctime4;

    long ptime5 = System.currentTimeMillis();
    long ctime5;

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
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff1 = (Button) findViewById(R.id.TurnOff1);
        button_turnoff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("0",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
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

        Button button_reset =(Button)findViewById(R.id.reset);
        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试

                mClient.sendCmd("A",UrlData.topic_out);
                mClient.sendCmd("B",UrlData.topic_out);
                mClient.sendCmd("C",UrlData.topic_out);
                mClient.sendCmd("D",UrlData.topic_out);
                mClient.sendCmd("E",UrlData.topic_out);

                Toast.makeText(MainActivity.this,"重启中",Toast.LENGTH_SHORT).show();
            }
        });


        textView_wifiState2 = (TextView) findViewById(R.id.WifiState2);
        textView_machineState2 = (TextView) findViewById(R.id.MachineState2);
        textView_wifiState2.setText("设备未连接");
        textView_machineState2.setText("设备未启动");
        Button button_turnon2  = (Button) findViewById(R.id.TurnOn2);
        button_turnon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("3",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff2 = (Button) findViewById(R.id.TurnOff2);
        button_turnoff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("2",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        textView_wifiState3 = (TextView) findViewById(R.id.WifiState3);
        textView_machineState3 = (TextView) findViewById(R.id.MachineState3);
        textView_wifiState3.setText("设备未连接");
        textView_machineState3.setText("设备未启动");
        Button button_turnon3  = (Button) findViewById(R.id.TurnOn3);
        button_turnon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("5",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff3 = (Button) findViewById(R.id.TurnOff3);
        button_turnoff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("4",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        textView_wifiState4 = (TextView) findViewById(R.id.WifiState4);
        textView_machineState4 = (TextView) findViewById(R.id.MachineState4);
        textView_wifiState4.setText("设备未连接");
        textView_machineState4.setText("设备未启动");
        Button button_turnon4  = (Button) findViewById(R.id.TurnOn4);
        button_turnon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("7",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff4 = (Button) findViewById(R.id.TurnOff4);
        button_turnoff4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("6",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });


        textView_wifiState5 = (TextView) findViewById(R.id.WifiState5);
        textView_machineState5 = (TextView) findViewById(R.id.MachineState5);
        textView_wifiState5.setText("设备未连接");
        textView_machineState5.setText("设备未启动");
        Button button_turnon5  = (Button) findViewById(R.id.TurnOn5);
        button_turnon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("9",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff5 = (Button) findViewById(R.id.TurnOff5);
        button_turnoff5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("8",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void check(MessageEvent messageEvent)
    {
        String wifiState1_true = "WifiState1:true";
        String machineState1_true = "MachineState1:true";
        String machineState1_flase = "MachineState1:flase";
        String wifiState2_true = "WifiState2:true";
        String machineState2_true = "MachineState2:true";
        String machineState2_flase = "MachineState2:flase";
        String wifiState3_true = "WifiState3:true";
        String machineState3_true = "MachineState3:true";
        String machineState3_flase = "MachineState3:flase";
        String wifiState4_true = "WifiState4:true";
        String machineState4_true = "MachineState4:true";
        String machineState4_flase = "MachineState4:flase";
        String wifiState5_true = "WifiState5:true";
        String machineState5_true = "MachineState5:true";
        String machineState5_flase = "MachineState5:flase";


        if(messageEvent.getMessage().equals(wifiState1_true))
        {
            if(wifiState1 == 0){
                textView_wifiState1.setText("设备已连接");
                wifiState1 = 1;
            }

            ptime1 = System.currentTimeMillis();
        }

        if((ctime1 = System.currentTimeMillis()) - ptime1 > 3000)
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


        if(messageEvent.getMessage().equals(wifiState2_true))
        {
            if(wifiState2 == 0){
                textView_wifiState2.setText("设备已连接");
                wifiState2 = 1;
            }

            ptime2 = System.currentTimeMillis();
        }

        if((ctime2 = System.currentTimeMillis()) - ptime2 > 3000)
            if(wifiState2 == 1)
            {
                textView_wifiState2.setText("设备未连接");
                wifiState2 = 0;
            }

        if(messageEvent.getMessage().equals(machineState2_true))
            if (machineState2 == 0)
            {
                textView_machineState2.setText("设备已开启");
                machineState2 = 1;
            }

        if(messageEvent.getMessage().equals(machineState2_flase))
            if (machineState2 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState2.setText("设备未启动");
                machineState2 = 0;
            }

        if(messageEvent.getMessage().equals(wifiState3_true))
        {
            if(wifiState3 == 0){
                textView_wifiState3.setText("设备已连接");
                wifiState3 = 1;
            }

            ptime3 = System.currentTimeMillis();
        }

        if((ctime3 = System.currentTimeMillis()) - ptime3 > 3000)
            if(wifiState3 == 1)
            {
                textView_wifiState3.setText("设备未连接");
                wifiState3 = 0;
            }

        if(messageEvent.getMessage().equals(machineState3_true))
            if (machineState3 == 0)
            {
                textView_machineState3.setText("设备已开启");
                machineState3 = 1;
            }

        if(messageEvent.getMessage().equals(machineState3_flase))
            if (machineState3 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState3.setText("设备未启动");
                machineState3 = 0;
            }

        if(messageEvent.getMessage().equals(wifiState4_true))
        {
            if(wifiState4 == 0){
                textView_wifiState4.setText("设备已连接");
                wifiState4 = 1;
            }

            ptime4 = System.currentTimeMillis();
        }

        if((ctime4 = System.currentTimeMillis()) - ptime4 > 3000)
            if(wifiState4 == 1)
            {
                textView_wifiState4.setText("设备未连接");
                wifiState4 = 0;
            }

        if(messageEvent.getMessage().equals(machineState4_true))
            if (machineState4 == 0)
            {
                textView_machineState4.setText("设备已开启");
                machineState4 = 1;
            }

        if(messageEvent.getMessage().equals(machineState4_flase))
            if (machineState4 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState4.setText("设备未启动");
                machineState4 = 0;
            }

        if(messageEvent.getMessage().equals(wifiState5_true))
        {
            if(wifiState5 == 0){
                textView_wifiState5.setText("设备已连接");
                wifiState5 = 1;
            }

            ptime5 = System.currentTimeMillis();
        }

        if((ctime5 = System.currentTimeMillis()) - ptime5 > 3000)
            if(wifiState5 == 1)
            {
                textView_wifiState5.setText("设备未连接");
                wifiState5 = 0;
            }

        if(messageEvent.getMessage().equals(machineState5_true))
            if (machineState5 == 0)
            {
                textView_machineState5.setText("设备已开启");
                machineState5 = 1;
            }

        if(messageEvent.getMessage().equals(machineState5_flase))
            if (machineState5 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState5.setText("设备未启动");
                machineState5 = 0;
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
