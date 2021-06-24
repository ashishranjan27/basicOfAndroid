package com.example.messagefromfragmenttofragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {
    var listener: FragmentAListener?= null
    lateinit var editText: EditText
    lateinit var buttonOk: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_a, container, false)
        editText = v.findViewById(R.id.edit_text)
        buttonOk = v.findViewById(R.id.button_ok)
        buttonOk.setOnClickListener(View.OnClickListener {
            val input: CharSequence = editText.getText()
            listener!!.onInputASent(input)
        })
        return v
    }

    fun updateEditText(newText: CharSequence?) {
        editText!!.setText(newText)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
         //Log.d("Tag", context.toString())
         Log.d("Tag", "extra is as "+getActivity().toString())
        // Log.d("Tag",FragmentAListener);
        listener = if (context is FragmentAListener) {
            context
        } else {
            throw RuntimeException(context.toString()
                    + " must implement FragmentAListener")
        }
        //Log.d("Tag", "my name is "+listener.toString());
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}

interface FragmentAListener {
    fun onInputASent(input: CharSequence?)
}

//java code
/*
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
public class FragmentA extends Fragment {
    private FragmentAListener listener;
    private EditText editText;
    private Button buttonOk;
    public interface FragmentAListener {
        void onInputASent(CharSequence input);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        editText = v.findViewById(R.id.edit_text);
        buttonOk = v.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputASent(input);
            }
        });
        return v;
    }
    public void updateEditText(CharSequence newText) {
        editText.setText(newText);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAListener) {
            listener = (FragmentAListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}*/