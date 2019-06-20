package com.example.matsuribbsandroid.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.matsuribbsandroid.R;

import static com.example.matsuribbsandroid.R.layout.item_fourm;

public class Fragment1 extends Fragment {
    private View v;
    private TextView tv;
    //回调用来接收参数
    public static Fragment1 getiniturl(String gc_id) {
        Fragment1 twoFragment = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putString("gc_id", gc_id);
        twoFragment.setArguments(bundle);
        return twoFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=View.inflate(getActivity(),item_fourm,null);
        //获取参数
        String  gc_id = getArguments().getString("gc_id");
        tv=v.findViewById(R.id.tv);
        tv.setText("标题"+gc_id);
        return v;
    }
}
