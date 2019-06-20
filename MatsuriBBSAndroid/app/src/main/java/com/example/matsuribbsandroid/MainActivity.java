package com.example.matsuribbsandroid;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.matsuribbsandroid.fragment.ForumFragment;
import com.example.matsuribbsandroid.fragment.HomeFragment;
import com.example.matsuribbsandroid.fragment.MessageFragment;
import com.example.matsuribbsandroid.fragment.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private TextView toolbar_title;
    private LinearLayout toolbar_search;
    private EditText search;
    private DrawerLayout drawer;
    private ImageView head_portrait;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.icon);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();*/


        //实例化ToolBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        FragmentManager fm = getSupportFragmentManager();
        //导航图标
        toolbar.setNavigationIcon(R.drawable.caidan);
        //为导航  加一个监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.LEFT);//打开抽屉
            }
        });


        //ToolBar里的内容
        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar_title.setText(null);

        toolbar_search = findViewById(R.id.toolbar_search);
        toolbar_search.setVisibility(View.VISIBLE);

        search = findViewById(R.id.search);
        search.setFocusableInTouchMode(false);

        head_portrait = findViewById(R.id.head_portrait);
        head_portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });



        //抽屉item
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //底部按钮
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //导航按钮大于3个色时候，按钮标签强制显示
        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        replaceFragment(new HomeFragment());



    }

    //设置ToolBar上ImageView打开抽屉的方法
    private void toggle() {
        int drawerLockMode = drawer.getDrawerLockMode(GravityCompat.START);
        if (drawer.isDrawerVisible(GravityCompat.START)
                && (drawerLockMode != DrawerLayout.LOCK_MODE_LOCKED_OPEN)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (drawerLockMode != DrawerLayout.LOCK_MODE_LOCKED_CLOSED) {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    private void replaceFragment(Fragment fragment){
        //1、实例化Fragment对象
        FragmentManager fragmentManager=getSupportFragmentManager();
        //2、实例化FragmentTransaction对象
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        //3、通过事物对象,调用替换方法
        transaction.replace(R.id.framelayout,fragment);
        //4、执行事物
        transaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    toolbar_title.setText(null);
                    toolbar_search.setVisibility(View.VISIBLE);
                    search.setFocusableInTouchMode(false);
                    return true;
                case R.id.navigation_message:
                    replaceFragment(new MessageFragment());
                    toolbar_title.setText("消息");
                    toolbar_search.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_forum:
                    replaceFragment(new ForumFragment());
                    toolbar_title.setText("论坛");
                    toolbar_search.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_my:
                    replaceFragment(new MyFragment());
                    toolbar_title.setText("我的");
                    toolbar_search.setVisibility(View.GONE);
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
