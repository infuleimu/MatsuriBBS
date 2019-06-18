package com.example.matsuribbsandroid;

import android.os.Bundle;

import com.example.matsuribbsandroid.fragment.ForumFragment;
import com.example.matsuribbsandroid.fragment.HomeFragment;
import com.example.matsuribbsandroid.fragment.MessageFragment;
import com.example.matsuribbsandroid.fragment.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    return true;
                case R.id.navigation_message:
                    replaceFragment(new MessageFragment());
                    return true;
                case R.id.navigation_forum:
                    replaceFragment(new ForumFragment());
                    return true;
                case R.id.navigation_my:
                    replaceFragment(new MyFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView =(BottomNavigationView) findViewById(R.id.nav_view);

        navView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        replaceFragment(new HomeFragment());
    }

    private void replaceFragment(Fragment fragment){
        //1.实例化FragmentManager 对象
        FragmentManager fragmentManager=getSupportFragmentManager();
        //2.实例化FragmentTransaction对象
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        //3.设置事务动作
        transaction.replace(R.id.fragment_layout,fragment);
        //4.执行事务
        transaction.commit();
    }

}
