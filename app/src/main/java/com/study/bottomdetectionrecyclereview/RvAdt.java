package com.study.bottomdetectionrecyclereview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RvAdt extends ProgressRvAdt<RecyclerView.ViewHolder> {

    ArrayList<MyData> myData;

    public void setMyData(ArrayList<MyData> myData) {
        this.myData = myData;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_PROGRESS)
            return ProgressHolder.create(parent, viewType);

        return MyViewHolder.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).setMyData(myData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (myData != null)
            count = myData.size();
        return count + super.getItemCount();
    }

}