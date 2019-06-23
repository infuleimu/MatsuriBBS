package com.example.matsuribbsandroid.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.matsuribbsandroid.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ForumFragment extends Fragment {
    TabLayout forumTabs;

    ViewPager forumPager;
    public static final String[] sTitle = new String[]{"我的收藏", "魔兽世界", "网事杂谈", "厂商专区", "手机游戏", "传统游戏", "网络游戏"};

    public ForumFragment() {
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum, container, false);

        forumPager=view.findViewById(R.id.forum_pager);
        forumTabs=view.findViewById(R.id.forum_tabs);

        setupViewPager(forumPager);//初始化viewpager

        return view;
    }

    private void setupViewPager(ViewPager viewPager){
        ForumViewPagerAdapter pagerAdapter=new ForumViewPagerAdapter(getFragmentManager());
        pagerAdapter.addFragment(new FirstFragment(),sTitle[0]);
        pagerAdapter.addFragment(new SecondFragment(),sTitle[1]);
        pagerAdapter.addFragment(new ThirdFragment(),sTitle[2]);
        pagerAdapter.addFragment(new FourthFragment(),sTitle[3]);
        pagerAdapter.addFragment(new FifthFragment(),sTitle[4]);
        pagerAdapter.addFragment(new SixthFragment(),sTitle[5]);
        viewPager.setAdapter(pagerAdapter);
        if(forumTabs!=null){
            forumTabs.addTab(forumTabs.newTab());
            forumTabs.addTab(forumTabs.newTab());
            forumTabs.setupWithViewPager(forumPager);
        }
    }

    static class ForumViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragments=new ArrayList<>();//fragment列表
        private final List<String> mFragmentTitles=new ArrayList<>();//fragment对应标题

        public ForumViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment,String title){
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
