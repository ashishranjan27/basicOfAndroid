package com.example.mess_from_activitytofragment;

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



    public firstFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        if(bundle!=null)
        {
            String message=bundle.getString("Key");
            TextView textView= view.findViewById(R.id.showtext);
            textView.setText(message);
        }
        return view;

    }
}