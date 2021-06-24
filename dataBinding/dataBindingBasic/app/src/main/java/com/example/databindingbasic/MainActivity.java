package com.example.databindingbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.*;


import android.os.Bundle;
import android.widget.TextView;

import com.example.databindingbasic.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //in data binding what happen that it will bind data in xml only not in activity so that
    //first it bring data and then idand then set it instead it directly bind data in xml file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_main);

        TextView textView1=findViewById(R.id.tv_first);
        TextView textView2=findViewById(R.id.tv_second);

        textView1.setText("This is first text");
        textView1.setText("This is second text");*/
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.setText1("first one");
        binding.setText2("second one");

    }
}