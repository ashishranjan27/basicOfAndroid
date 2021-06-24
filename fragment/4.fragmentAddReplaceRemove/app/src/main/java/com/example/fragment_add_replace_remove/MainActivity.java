package com.example.fragment_add_replace_remove;

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
            }
        });

        Log.i(TAG,"Initial BackStackEntryCount: "+fragmentManager.getBackStackEntryCount());


        buttonAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment();
            }
        });

    }


    private void addFragment(){
        Fragment fragment;

       /* switch (fragmentManager.getBackStackEntryCount()){
            case 0: fragment = new SampleFragment(); break;
            case 1: fragment = new FragmentTwo();break;
            case 2: fragment = new FragmentThree(); break;
            default: fragment = new SampleFragment(); break;
        }*/

        //when have commented fragmentTransaction.addToBackStack(null); then use this only not above
        //one which is switch case one
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
        fragmentTransaction.add(R.id.fragmentContainer,fragment,"demofragment");
      //  fragmentTransaction.replace(R.id.fragmentContainer,fragment,"demofragment");

        //if you comment below line then this fragment get addedd again and again and getBackStackEntryCount()
        //will return zero

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //normal behaviour of onBackPressed is that it closes both activity and fragment at the same time
    //so to avoid this only we are overriding the function of the onBackPressed where we have declared
    //function depending on our situation
    @Override
    public void onBackPressed() {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if(fragment!=null){
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }else{
            super.onBackPressed();
        }

    }
}