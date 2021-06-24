package com.example.customerbroadcastsenderimplicitasexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
    private TextView textView;
    int counter=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d("Ashish","on create");

        textView = findViewById(R.id.textView);

    }

    public void sendBroadcast(View view) {

        Intent intent = new Intent("com.example.broadcastreceiverimplicitasexplicit.ACTION_SEND");
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfos = packageManager.queryBroadcastReceivers(intent,0);
        for (ResolveInfo info : resolveInfos){
            ComponentName componentName = new ComponentName(info.activityInfo.packageName, info.activityInfo.name);
            intent.setComponent(componentName);
            sendBroadcast(intent);
        }
    }
}
//chaputoli chowk      global  platinum       argora chowk