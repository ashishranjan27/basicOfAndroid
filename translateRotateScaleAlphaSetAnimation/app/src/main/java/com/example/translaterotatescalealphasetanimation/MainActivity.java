package com.example.translaterotatescalealphasetanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonTranslate,buttonRotate,buttonScale,buttonAlpha,buttonSet;
    ImageView imageAnimation;
    Animation animTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }


    private void initialize(){

        buttonTranslate = findViewById(R.id.button_translate);
        buttonRotate = findViewById(R.id.button_rotate);
        buttonScale = findViewById(R.id.button_scale);
        buttonAlpha = findViewById(R.id.button_alpha);
        buttonSet = findViewById(R.id.button_set);
        imageAnimation = findViewById(R.id.image_animation);

        buttonTranslate.setOnClickListener(this);
        buttonRotate.setOnClickListener(this);
        buttonScale.setOnClickListener(this);
        buttonAlpha.setOnClickListener(this);
        buttonSet.setOnClickListener(this);

        animTranslate = AnimationUtils.loadAnimation(this,R.anim.translate);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_translate:
                imageAnimation.startAnimation(animTranslate);
                break;

            case R.id.button_rotate:

                break;

            case R.id.button_scale:

                break;

            case R.id.button_alpha:

                break;

            case R.id.button_set:

                break;

        }

    }
}