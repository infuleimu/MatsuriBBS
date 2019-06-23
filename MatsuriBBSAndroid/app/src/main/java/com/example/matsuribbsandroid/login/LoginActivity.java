package com.example.matsuribbsandroid.login;

import android.content.ContentValues;
import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.matsuribbsandroid.R;
import com.example.matsuribbsandroid.entity.User;
import com.example.matsuribbsandroid.register.Register;
import com.example.matsuribbsandroid.service.MatsuriBBSManager;
import com.example.matsuribbsandroid.service.MatsuriBBSService;
import com.example.matsuribbsandroid.sqlitedatabase.StuDBHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
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
                login();
            }
        });

    }

    public void login(){
        loadUser(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getData() != null) {
                    StuDBHelper dbHelper = new StuDBHelper(LoginActivity.this,"user_db",null,1);
                    SQLiteDatabase db =dbHelper.getWritableDatabase();
                    User user = response.body().getData().getUser();

                    ContentValues values = new ContentValues();
                    values.put("uid",user.getId());
                    values.put("username",user.getUserName());
                    values.put("email",user.getEmail());
                    values.put("phone",user.getPhone());
                    values.put("sex",user.getSex());
                    values.put("token",response.body().getData().getToken());
                    //String sql="insert into user_table(id,userName,email,phone,sex) values("+id+",'"+response_email+"','"+response_username+"','"+response_phone+"','"+response_sex+"')";
                    //db.execSQL(sql);
                    db.insert("user_table",null,values);
                    db.close();
                    Intent data = new Intent();
                    data.putExtra("userId",user.getId());
                    setResult(1,data);
                    Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "网络访问失败", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(LoginActivity.this, Register.class);
        startActivity(intent);
    }
}
