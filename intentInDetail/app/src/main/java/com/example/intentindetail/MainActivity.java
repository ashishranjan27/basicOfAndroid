package com.example.intentindetail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



//to know the context in detail refer to the newActivity
//to add the back button here we have told two method first in manifest and second here in java file


public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edit = editText.getText().toString();

                Intent intent = new Intent(MainActivity.this, newActivity.class);
                intent.putExtra("first","Ashish is Good ");
                intent.putExtra("firstt",123);
                intent.putExtra("firsttt",edit);
                startActivity(intent);


            }
        });
    }


}