package com.example.implicitandstaticbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    //Note that the following will not be triggered by the below one but the action which is mentioned in the manifest file
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context,"Boot completed",Toast.LENGTH_LONG).show();
        }
        //it will not work in higher api for this go to lower api
        else if(Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction()))
        {
            Toast.makeText(context,"Connectivity status changed",Toast.LENGTH_LONG).show();
        }

    }
}
