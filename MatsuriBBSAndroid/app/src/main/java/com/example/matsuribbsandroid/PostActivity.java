package com.example.matsuribbsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView btncollection=findViewById(R.id.btn_collection);



        setContentView(R.layout.activity_post);

    }
}
