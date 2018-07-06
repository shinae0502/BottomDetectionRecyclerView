package com.study.bottomdetectionrecyclereview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.study.bottomdetectionrecyclereview.databinding.ItemBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ItemBinding itemBinding;

    public static MyViewHolder create(ViewGroup parent, int viewType) {
        return new MyViewHolder(
                ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    public MyViewHolder(ItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.itemBinding = itemBinding;
    }
}