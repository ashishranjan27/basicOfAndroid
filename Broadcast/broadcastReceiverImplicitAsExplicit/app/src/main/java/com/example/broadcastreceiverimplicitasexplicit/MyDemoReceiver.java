package com.example.broadcastreceiverimplicitasexplicit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyDemoReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"My Demo receiver called: receiver app",Toast.LENGTH_LONG).show();
    }
}
