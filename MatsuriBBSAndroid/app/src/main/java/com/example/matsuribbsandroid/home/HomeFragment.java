package com.example.matsuribbsandroid.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matsuribbsandroid.GlideImageLoader;
import com.example.matsuribbsandroid.R;
import com.example.matsuribbsandroid.entity.Post;
import com.example.matsuribbsandroid.service.MatsuriBBSManager;
import com.example.matsuribbsandroid.service.MatsuriBBSService;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment{
    private View view;
    private Integer page = 1;
    private RecyclerView recyclerView;
    private List<Post> postList = new ArrayList<>();
    private HomeAdapter homeAdapter;

    public HomeFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = view.findViewById(R.id.home_post_recyclerView);

        List images = new ArrayList();
        images.add(R.drawable.timg);
        images.add(R.drawable.timg2);
        images.add(R.drawable.timg3);

        Banner banner = (Banner) view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        return view;
    }

    private void loadPost(Callback<HomePostResponse> callback){
        MatsuriBBSService matsuriBBSService = MatsuriBBSManager.createOpenApiService();
        matsuriBBSService.viewPost(page,null,null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        loadPost(new Callback<HomePostResponse>() {
            @Override
            public void onResponse(Call<HomePostResponse> call, Response<HomePostResponse> response) {
                if(response.body().getCode() == 200 && response.body().isError() && response.body().getData() != null){
                    postList = response.body().getData().getList();
                    homeAdapter.setData(postList);
                } else {
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<HomePostResponse> call, Throwable t) {
                Toast.makeText(getContext(), "网络访问失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (recyclerView != null){
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            homeAdapter = new HomeAdapter(postList,getContext(),R.layout.post_item);
        }
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder{
        TextView post_title;
        TextView post_content;
        TextView post_author;
        TextView post_viewNum;
        TextView post_replyNum;
        TextView post_likeNum;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.post_title = itemView.findViewById(R.id.post_title);
            this.post_content = itemView.findViewById(R.id.post_content);
            this.post_author = itemView.findViewById(R.id.post_author);
            this.post_viewNum = itemView.findViewById(R.id.post_viewNum);
            this.post_replyNum = itemView.findViewById(R.id.post_replyNum);
            this.post_likeNum = itemView.findViewById(R.id.post_likeNum);
        }

        public void updatePost(Post post) {
            Context context = itemView.getContext();
            if (post == null || context == null){
                return;
            }
            post_title.setText(post.getTitle());
            post_content.setText(post.getContent());
            post_author.setText(post.getAuthor().getUserName());
            post_viewNum.setText(post.getViewNum());
            post_replyNum.setText(post.getReplyNum());
            post_likeNum.setText(post.getLikeNum());
        }
    }

    static class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {
        private List<Post> post;
        private Context context;

        @LayoutRes
        private int layoutResId;

        public HomeAdapter(List<Post> post, Context context, int layoutResId) {
            this.post = post;
            this.context = context;
            this.layoutResId = layoutResId;
        }

        @NonNull
        @Override
        public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView =LayoutInflater.from(context).inflate(layoutResId, parent, false);
            return new HomeViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
            if (holder == null) return;
            holder.updatePost(post.get(position));
        }

        @Override
        public int getItemCount() {
            return post.size();
        }

        public void setData(List<Post> post) {
            this.post = post;
            notifyDataSetChanged();
        }
    }
}
