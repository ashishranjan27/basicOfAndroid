package com.example.fragment_pop_back_stack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String ACTIVITY_NAME = MainActivity.class.getSimpleName();
    private static final String TAG = ACTIVITY_NAME;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    private Button buttonAddFragmentOne, buttonpopFragment, buttonRemoveFragment;
    private TextView textViewFragmentCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddFragmentOne = (Button)findViewById(R.id.buttonAddFragmentOne);
        buttonpopFragment = (Button)findViewById(R.id.buttonPopFragment);
        buttonRemoveFragment = (Button)findViewById(R.id.buttonRemoveFragment);
        textViewFragmentCount = (TextView)findViewById(R.id.textViewFragmentCount);

        fragmentManager=getSupportFragmentManager();

        textViewFragmentCount.setText("Fragment count in back stack: "+fragmentManager.getBackStackEntryCount());

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textViewFragmentCount.setText("Fragment count in back stack: "+fragmentManager.getBackStackEntryCount());

                StringBuilder stringBuilder=new StringBuilder("Current status of transaction back stack: "+fragmentManager.getBackStackEntryCount()+"\n");
                for(int i=(fragmentManager.getBackStackEntryCount()-1); i>=0;i--){
                    FragmentManager.BackStackEntry backStackEntry =  fragmentManager.getBackStackEntryAt(i);
                    stringBuilder.append(backStackEntry.getName()+"\n");
                }

                Log.i(TAG,stringBuilder.toString());

            }
        });

        Log.i(COMMON_TAG,"Initial BackStackEntryCount: "+fragmentManager.getBackStackEntryCount());

        buttonAddFragmentOne.setOnClickListener(this);
        buttonpopFragment.setOnClickListener(this);
        buttonRemoveFragment.setOnClickListener(this);

    }

    private void addFragment(){
        Fragment fragment;
        if(fragmentManager.getBackStackEntryCount()>0){
            switch (fragmentManager.getBackStackEntryCount()){
                case 0: loadFragmentOne(); break;
                case 1: loadFragmentTwo();break;
                case 2: loadFragmentThree(); break;
                default: loadFragmentOne(); break;
            }
        }else {
            fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
            if(fragment instanceof SampleFragment){
                loadFragmentTwo();
            }else if(fragment instanceof FragmentTwo){
                loadFragmentThree();
            }else if(fragment instanceof FragmentThree){
                loadFragmentOne();
            }else{
                loadFragmentOne();
            }
        }

    }

    private void loadFragmentOne(){
        Fragment fragment;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentByTag("demofragment");
        /*if(fragment!=null){
            fragmentTransaction.remove(fragment);
        }*/
        fragment = new SampleFragment();
        fragmentTransaction.replace(R.id.fragmentContainer,fragment,"demofragment");
        fragmentTransaction.addToBackStack("Add "+fragment.toString());
        fragmentTransaction.commit();
    }

    private void loadFragmentTwo(){

        Fragment fragment;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentByTag("demofragment");
        /*if(fragment!=null){
            fragmentTransaction.remove(fragment);
        }*/
        fragment = new FragmentTwo();
        fragmentTransaction.replace(R.id.fragmentContainer,fragment,"demofragment");
        fragmentTransaction.addToBackStack("Add "+fragment.toString());
        fragmentTransaction.commit();

    }

    private void loadFragmentThree(){
        Fragment fragment;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentByTag("demofragment");
        /*if(fragment!=null){
            fragmentTransaction.remove(fragment);
        }*/
        fragment = new FragmentThree();
        fragmentTransaction.replace(R.id.fragmentContainer,fragment,"demofragment");
        fragmentTransaction.addToBackStack("Add "+fragment.toString());
        fragmentTransaction.commit();
    }

    //Note if you add one time and remove 2 time and then if you pop first time then ok but on second time
    //when you press pop then it will crash the application
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAddFragmentOne: addFragment(); break;
            //in below four any one select
            case R.id.buttonPopFragment: fragmentManager.popBackStack();break;
            //case R.id.buttonPopFragment: fragmentManager.popBackStack(0,FragmentManager.POP_BACK_STACK_INCLUSIVE); break;
            //case R.id.buttonPopFragment: fragmentManager.popBackStack(0,0); break;
            //case R.id.buttonPopFragment: fragmentManager.popBackStack("Add SampleFragment",FragmentManager.POP_BACK_STACK_INCLUSIVE); break;
            case R.id.buttonRemoveFragment:
                fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment=fragmentManager.findFragmentById(R.id.fragmentContainer);
                if(fragment!=null){
                    fragmentTransaction.remove(fragment);
                    fragmentTransaction.addToBackStack("Remove "+fragment.toString());
                    fragmentTransaction.commit();
                }else{
                    Toast.makeText(this,"No Fragment to remove",Toast.LENGTH_SHORT).show();
                }
                break;
            default: break;
        }
    }
}