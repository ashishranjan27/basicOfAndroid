package com.example.bindinglayoutandbindingstaticdata.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.bindinglayoutandbindingstaticdata.model.User;

public class MainViewModel extends AndroidViewModel {

    private User mUser;

    public MainViewModel(@NonNull Application application) {
        super(application);

        mUser = new User("Ali", 35);
    }

    public User getUser() {
        return this.mUser;
    }
}
