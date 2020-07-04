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

    TextView textView_wifiState6;
    TextView textView_machineState6;
    int wifiState6 = 0;
    int machineState6 = 0;


    TextView textView_wifiState7;
    TextView textView_machineState7;
    int wifiState7 = 0;
    int machineState7 = 0;

    TextView textView_wifiState8;
    TextView textView_machineState8;
    int wifiState8 = 0;
    int machineState8 = 0;

    TextView textView_wifiState9;
    TextView textView_machineState9;
    int wifiState9 = 0;
    int machineState9 = 0;

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

    long ptime6 = System.currentTimeMillis();
    long ctime6;

    long ptime7 = System.currentTimeMillis();
    long ctime7;

    long ptime8 = System.currentTimeMillis();
    long ctime8;

    long ptime9 = System.currentTimeMillis();
    long ctime9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        mClient.start();
        textView_wifiState1 = (TextView) findViewById(R.id.WifiState1);
        textView_machineState1 = (TextView) findViewById(R.id.MachineState1);
        textView_wifiState1.setText("断开");
        textView_machineState1.setText("停止");
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




        textView_wifiState2 = (TextView) findViewById(R.id.WifiState2);
        textView_machineState2 = (TextView) findViewById(R.id.MachineState2);
        textView_wifiState2.setText("断开");
        textView_machineState2.setText("停止");
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
        textView_wifiState3.setText("断开");
        textView_machineState3.setText("停止");
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
        textView_wifiState4.setText("断开");
        textView_machineState4.setText("停止");
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
        textView_wifiState5.setText("断开");
        textView_machineState5.setText("停止");
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


        textView_wifiState6 = (TextView) findViewById(R.id.WifiState6);
        textView_machineState6 = (TextView) findViewById(R.id.MachineState6);
        textView_wifiState6.setText("断开");
        textView_machineState6.setText("停止");
        Button button_turnon6  = (Button) findViewById(R.id.TurnOn6);
        button_turnon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("a",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff6 = (Button) findViewById(R.id.TurnOff6);
        button_turnoff6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("b",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        textView_wifiState7 = (TextView) findViewById(R.id.WifiState7);
        textView_machineState7 = (TextView) findViewById(R.id.MachineState7);
        textView_wifiState7.setText("断开");
        textView_machineState7.setText("停止");
        Button button_turnon7  = (Button) findViewById(R.id.TurnOn7);
        button_turnon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("c",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff7 = (Button) findViewById(R.id.TurnOff7);
        button_turnoff7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("d",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        textView_wifiState8 = (TextView) findViewById(R.id.WifiState8);
        textView_machineState8 = (TextView) findViewById(R.id.MachineState8);
        textView_wifiState8.setText("断开");
        textView_machineState8.setText("停止");
        Button button_turnon8  = (Button) findViewById(R.id.TurnOn8);
        button_turnon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("e",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff8 = (Button) findViewById(R.id.TurnOff8);
        button_turnoff8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("f",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });


        textView_wifiState9 = (TextView) findViewById(R.id.WifiState9);
        textView_machineState9 = (TextView) findViewById(R.id.MachineState9);
        textView_wifiState9.setText("断开");
        textView_machineState9.setText("停止");
        Button button_turnon9  = (Button) findViewById(R.id.TurnOn9);
        button_turnon9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("g",UrlData.topic_in);
                Toast.makeText(MainActivity.this,"发送中",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_turnoff9 = (Button) findViewById(R.id.TurnOff9);
        button_turnoff9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送mqtt测试
                mClient.sendCmd("h",UrlData.topic_in);
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

        String wifiState6_true = "WifiState6:true";
        String machineState6_true = "MachineState6:true";
        String machineState6_flase = "MachineState6:flase";

        String wifiState7_true = "WifiState7:true";
        String machineState7_true = "MachineState7:true";
        String machineState7_flase = "MachineState7:flase";

        String wifiState8_true = "WifiState8:true";
        String machineState8_true = "MachineState8:true";
        String machineState8_flase = "MachineState8:flase";

        String wifiState9_true = "WifiState9:true";
        String machineState9_true = "MachineState9:true";
        String machineState9_flase = "MachineState9:flase";



        if(messageEvent.getMessage().equals(wifiState1_true))
        {
            if(wifiState1 == 0){
                textView_wifiState1.setText("连通");
                wifiState1 = 1;
            }

            ptime1 = System.currentTimeMillis();
        }

        if((ctime1 = System.currentTimeMillis()) - ptime1 > 3000)
            if(wifiState1 == 1)
            {
                textView_wifiState1.setText("断开");
                wifiState1 = 0;
            }

        if(messageEvent.getMessage().equals(machineState1_true))
            if (machineState1 == 0)
            {
                textView_machineState1.setText("使用");
                machineState1 = 1;
            }

        if(messageEvent.getMessage().equals(machineState1_flase))
            if (machineState1 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState1.setText("停止");
                machineState1 = 0;
            }


        if(messageEvent.getMessage().equals(wifiState2_true))
        {
            if(wifiState2 == 0){
                textView_wifiState2.setText("连通");
                wifiState2 = 1;
            }

            ptime2 = System.currentTimeMillis();
        }

        if((ctime2 = System.currentTimeMillis()) - ptime2 > 3000)
            if(wifiState2 == 1)
            {
                textView_wifiState2.setText("断开");
                wifiState2 = 0;
            }

        if(messageEvent.getMessage().equals(machineState2_true))
            if (machineState2 == 0)
            {
                textView_machineState2.setText("使用");
                machineState2 = 1;
            }

        if(messageEvent.getMessage().equals(machineState2_flase))
            if (machineState2 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState2.setText("停止");
                machineState2 = 0;
            }

        if(messageEvent.getMessage().equals(wifiState3_true))
        {
            if(wifiState3 == 0){
                textView_wifiState3.setText("连通");
                wifiState3 = 1;
            }

            ptime3 = System.currentTimeMillis();
        }

        if((ctime3 = System.currentTimeMillis()) - ptime3 > 3000)
            if(wifiState3 == 1)
            {
                textView_wifiState3.setText("断开");
                wifiState3 = 0;
            }

        if(messageEvent.getMessage().equals(machineState3_true))
            if (machineState3 == 0)
            {
                textView_machineState3.setText("使用");
                machineState3 = 1;
            }

        if(messageEvent.getMessage().equals(machineState3_flase))
            if (machineState3 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState3.setText("停止");
                machineState3 = 0;
            }

        if(messageEvent.getMessage().equals(wifiState4_true))
        {
            if(wifiState4 == 0){
                textView_wifiState4.setText("连通");
                wifiState4 = 1;
            }

            ptime4 = System.currentTimeMillis();
        }

        if((ctime4 = System.currentTimeMillis()) - ptime4 > 3000)
            if(wifiState4 == 1)
            {
                textView_wifiState4.setText("断开");
                wifiState4 = 0;
            }

        if(messageEvent.getMessage().equals(machineState4_true))
            if (machineState4 == 0)
            {
                textView_machineState4.setText("使用");
                machineState4 = 1;
            }

        if(messageEvent.getMessage().equals(machineState4_flase))
            if (machineState4 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState4.setText("停止");
                machineState4 = 0;
            }

        if(messageEvent.getMessage().equals(wifiState5_true))
        {
            if(wifiState5 == 0){
                textView_wifiState5.setText("连通");
                wifiState5 = 1;
            }

            ptime5 = System.currentTimeMillis();
        }

        if((ctime5 = System.currentTimeMillis()) - ptime5 > 3000)
            if(wifiState5 == 1)
            {
                textView_wifiState5.setText("断开");
                wifiState5 = 0;
            }

        if(messageEvent.getMessage().equals(machineState5_true))
            if (machineState5 == 0)
            {
                textView_machineState5.setText("使用");
                machineState5 = 1;
            }

        if(messageEvent.getMessage().equals(machineState5_flase))
            if (machineState5 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState5.setText("停止");
                machineState5 = 0;
            }






        if(messageEvent.getMessage().equals(wifiState6_true))
        {
            if(wifiState6 == 0){
                textView_wifiState6.setText("连通");
                wifiState6 = 1;
            }

            ptime6 = System.currentTimeMillis();
        }

        if((ctime6 = System.currentTimeMillis()) - ptime6 > 3000)
            if(wifiState6 == 1)
            {
                textView_wifiState6.setText("断开");
                wifiState6 = 0;
            }

        if(messageEvent.getMessage().equals(machineState6_true))
            if (machineState6 == 0)
            {
                textView_machineState6.setText("使用");
                machineState6 = 1;
            }

        if(messageEvent.getMessage().equals(machineState6_flase))
            if (machineState6 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState6.setText("停止");
                machineState6 = 0;
            }



        if(messageEvent.getMessage().equals(wifiState7_true))
        {
            if(wifiState7 == 0){
                textView_wifiState7.setText("连通");
                wifiState7 = 1;
            }

            ptime7 = System.currentTimeMillis();
        }

        if((ctime7 = System.currentTimeMillis()) - ptime7 > 3000)
            if(wifiState7 == 1)
            {
                textView_wifiState7.setText("断开");
                wifiState7 = 0;
            }

        if(messageEvent.getMessage().equals(machineState7_true))
            if (machineState7 == 0)
            {
                textView_machineState7.setText("使用");
                machineState7 = 1;
            }

        if(messageEvent.getMessage().equals(machineState7_flase))
            if (machineState7 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState7.setText("停止");
                machineState7 = 0;
            }


        if(messageEvent.getMessage().equals(wifiState8_true))
        {
            if(wifiState8 == 0){
                textView_wifiState8.setText("连通");
                wifiState8 = 1;
            }

            ptime8 = System.currentTimeMillis();
        }

        if((ctime8 = System.currentTimeMillis()) - ptime8 > 3000)
            if(wifiState8 == 1)
            {
                textView_wifiState8.setText("断开");
                wifiState8 = 0;
            }

        if(messageEvent.getMessage().equals(machineState8_true))
            if (machineState8 == 0)
            {
                textView_machineState8.setText("使用");
                machineState8 = 1;
            }

        if(messageEvent.getMessage().equals(machineState8_flase))
            if (machineState8 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState8.setText("停止");
                machineState8 = 0;
            }


        if(messageEvent.getMessage().equals(wifiState9_true))
        {
            if(wifiState9 == 0){
                textView_wifiState9.setText("连通");
                wifiState9 = 1;
            }

            ptime9 = System.currentTimeMillis();
        }

        if((ctime9 = System.currentTimeMillis()) - ptime9 > 3000)
            if(wifiState9 == 1)
            {
                textView_wifiState9.setText("断开");
                wifiState9 = 0;
            }

        if(messageEvent.getMessage().equals(machineState9_true))
            if (machineState9 == 0)
            {
                textView_machineState9.setText("使用");
                machineState9 = 1;
            }

        if(messageEvent.getMessage().equals(machineState9_flase))
            if (machineState9 == 1)
            {
                //Log.d(, "check: ");
                Log.d("MainActivity", "check: machineflase");
                textView_machineState9.setText("停止");
                machineState9 = 0;
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
