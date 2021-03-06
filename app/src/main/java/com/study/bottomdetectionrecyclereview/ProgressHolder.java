package com.study.bottomdetectionrecyclereview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.study.bottomdetectionrecyclereview.databinding.ItemBinding;
import com.study.bottomdetectionrecyclereview.databinding.ProgressBinding;

public class ProgressHolder extends RecyclerView.ViewHolder {
    ProgressBinding progressBinding;

    public static ProgressHolder create(ViewGroup parent, int viewType) {
        return new ProgressHolder(
                ProgressBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    public ProgressHolder(ProgressBinding progressBinding) {
        super(progressBinding.getRoot());
        this.progressBinding = progressBinding;
    }
}