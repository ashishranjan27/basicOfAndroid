package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView first,second;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        first = findViewById(R.id.textView);
        second = findViewById(R.id.textView2);

        Intent intent= getIntent();
         data = intent.getStringExtra("dataname");
        first.setText("My name is " + data);
        second.setText(data + "is employee of urban company ");

    }
}