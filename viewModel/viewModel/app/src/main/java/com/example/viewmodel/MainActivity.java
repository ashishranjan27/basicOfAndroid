package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button,button1;
    TextView textView;
    Integer scoreTillNow;
    scoreViewModel ScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseByOne();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
        ScoreViewModel = ViewModelProviders.of(this).get(scoreViewModel.class);
        textView.setText(String.valueOf(ScoreViewModel.getScore()));

      //  scoreTillNow=0;
        //textView.setText(String.valueOf(scoreTillNow));
    }

    public void increaseByOne(){
      ScoreViewModel.addScore();
        textView.setText(String.valueOf(ScoreViewModel.getScore()));
      //  scoreTillNow++;
        // textView.setText(String.valueOf(scoreTillNow));
    }

    public void reset(){
        ScoreViewModel.resetScore();
        textView.setText(String.valueOf(ScoreViewModel.getScore()));
       // scoreTillNow=0;
        //textView.setText(String.valueOf(scoreTillNow));
    }
}