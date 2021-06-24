package com.example.intentindetail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class newActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //second way of having back button in the action bar
        //onOptionsItemSelected is for action that will be performed after clicking it
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView3);

        String s = getIntent().getStringExtra("first");
        Integer i= getIntent().getIntExtra("firstt",12);
        String q = getIntent().getStringExtra("firsttt");

        textView.setText(s);
        textView.append(i.toString());
        textView.append(q);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //beow one will not work because this refer to the anynoumous class means new View.onClick.... not the current activity
                // Intent intent = new Intent(this, MainActivity.class);

                //Intent intent = new Intent(newActivity.this, MainActivity.class);

               // Returns the context the view is currently running in. Usually the currently active Activity
                Intent intent = new Intent(v.getContext(), MainActivity.class);

                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //here in action bar only one item is there so directly written item.getItemId()
        int id = item.getItemId();

        if(id== android.R.id.home){
            //you can try with different in place of getApplicationContext(), like newactivity.this and etc.........
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}