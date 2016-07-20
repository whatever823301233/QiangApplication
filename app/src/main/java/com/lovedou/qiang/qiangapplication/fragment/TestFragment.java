package com.lovedou.qiang.qiangapplication.fragment;

import android.support.v4.app.Fragment;

import com.lovedou.qiang.qiangapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseFragment {


    public TestFragment() {
        // Required empty public constructor
    }
    public static TestFragment newInstance(){
        return  new TestFragment();
    }
    @Override
    void initView() {
        setContentView(R.layout.fragment_test);
    }
}
