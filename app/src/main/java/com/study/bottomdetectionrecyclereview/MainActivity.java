package com.study.bottomdetectionrecyclereview;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.study.bottomdetectionrecyclereview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        myViewModel = new MyViewModel();
        myViewModel.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.setViewModel(myViewModel);
        myViewModel.requestData();
    }


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
