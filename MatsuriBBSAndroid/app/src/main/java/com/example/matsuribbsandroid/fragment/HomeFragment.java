package com.example.matsuribbsandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.matsuribbsandroid.GlideImageLoader;
import com.example.matsuribbsandroid.R;
import com.google.android.material.navigation.NavigationView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
    private View view;

    public HomeFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);

        List images = new ArrayList();
        images.add(R.drawable.timg);
        images.add(R.drawable.timg2);
        images.add(R.drawable.timg3);

        Banner banner = (Banner) view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        return view;
    }

}
