package com.example.mess_from_activitytofragment;

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


                //Android Bundle is used to pass data between activities. The values that are to be
                //passed are mapped to String keys which are later used in the next activity to retrieve the values.
                String mess = medit.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Key",mess);

                first.setArguments(bundle);

            }
        });
    }

}