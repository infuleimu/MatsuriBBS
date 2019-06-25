package com.example.matsuribbsandroid.post;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.matsuribbsandroid.R;
import com.example.matsuribbsandroid.entity.Post;
import com.example.matsuribbsandroid.service.MatsuriBBSManager;
import com.example.matsuribbsandroid.service.MatsuriBBSService;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    @BindView(R.id.btn_collection)
    ImageView btnCollection;
    @BindView(R.id.postdetail_user_avatar)
    RoundedImageView postdetailUserAvatar;
    @BindView(R.id.postdetail_username)
    TextView postdetailUsername;
    @BindView(R.id.postdetail_date)
    TextView postdetailDate;
    @BindView(R.id.postdetail_btn_follow)
    Button postdetailBtnFollow;
    @BindView(R.id.postdetail_title)
    TextView postdetailTitle;
    @BindView(R.id.postdetail_content)
    TextView postdetailContent;
    @BindView(R.id.postdetail_replyNum)
    TextView postdetailReplyNum;
    @BindView(R.id.postdetail_likeNum)
    TextView postdetailLikeNum;
    @BindView(R.id.postdetail_toolbar)
    Toolbar postdetailToolbar;
    private Integer pid;
    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);

        ImageView btncollection = findViewById(R.id.btn_collection);

        //开启toolbar返回按钮
        setSupportActionBar(postdetailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);

        Intent intent = getIntent();
        pid = intent.getIntExtra("pid", -1);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadPostDetail();
    }

    private void loadPostDetail() {
        MatsuriBBSService service = MatsuriBBSManager.createOpenApiService();
        service.viewPostDetail(pid).enqueue(new Callback<PostDetailResponse>() {
            @Override
            public void onResponse(Call<PostDetailResponse> call, Response<PostDetailResponse> response) {
                if (!response.body().isError() && response.body().getCode() == 200 && response.body().getData() != null) {
                    post = response.body().getData();
                    setPostDetail(post);
                } else {
                    Toast.makeText(PostActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostDetailResponse> call, Throwable t) {
                Toast.makeText(PostActivity.this, "网络访问失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setPostDetail(Post postDetail) {
        postdetailTitle.setText(postDetail.getTitle());
        postdetailContent.setText(postDetail.getContent());
        postdetailUsername.setText(postDetail.getAuthor().getUserName());
        Picasso.get()
                .load(postDetail.getAuthor().getAvatar())
                .placeholder(R.drawable.avatar)
                .into(postdetailUserAvatar);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        postdetailDate.setText(dateFormat.format(postDetail.getPostDate()));
        postdetailReplyNum.setText(postDetail.getReplyNum().toString());
        postdetailLikeNum.setText(postDetail.getLikeNum().toString());
    }
}
