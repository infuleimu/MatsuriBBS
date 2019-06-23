package com.example.matsuribbsandroid.login;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.matsuribbsandroid.R;
import com.example.matsuribbsandroid.core.UserManager;
import com.example.matsuribbsandroid.entity.User;
import com.example.matsuribbsandroid.register.Register;
import com.example.matsuribbsandroid.service.MatsuriBBSManager;
import com.example.matsuribbsandroid.service.MatsuriBBSService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private String email;
    private String password;

    @BindView(R.id.login_email)
    EditText loginEmail;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginJudge();
            }
        });

    }

    public void loginJudge(){
        loadUser(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getData() != null) {
                    User user = response.body().getData().getUser();

                        Toast.makeText(Login.this, "登录成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, "访问失败", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void loadUser(Callback<LoginResponse> callback) {
        email = loginEmail.getText().toString();
        password = loginPassword.getText().toString();
        MatsuriBBSService loginService = MatsuriBBSManager.createOpenApiService();
        loginService.login(email, password).enqueue(callback);
    }

    public void register(View view) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}
