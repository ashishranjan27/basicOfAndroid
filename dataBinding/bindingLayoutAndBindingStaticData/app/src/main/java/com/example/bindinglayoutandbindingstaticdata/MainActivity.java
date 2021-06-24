package com.example.bindinglayoutandbindingstaticdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.bindinglayoutandbindingstaticdata.databinding.MainActivityBinding;
import com.example.bindinglayoutandbindingstaticdata.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        //uncomment line 19 and comment all remaining then also will print something due to data binding
        //name will be like xml file name in pascal case and at last add Binding


        //either use line 27-28 or 31 any one below one basically used in fragment or adapter view like this
      //  MainActivityBinding binding= MainActivityBinding.inflate(LayoutInflater.from(this));
        //setContentView(binding.getRoot());


        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //binding.setText1("My name is Ashish Ranjan");
        //binding.setSecondText("oh now my name is also good");



        mViewModel = ViewModelProviders.of(this)
                .get(MainViewModel.class);

           binding.setMainViewModel(mViewModel);
    }
}