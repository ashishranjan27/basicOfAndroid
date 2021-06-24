package com.example.mess_from_activitytofragment_parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText mFname;
    private EditText mLname;
    private EditText mAge;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFname = findViewById(R.id.edittext);
        mLname = findViewById(R.id.edittext2);
        mAge = findViewById(R.id.edittext1);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                parcelableFragment fragment = new parcelableFragment();
                String fname = mFname.getText().toString();
                String lname = mLname.getText().toString();
                int age = Integer.valueOf(mAge.getText().toString());

                Person p = new Person(fname, lname, age);
                Bundle bundle = new Bundle();
                bundle.putParcelable("Key",p);

                fragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();


            }
        });

    }
}