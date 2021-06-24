package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

//universeu4  ,  Android Development
public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.layoutView);


    }

    public void btnclicked(View view) {
       // String str = view.toString();
        //Log.d("ashish",str);
        //Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();

        //you can pass view in place of constraintlayout beacuse first parameter of Snackbar.make() take as view so both view and constraintLayout act as return type view only
        Snackbar sb = Snackbar.make(constraintLayout,"Message for snackbar",Snackbar.LENGTH_LONG)
                               .setAction("Click here", new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Toast.makeText(MainActivity.this,"Toast from snackbar",Toast.LENGTH_SHORT).show();
                                   }
                               })
                               .setActionTextColor(Color.GREEN);
        sb.show();
    }
}