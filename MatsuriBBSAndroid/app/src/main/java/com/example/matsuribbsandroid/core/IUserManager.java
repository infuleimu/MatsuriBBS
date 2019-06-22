package com.example.matsuribbsandroid.core;

import com.example.matsuribbsandroid.entity.User;


import io.reactivex.annotations.NonNull;

public interface IUserManager {


    void setUser(@NonNull User loginResponse);
}
