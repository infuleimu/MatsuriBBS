package com.example.matsuribbsandroid.forumFragmentItem;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.matsuribbsandroid.R;
import com.example.matsuribbsandroid.entity.Post;
import com.example.matsuribbsandroid.entity.SubSection;
import com.example.matsuribbsandroid.service.MatsuriBBSManager;
import com.example.matsuribbsandroid.service.MatsuriBBSService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//论坛界面的子Fragment
public class FirstFragment extends Fragment {
    private int mid=1;
    private List<SubSection> subSectionList=new ArrayList<>();
    private RecyclerView recyclerView;
    private SubSectionAdapter subSectionAdapter;


    @Override
    public void onStart() {
        super.onStart();
        if (getUserVisibleHint()){
            loadSubSection();
        }
    }

    public FirstFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);

        recyclerView = view.findViewById(R.id.first_forum_recyclerView);

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        subSectionAdapter = new SubSectionAdapter(subSectionList,getContext(),R.layout.fragment_forum_item);
        recyclerView.setAdapter(subSectionAdapter);
    }

    private void loadSubSection(){
        MatsuriBBSService matsuriBBSService = MatsuriBBSManager.createOpenApiService();
        matsuriBBSService.viewSunSection(mid).enqueue(new Callback<SubSectionResponse>(){
            @Override
            public void onResponse(Call<SubSectionResponse> call, Response<SubSectionResponse> response) {
                if (response.body().getCode() == 200 && !response.body().isError() && response.body().getData() != null){
                    subSectionList = (response.body().getData());
                    subSectionAdapter.setData(subSectionList);
                    Log.e("abc", "获取成功");
                }
                else  {
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("abc","获取失败");
                }
            }

            @Override
            public void onFailure(Call<SubSectionResponse> call, Throwable t) {
                Toast.makeText(getContext(), "网络访问失败", Toast.LENGTH_SHORT).show();
                Log.e("abc","网络访问失败");
            }
        });
    }

    static class SubSectionViewHolder extends RecyclerView.ViewHolder{
        ImageView subSection_img;
        TextView subSection_title;
        public SubSectionViewHolder(@NonNull View itemView) {
            super(itemView);
            subSection_img = itemView.findViewById(R.id.subSection_img);
            subSection_title = itemView.findViewById(R.id.subSection_title);
        }

        public void updateSubSection(SubSection subSection){
            Context context = itemView.getContext();
            if (subSection==null || context==null){
                return;
            }

            Picasso.get().load(subSection.getCover()).placeholder(R.drawable.gd).into(subSection_img);
            subSection_title.setText(subSection.getTitle());
        }





        }
    static class SubSectionAdapter extends RecyclerView.Adapter<SubSectionViewHolder> {
        private List<SubSection> subSections;
        private Context context;

        @LayoutRes
        private int layoutResId;
        public SubSectionAdapter(List<SubSection>subSections, Context context, @LayoutRes int layoutResId){
            this.subSections = subSections;
            this.context = context;
            this.layoutResId = layoutResId;
        }

        @NonNull
        @Override
        public SubSectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context).inflate(layoutResId,parent,false);
            return new SubSectionViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull SubSectionViewHolder holder, int position) {
            if (holder==null)
                return;holder.updateSubSection(subSections.get(position));
        }

        @Override
        public int getItemCount() {
            return subSections.size();
        }

        public void setData(List<SubSection> subSections){
            this.subSections = subSections;
            notifyDataSetChanged();
        }
    }
}
