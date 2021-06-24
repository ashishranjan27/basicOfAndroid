package com.example.customerbroadcastsenderexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
    private TextView textView;
    int counter=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d("Ashish","on create");

        textView = findViewById(R.id.textView);

    }

    public void sendBroadcast(View view) {
      //  Log.d("Ashish","sendBroadcast");
   //     Intent intent = new Intent("com.example.broadcastreceiver.ACTION_SEND");
        //either write line no 35 or 37-38 both are same
//        Intent intent = new Intent(this,MyBroadcastReceiver.class);

        //Intent intent = new Intent();
        //intent.setClass(this,MyBroadcastReceiver.class);


//        Intent intent = new Intent("com.example.broadcastreceiverexplicit", "com.example.broadcastreceiverexplicit.MyDemoReceiver");
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.example.broadcastreceiverexplicit", "com.example.broadcastreceiverexplicit.MyDemoReceiver");
        intent.setComponent(componentName);
        sendBroadcast(intent);
    }



}