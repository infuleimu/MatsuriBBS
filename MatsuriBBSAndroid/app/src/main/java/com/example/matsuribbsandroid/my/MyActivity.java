package com.example.matsuribbsandroid.my;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.matsuribbsandroid.GlideImageLoader;
import com.example.matsuribbsandroid.R;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        List images = new ArrayList();
        images.add(R.drawable.timg);
        images.add(R.drawable.timg2);
        images.add(R.drawable.timg3);


        Banner banner = (Banner) findViewById(R.id.banner_my);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}
