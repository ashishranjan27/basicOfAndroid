package com.example.broadcastreceiverexplicit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyDemoReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
       // Log.d("Ashish","onReceive second");
        Toast.makeText(context,"My Demo receiver called: receiver app",Toast.LENGTH_LONG).show();
    }
}
