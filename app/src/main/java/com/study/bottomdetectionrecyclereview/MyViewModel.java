package com.study.bottomdetectionrecyclereview;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MyViewModel extends ViewModel {
    MyData myData;
    RvAdt rvAdt;
    RecyclerView.LayoutManager layoutManager;

    boolean isLast;

    public RecyclerView.OnScrollListener getOnScrollListener() {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1) && !isLast) {
                    isLast = true;
                    Log.d("sarang", "lAst");
                }
            }
        };
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public MyData getMyData() {
        return myData;
    }

    public void setMyData(MyData myData) {
        this.myData = myData;
    }

    public RvAdt getRvAdt() {
        return rvAdt;
    }

    public void setRvAdt(RvAdt rvAdt) {
        this.rvAdt = rvAdt;
    }

    public MyViewModel() {
        myData = new MyData();
        rvAdt = new RvAdt();
    }

}