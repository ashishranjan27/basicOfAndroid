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

class FragmentB : Fragment() {
    private var listener: FragmentBListener? = null
    lateinit var editText: EditText
    lateinit var buttonOk: Button

    interface FragmentBListener {
        fun onInputBSent(input: CharSequence?)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_b, container, false)
        editText = v.findViewById(R.id.edit_text)
        buttonOk = v.findViewById(R.id.button_ok)
        buttonOk.setOnClickListener(View.OnClickListener {
            val input: CharSequence = editText.getText()
            listener!!.onInputBSent(input)
        })
        return v
    }

    fun updateEditText(newText: CharSequence?) {
        editText!!.setText(newText)
    }

    override fun onAttach(context: Context) {
      //  Log.d("Tag", "2"+ context.toString())
        super.onAttach(context)
        listener = if (context is FragmentBListener) {
            context
        } else {
            throw RuntimeException("$context must implement FragmentBListener")
        }
    //    Log.d("Tag", "2"+ context.toString())
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
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
public class FragmentB extends Fragment {
    private FragmentBListener listener;
    private EditText editText;
    private Button buttonOk;
    public interface FragmentBListener {
        void onInputBSent(CharSequence input);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        editText = v.findViewById(R.id.edit_text);
        buttonOk = v.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputBSent(input);
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
        if (context instanceof FragmentBListener) {
            listener = (FragmentBListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentBListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}*/