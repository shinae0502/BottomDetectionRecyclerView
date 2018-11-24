package com.study.bottomdetectionrecyclereview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.study.bottomdetectionrecyclereview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    boolean isLast;
    RecyclerView rv;
    private ArrayList<MyData> myData = new ArrayList<>();
    private RvAdt rvAdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        rv = activityMainBinding.rv;
        rvAdt = new RvAdt();
        rv.setAdapter(rvAdt);
        rvAdt.setMyData(myData);
        rv.setLayoutManager(new LinearLayoutManager(this));
        requestData();
    }

    public RecyclerView.OnScrollListener getOnScrollListener() {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1) && !isLast) {
                    isLast = true;
                    Log.d("sarang", "lAst");
                    new Handler() {
                        @Override
                        public void handleMessage(Message msg) {
                            super.handleMessage(msg);
                            requestData();
                        }
                    }.sendEmptyMessageDelayed(0, 500);
                }
            }
        };
    }

    public void requestData() {
        handler.sendEmptyMessageDelayed(1, 3000);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (!rv.canScrollVertically(1)) {
                    requestData();
                } else {
                    isLast = false;
                }
            } else if (msg.what == 1) {
                ArrayList newMyData = new ArrayList();
                if (myData.size() < 100) {
                    newMyData.add(new MyData());
                    newMyData.add(new MyData());
                    newMyData.add(new MyData());
                    newMyData.add(new MyData());
                } else {
                    newMyData.add(new MyData());
                    newMyData.add(new MyData());
                    newMyData.add(new MyData());
                    newMyData.add(new MyData());
                    newMyData.add(new MyData());
                }

                myData.addAll(newMyData);
                rvAdt.notifyDataSetChanged();
                handler.sendEmptyMessageDelayed(0, 100);
            }
        }
    };

}
