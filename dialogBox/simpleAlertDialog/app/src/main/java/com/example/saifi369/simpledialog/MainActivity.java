package com.example.saifi369.simpledialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


//https://www.youtube.com/watch?v=d5OjQJajBAc&list=PLj76U7gxVixTXt-srFUbfxcUyTr9Izihl

public class MainActivity extends AppCompatActivity {

    //if you not create the dialog using the fragment then on rotation it will lost all the data
    //so for retaining the data after rotation also for this we have used the fragment


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    public void showDialog() {

        FragmentAlertDialog alertDialog=new FragmentAlertDialog();
        //note this alertDialog.setCancelable(false) we have to set here only not in the fragmentalertdialog
        alertDialog.setCancelable(false);
        alertDialog.show(getSupportFragmentManager(),"FragmentAlerDialog");

    }
}
