package com.example.mess_from_activitytofragment_parcelable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class parcelableFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_parcelable, container, false);

        TextView showtext = view.findViewById(R.id.textView);

        Bundle bundle = getArguments();
        if(bundle!=null)
        {
            Person p = bundle.getParcelable("Key");
            showtext.setText(p.getfName()+"\n");
            showtext.append(p.getlName()+"\n");
            showtext.append(String.valueOf(p.getAge()));
        }
        return view;


    }
}