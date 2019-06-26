package com.example.matsuribbsandroid.forumFragmentItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codingending.popuplayout.PopupLayout;
import com.example.matsuribbsandroid.R;
//论坛界面的子Fragment
public class SecondFragment extends Fragment {
    public SecondFragment(){}
    private boolean useRadius=true;//是否使用圆角特性

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);

       view.findViewById(R.id.btn_jianlai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupLayout popupLayout= PopupLayout.init(getContext(), R.layout.more_reply);
                popupLayout.setUseRadius(useRadius);
                popupLayout.setDismissListener(new PopupLayout.DismissListener() {
                    @Override
                    public void onDismiss() {
                        Toast.makeText(getContext(),"弹出窗口关闭",Toast.LENGTH_SHORT).show();
                    }
                });//添加监听器
                popupLayout.show(PopupLayout.POSITION_BOTTOM);
            }
        });

        return view;
    }
}
