package com.example.toasts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button byDefaultToast, simpleToast, nestedToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        byDefaultToast = findViewById((R.id.byDefault));
        simpleToast = findViewById((R.id.simpleGravity));
        nestedToast = findViewById((R.id.nestedGravity));

        byDefaultToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"By defaut toast",Toast.LENGTH_LONG).show();
            }
        });

        simpleToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this,"simple toast",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();

            }
        });

        nestedToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this,"nested toast",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT,0,0);
                toast.show();
            }
        });
    }

    public void inText(View view) {
        Toast.makeText(MainActivity.this,"Can also be applied in text view and also another method of implementing the onclick method",Toast.LENGTH_LONG).show();
    }
}