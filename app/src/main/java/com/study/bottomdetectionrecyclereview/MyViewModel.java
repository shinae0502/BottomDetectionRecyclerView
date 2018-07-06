package com.study.bottomdetectionrecyclereview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MyViewModel extends BaseObservable {
    ArrayList<MyData> myData;

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    RvAdt rvAdt;


    public RvAdt getRvAdt() {
        return rvAdt;
    }

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
        ArrayList newMyData = new ArrayList();
        if (myData.size() < 100) {
            newMyData.add(new MyData());
            newMyData.add(new MyData());
            newMyData.add(new MyData());
            newMyData.add(new MyData());
            newMyData.add(new MyData());
            newMyData.add(new MyData());
            newMyData.add(new MyData());
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

        if (newMyData.size() < 10) {
            rvAdt.setLoadFinished(true);
        } else {
            isLast = false;
        }

        myData.addAll(newMyData);
        rvAdt.notifyDataSetChanged();


    }


    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }


    public void setRvAdt(RvAdt rvAdt) {
        this.rvAdt = rvAdt;
    }

    public MyViewModel() {
        rvAdt = new RvAdt();
        this.myData = new ArrayList<>();
    }

    public ArrayList<MyData> getMyData() {
        return myData;
    }

    @Bindable
    public void setMyData(ArrayList<MyData> myData) {
        this.myData = myData;
    }

}