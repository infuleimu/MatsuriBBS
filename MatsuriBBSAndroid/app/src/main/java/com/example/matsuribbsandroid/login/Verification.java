package com.example.matsuribbsandroid.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.matsuribbsandroid.R;

public class Verification extends AppCompatActivity {
    CodeView codeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        codeView = (CodeView) findViewById(R.id.verify_code_view);
        codeView.setInputCompleteListener(new CodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                Toast.makeText(Verification.this, "inputComplete: " + codeView.getEditContent(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void invalidContent() {

            }
        });
    }

    public void verification_next(View view) {
        Intent intent = new Intent(Verification.this, FinishRegister.class);
        startActivity(intent);
    }
}
