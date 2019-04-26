package com.example.louxiantuo.graduation;

/**
 * Created by louxiantuo on 19-3-20.
 */

import android.util.Log;

import com.example.louxiantuo.graduation.UrlData;
//import com.surine.family.EventBus.SimpleEvent;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.greenrobot.eventbus.EventBus;

//import de.greenrobot.event.EventBus;

public class PushCallBack implements MqttCallback {

    @Override
    public void connectionLost(Throwable arg0) {
        // TODO Auto-generated method stub
        Log.d("MQTT_MESSAGE", "链接断开");
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken arg0) {
        // TODO Auto-generated method stub
        Log.d("MQTT_MESSAGE", "deliveryComplete----------"+arg0.isComplete());
    }

    @Override
    public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
        // TODO Auto-generated method stub
        Log.d("MQTT_MESSAGE", "接受消息内容"+new String(arg1.getPayload()));
        Log.d("MQTT_MESSAGE", "接收消息主题"+arg0);
        EventBus.getDefault().post(new MessageEvent(1,new String(arg1.getPayload())));
        //System.out.println("接受消息Qos"+arg1.getQos());

    }


}