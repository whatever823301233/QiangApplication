package com.qiang.qiangapplication.activity;

import android.os.Bundle;
import android.widget.Button;

import com.qiang.qiangapplication.R;
import com.qiang.qiangapplication.custom.NetImageView;
import com.qiang.qiangapplication.custom.RoundImageView;
import com.qiang.qiangapplication.util.LogUtil;

public class MainActivity extends ActivityBase {

    String url="http://c.hiphotos.baidu.com/image/pic/item/a08b87d6277f9e2f2577db011d30e924b899f37d.jpg";
    private RoundImageView roundImageView;
    private NetImageView netImageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int maxMemory= (int) (Runtime.getRuntime().maxMemory()/1024/1024);

        LogUtil.i("","最大可用内存为： "+maxMemory);

    }


}
