package com.example.messagefromfragmenttofragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.messagefromfragmenttofragment.FragmentAListener
import com.example.messagefromfragmenttofragment.FragmentB.FragmentBListener

class MainActivity : AppCompatActivity(), FragmentAListener, FragmentB.FragmentBListener {
    private var fragmentA: FragmentA? = null
    private var fragmentB: FragmentB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        fragmentA = FragmentA()
        fragmentB = FragmentB()
        supportFragmentManager.beginTransaction()
                .replace(R.id.container_a, fragmentA!!)
                .replace(R.id.container_b, fragmentB!!)
                .commit()
    }

    override fun onInputASent(input: CharSequence?) {
        fragmentB!!.updateEditText(input)
    }

    override fun onInputBSent(input: CharSequence?) {
        fragmentA!!.updateEditText(input)
    }
}

/*import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener, FragmentB.FragmentBListener {
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, fragmentA)
                .replace(R.id.container_b, fragmentB)
                .commit();
    }
    @Override
    public void onInputASent(CharSequence input) {
        fragmentB.updateEditText(input);
    }
    @Override
    public void onInputBSent(CharSequence input) {
        fragmentA.updateEditText(input);
    }
}*/