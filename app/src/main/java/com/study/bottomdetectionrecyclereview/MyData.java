package com.study.bottomdetectionrecyclereview;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyData {

    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    MyData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
        data = simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

}