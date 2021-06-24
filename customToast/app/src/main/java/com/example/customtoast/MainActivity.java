package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(MainActivity.this,"this is good",Toast.LENGTH_SHORT).show();
                LayoutInflater inflater = getLayoutInflater();
                View view= inflater.inflate(R.layout.cutom_toast_layout, null);

                TextView textView = view.findViewById(R.id.textView1);

                textView.setText("Ashish is good boy");

                Toast toast = new Toast(MainActivity.this);
                toast.setView(view);

                //toast.setGravity(Gravity.LEFT | Gravity.TOP , 150,150);
                toast.setGravity(Gravity.LEFT  , 150,150);

                toast.show();

            }
        });

    }
}