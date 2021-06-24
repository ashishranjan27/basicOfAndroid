package com.example.customerbroadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
        {
            boolean booleanextra = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
            if(!booleanextra){
                Toast.makeText(context,"Connected",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(context,"Not Connected",Toast.LENGTH_LONG).show();
            }
        }
        else if(Intent.ACTION_TIME_TICK.equals(intent.getAction())){
            Toast.makeText(context,"Time increases" , Toast.LENGTH_LONG).show();
        }
    }
}
