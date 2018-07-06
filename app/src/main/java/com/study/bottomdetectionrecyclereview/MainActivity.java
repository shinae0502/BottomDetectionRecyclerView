package com.study.bottomdetectionrecyclereview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.study.bottomdetectionrecyclereview.databinding.ActivityMainBinding;

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
}
