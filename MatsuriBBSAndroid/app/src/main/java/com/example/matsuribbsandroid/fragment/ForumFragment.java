package com.example.matsuribbsandroid.fragment;

import android.os.Bundle;
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

public class ForumFragment extends Fragment {
    public ForumFragment(){}
    private TabLayout tabLayout;
    private ViewPager viewPage;
    private List<Fragment> frags;
    private List<String> titles;
    private Fragment[] f;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum,container,false);

        viewPage= (ViewPager) view.findViewById(R.id.forum_pager);
        tabLayout= (TabLayout) view.findViewById(R.id.forum_tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        frags=new ArrayList<>();
        frags.add(new Fragment1());
        titles=new ArrayList<>();
        titles.add("标题1");
        titles.add("标题2");
        titles.add("标题3");
        titles.add("标题4");
        titles.add("标题5");
        titles.add("标题6");
        titles.add("标题7");
        tabLayout.setupWithViewPager(viewPage);
        Myadapter adapter=new Myadapter(getChildFragmentManager());
        viewPage.setAdapter(adapter);

        return view;
    }
    //适配器
    class Myadapter extends FragmentPagerAdapter {

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return getfragment(position);
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
    //动态创建Fragment的方法
    public Fragment  getfragment(int position){
        f=new Fragment[10];
        Fragment fg = f[position];
        if (fg == null) {
            fg = Fragment1.getiniturl(position+"");
            f[position] = fg;
        }
        return fg;
    }

}
