package com.example.matsuribbsandroid.core;

import com.example.matsuribbsandroid.entity.User;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.annotations.NonNull;

public class UserManager implements IUserManager{
    private static IUserManager sInstance = new UserManager();
    private EventBus mBus = EventBus.getDefault();
    public static IUserManager getInstance(){
        return sInstance;
    }
    private User mLoginResponse;

    @Override
    public void setUser(@NonNull User loginResponse){
        mLoginResponse = loginResponse;
        mBus.postSticky(mLoginResponse);
    }
}
