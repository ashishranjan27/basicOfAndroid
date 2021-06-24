package com.example.layoutinflator;

//https://www.youtube.com/watch?v=YH22K60j_oU

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // in below written 4 different code test every time one and comment other three like done here
        button = findViewById(R.id.button);
       /* button.setOnClickListener(new View.OnClickListener() {

            //multiple click
            @Override
            public void onClick(View v) {

                //return the layout inflater associated with the main activity
                LayoutInflater inflater = getLayoutInflater();
                //return the view of the given resource and it give the textview
                View view = inflater.inflate(R.layout.new_layout,null);

                LinearLayout linearLayout = findViewById(R.id.linearLayout);
                linearLayout.addView(view);

            }
        });*/

       /* button.setOnClickListener(new View.OnClickListener() {

            //multiple click
            @Override
            public void onClick(View v) {

                //return the layout inflater associated with the main activity
                LayoutInflater inflater = getLayoutInflater();
                //return the view of the given resource and it give the linearlayout
                View view = inflater.inflate(R.layout.second_layout,null);

                //note here we are adding whole linear layout not only the text view
                LinearLayout linearLayout = findViewById(R.id.linearLayout);
                linearLayout.addView(view);

            }
        });*/

      /*  button.setOnClickListener(new View.OnClickListener() {

            //multiple click
            @Override
            public void onClick(View v) {

                //return the layout inflater associated with the main activity
                LayoutInflater inflater = getLayoutInflater();
                //return the view of the given resource and it give the linearlayout
                View view = inflater.inflate(R.layout.second_layout,null);

                TextView textView = view.findViewById(R.id.textView2);

            //    String str = textView.getText().toString();
                //note here we are not adding whole linear layout but only the textView
                LinearLayout linearLayout = findViewById(R.id.linearLayout);
                linearLayout.addView(textView);

            }
        });*/

        button.setOnClickListener(new View.OnClickListener() {

            //multiple click
            @Override
            public void onClick(View v) {
                //return the layout inflater associated with the main activity
                LayoutInflater inflater = getLayoutInflater();
                LinearLayout linearLayout = findViewById(R.id.linearLayout);
                //return the view of the given resource and it give the linearlayout
                View view = inflater.inflate(R.layout.new_layout,linearLayout);
            }
        });
    }
}