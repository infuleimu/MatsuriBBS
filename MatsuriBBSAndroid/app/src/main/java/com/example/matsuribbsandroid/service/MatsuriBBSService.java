package com.example.matsuribbsandroid.service;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.example.matsuribbsandroid.home.HomePostResponse;
import com.example.matsuribbsandroid.login.LoginResponse;

public interface MatsuriBBSService {
    String BASE_URL = "http://192.168.1.100:8080/BBS/api/";

    //登录
    @GET("login")
    Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

    @GET("post")
    Call<HomePostResponse> viewPost(@Query("page")Integer page,@Query("limit")Integer limit,@Query("sid")Integer sid);
}
