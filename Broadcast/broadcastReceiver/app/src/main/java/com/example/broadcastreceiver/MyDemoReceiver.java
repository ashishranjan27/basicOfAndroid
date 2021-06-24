package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyDemoReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Ashish","onReceive second");
        if ("com.example.broadcastreceiver.ACTION_SEND".equals(intent.getAction())) {
            String extra = intent.getStringExtra("com.example.EXTRA_DATA");
            Toast.makeText(context, "From Receiver" + extra, Toast.LENGTH_LONG).show();
        }
    }
}
