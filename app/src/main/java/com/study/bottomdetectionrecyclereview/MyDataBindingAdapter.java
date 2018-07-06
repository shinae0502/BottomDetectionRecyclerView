package com.study.bottomdetectionrecyclereview;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MyDataBindingAdapter {
    @BindingAdapter({"app:adapter", "app:layoutManager", "app:onScrollChangeListener", "app:myData"})
    public static void bind(RecyclerView recyclerView
            , RvAdt rvAdt
            , RecyclerView.LayoutManager layoutManager
            , RecyclerView.OnScrollListener onScrollListener
            , ArrayList<MyData> myData
    ) {
        rvAdt.setMyData(myData);
        recyclerView.setAdapter(rvAdt);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(onScrollListener);
    }
}
