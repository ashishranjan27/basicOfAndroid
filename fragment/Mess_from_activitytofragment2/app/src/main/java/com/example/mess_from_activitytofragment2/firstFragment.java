package com.example.mess_from_activitytofragment2;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class firstFragment extends Fragment {


    private  String message;
  public firstFragment(){

  }

  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_first, container, false);

            TextView textView= view.findViewById(R.id.showtext);
            textView.setText(message);

        return view;

    }

    public void setData(String mess) {
        this.message=mess;
    }
}

