package com.example.matsuribbsandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.matsuribbsandroid.GlideImageLoader;
import com.example.matsuribbsandroid.R;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {
    public MyFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,container,false);
        List images = new ArrayList();
        images.add(R.drawable.timg);
        images.add(R.drawable.timg2);
        images.add(R.drawable.timg3);


        Banner banner = (Banner) view.findViewById(R.id.banner_my);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        return view;
    }
}
