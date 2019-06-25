package com.example.matsuribbsandroid.forumFragmentItem;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.matsuribbsandroid.R;
import com.example.matsuribbsandroid.entity.Post;
import com.example.matsuribbsandroid.entity.SubSection;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

//论坛界面的子Fragment
public class FirstFragment extends Fragment {

    private List<SubSection> subSectionList=new ArrayList<>();
    private RecyclerView recyclerView;
    private SubSectionViewHolder.SubSectionAdapter subSectionAdapter;


    public FirstFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fifth,container,false);

        if (recyclerView!=null){
            recyclerView.setHasFixedSize(true);

            GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),3);
            recyclerView.setLayoutManager(layoutManager);
            subSectionAdapter=new SubSectionViewHolder.SubSectionAdapter(subSectionList,getContext(),R.layout.fragment_forum_item);
            recyclerView.setAdapter(subSectionAdapter);
        }

        return view;
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
}
