package com.example.dynamicbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //it will not work in higher api through static method so go for lower api for static method but this is dynamic since we have not declared in manifest file
        //so written in java file means dynamic and here all intent work
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
        {
            Log.d("Ashish","6");
            boolean booleanextra = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
            if(!booleanextra){
                Log.d("Ashish","7");
                Toast.makeText(context,"Connected",Toast.LENGTH_LONG).show();
            }
            else
            {
                Log.d("Ashish","8");
                Toast.makeText(context,"Not Connected",Toast.LENGTH_LONG).show();
            }
        }
        else if(Intent.ACTION_TIME_TICK.equals(intent.getAction())){
            Log.d("Ashish","9");
            Toast.makeText(context,"Time increases" , Toast.LENGTH_LONG).show();
        }
    }
}
