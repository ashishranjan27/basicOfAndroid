package com.example.customerbroadcastsenderimplicitasexplicit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"My broadcast receiver called",Toast.LENGTH_LONG).show();
    }
}
