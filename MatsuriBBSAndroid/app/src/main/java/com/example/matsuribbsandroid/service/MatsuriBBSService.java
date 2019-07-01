package com.example.matsuribbsandroid.service;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.example.matsuribbsandroid.forumFragmentItem.SubSectionResponse;
import com.example.matsuribbsandroid.home.HomePostResponse;
import com.example.matsuribbsandroid.login.LoginResponse;
import com.example.matsuribbsandroid.post.MoreReplyResponse;
import com.example.matsuribbsandroid.post.PostDetailResponse;
import com.example.matsuribbsandroid.post.PostReplyResponse;

public interface MatsuriBBSService {

    String BASE_URL = "http://106.52.84.58:8080/MatsuriBBS/api/";

    //登录
    @GET("login")
    Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

    @GET("post")
    Call<HomePostResponse> viewPost(@Query("page")Integer page,@Query("limit")Integer limit,@Query("sid")Integer sid);

    @GET("post/{id}")
    Call<PostDetailResponse> viewPostDetail(@Path("id") Integer id);

    @GET("post/{id}/reply")
    Call<PostReplyResponse> viewPostReply(@Path("id") Integer id,@Query("page")Integer page,@Query("limit")Integer limit);

    @GET("main_section/{id}/sub_section")
    Call<SubSectionResponse> viewSunSection(@Path("id") Integer id);

    @GET("/reply/{id}/subreply")
    Call<MoreReplyResponse> viewSubReply(@Path("id") Integer id,@Query("page")Integer page,@Query("limit")Integer limit);
}
