package com.example.matsuribbsandroid.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.matsuribbsandroid.R;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }

    public void next(View view) {
        Intent intent = new Intent(Register.this, Verification.class);
        startActivity(intent);
    }
}
