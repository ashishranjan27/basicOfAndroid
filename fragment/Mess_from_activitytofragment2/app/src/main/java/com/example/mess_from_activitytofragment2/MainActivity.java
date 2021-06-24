package com.example.mess_from_activitytofragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText medit;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        medit = findViewById(R.id.etusername);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstFragment first = new firstFragment();
                FragmentTransaction tra = getSupportFragmentManager().beginTransaction();
                tra.replace(R.id.frag_container,first);
                tra.commit();

                String mess = medit.getText().toString();

                first.setData(mess);

            }
        });
    }

}