package com.lovedou.qiang.qiangapplication.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.lovedou.qiang.qiangapplication.R;

public class MainActivity extends ActivityBase {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=(ImageView) findViewById(R.id.imageView);


    }
}
