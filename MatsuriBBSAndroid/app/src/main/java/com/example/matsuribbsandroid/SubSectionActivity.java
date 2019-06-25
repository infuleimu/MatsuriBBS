package com.example.matsuribbsandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.matsuribbsandroid.forumFragmentItem.FirstFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SubSectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewPager subSectionPager = findViewById(R.id.subSection_pager);
        TabLayout subSectionLayout = findViewById(R.id.subSection_tabs);

        setupViewPager(subSectionPager);//初始化viewpager
        if(subSectionLayout!=null){
            subSectionLayout.addTab(subSectionLayout.newTab());
            subSectionLayout.addTab(subSectionLayout.newTab());
            subSectionLayout.setupWithViewPager(subSectionPager);
        }

        setContentView(R.layout.activity_sub_section);
    }

    private void setupViewPager(ViewPager viewPager){
        SubSectionViewPagerAdapter pagerAdapter=new SubSectionViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new FirstFragment(),"全部");
        pagerAdapter.addFragment(new FirstFragment(),"全部");
        viewPager.setAdapter(pagerAdapter);
    }

    static class SubSectionViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragments=new ArrayList<>();//fragment列表
        private final List<String> mFragmentTitles=new ArrayList<>();//fragment对应标题

        public SubSectionViewPagerAdapter(FragmentManager fm) {
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
