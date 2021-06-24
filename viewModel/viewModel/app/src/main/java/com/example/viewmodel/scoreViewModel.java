package com.example.viewmodel;


import androidx.lifecycle.ViewModel;

public class scoreViewModel extends ViewModel {

    public Integer score;

    public Integer getScore(){
        if(score==null){
            score=0;
        }
        return score;
    }

    public void addScore(){
        if(score==null){
            score=0;
        }
        score++;
    }

    public void resetScore(){
        score=0;
    }
}
