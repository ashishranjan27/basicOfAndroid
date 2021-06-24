package com.example.customerbroadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


//note that customerbroadcastsender  and broadcastreceiver both are in same means this code will be run when both app run and in this first run broadcastreceiver
public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
    private TextView textView;
    int counter=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Ashish","on create");

        textView = findViewById(R.id.textView);
        //just like we have mention action on manifest file in static so same action is denoted in dynamic method in line no 22 and
        //if line no 22 executes then it will execute myBroadcastReceiver and do what it is written there
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_TIME_TICK);

        registerReceiver(myBroadcastReceiver,intentFilter);
    }

    public void sendBroadcast(View view) {
        Log.d("Ashish","sendBroadcast");
        Intent intent = new Intent("com.example.broadcastreceiver.ACTION_SEND");
        intent.putExtra("com.example.EXTRA_DATA"," Hello from the sender app");
        sendBroadcast(intent);
    }


    //either create like this or can create in new file like we have created MyBroadcastReceiver
    public BroadcastReceiver innerReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
             Log.d("Ashish","innerReceiver");
             if("com.example.broadcastreceiver.ACTION_SEND".equals(intent.getAction())){
                 String intentExtra = intent.getStringExtra("com.example.EXTRA_DATA");
                 textView.setText("Inner Broadcast received "+ intentExtra+counter);
                 counter++;
             }
        }
    };

    // you can use this instead of line no 42 to 50
    /*public class innerReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ashish","onStart");
        IntentFilter intentFilter = new IntentFilter("com.example.broadcastreceiver.ACTION_SEND");
        registerReceiver(innerReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ashish","onStop");
        unregisterReceiver(innerReceiver);
    }
}