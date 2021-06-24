package com.example.dynamicbroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Ashish","1");
        setContentView(R.layout.activity_main);

        Log.d("Ashish","2");
        //just like we have mention action on manifest file in static so same action is denoted in dynamic method in line no 22 and
        //if line no 22 executes then it will execute myBroadcastReceiver and do what it is written there
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        Log.d("Ashish","3");
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        Log.d("Ashish","4");
        registerReceiver(myBroadcastReceiver,intentFilter);
    }

    public void sendBroadcast(View view) {

    }

    //note if you register in oncreate then unregister in ondestroy,if you register in onstart then unregister in onpause
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ashish","5");
        unregisterReceiver(myBroadcastReceiver);

    }
}