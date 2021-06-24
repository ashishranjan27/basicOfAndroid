package com.example.fragment_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.fragment_app.Fragments.FirstFragment;
import com.example.fragment_app.Fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {


    Button first,second;
    LinearLayout linearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        linearlayout = findViewById(R.id.linearlayout);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment firstfragment = new FirstFragment();
                FragmentTransaction tra = getSupportFragmentManager().beginTransaction();
                //In below one we are replacing it
                tra.replace(R.id.linearlayout , firstfragment);
                tra.commit();
            }
        });


        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment firstfragment = new SecondFragment();
                //FragmentManager fragmentManager = getSupportFragmentManager();
                //FragmentTransaction tra = fragmentManager.beginTransaction();
                FragmentTransaction tra = getSupportFragmentManager().beginTransaction();
                //In below one we are replacing it
                tra.replace(R.id.linearlayout , firstfragment);
                tra.commit();
            }
        });

    }
}