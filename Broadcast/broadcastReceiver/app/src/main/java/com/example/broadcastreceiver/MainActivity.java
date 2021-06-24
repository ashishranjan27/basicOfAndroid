package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //note that customerbroadcastsender  and broadcastreceiver both are in same means this code will be run when both app run and in this first run broadcastreceiver
    MyDemoReceiver myDemoReceiver = new MyDemoReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Ashish","onCreate second");
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter("com.example.broadcastreceiver.ACTION_SEND");
        registerReceiver(myDemoReceiver,intentFilter);
    }

    public void sendBroadcast(View view) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ashish","onDestroy second");
        unregisterReceiver(myDemoReceiver);
    }
}