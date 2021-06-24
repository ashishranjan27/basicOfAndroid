package com.example.backstack_in_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String ACTIVITY_NAME = MainActivity.class.getSimpleName();
    private static final String TAG = ACTIVITY_NAME;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private Button buttonAddFragment;
    private TextView textViewFragmentCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddFragment = (Button)findViewById(R.id.buttonAddFragment);
        textViewFragmentCount = (TextView)findViewById(R.id.textViewFragmentCount);

        fragmentManager=getSupportFragmentManager();
        textViewFragmentCount.setText("Fragment count in back stack: "+fragmentManager.getBackStackEntryCount());

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textViewFragmentCount.setText("Fragment count in back stack: "+fragmentManager.getBackStackEntryCount());
                StringBuilder backstackEntryMessage = new StringBuilder("Current status of fragment transaction back stack: " + fragmentManager.getBackStackEntryCount()+"\n");

                for(int index=(fragmentManager.getBackStackEntryCount()-1); index>=0; index--){
                    FragmentManager.BackStackEntry entry =  fragmentManager.getBackStackEntryAt(index);
                    backstackEntryMessage.append(entry.getName()+"\n");
                }
                Log.i(TAG,backstackEntryMessage.toString());
            }
        });

        buttonAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment();
            }
        });

    }

    private void addFragment(){
        Fragment fragment;

        /*switch (fragmentManager.getBackStackEntryCount()){
            case 0: fragment = new SampleFragment(); break;
            case 1: fragment = new FragmentTwo();break;
            case 2: fragment = new FragmentThree(); break;
            default: fragment = new SampleFragment(); break;
        }*/

        fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if(fragment instanceof SampleFragment){
            fragment = new FragmentTwo();
        }else if(fragment instanceof FragmentTwo){
            fragment = new FragmentThree();
        }else if(fragment instanceof FragmentThree){
            fragment = new SampleFragment();
        }else{
            fragment = new SampleFragment();
        }

        fragmentTransaction=fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.fragmentContainer,fragment,"demofragment");
        fragmentTransaction.replace(R.id.fragmentContainer,fragment,"demofragment");
        fragmentTransaction.addToBackStack("Replace "+fragment.toString());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if(fragment!=null){
            fragmentTransaction.remove(fragment);
            fragmentTransaction.addToBackStack("Remove "+fragment.toString());
            fragmentTransaction.commit();
        }else{
            super.onBackPressed();
        }

    }
}