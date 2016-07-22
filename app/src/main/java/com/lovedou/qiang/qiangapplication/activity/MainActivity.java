package com.lovedou.qiang.qiangapplication.activity;

import android.os.Bundle;

import com.lovedou.qiang.qiangapplication.R;
import com.lovedou.qiang.qiangapplication.bean.User;
import com.lovedou.qiang.qiangapplication.db.DBHandler;
import com.lovedou.qiang.qiangapplication.util.LogUtil;

public class MainActivity extends ActivityBase {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user1=new User();
        user1.setUsername("zhang");
        user1.setPassword("123");
        DBHandler.getInstance(this);
        DBHandler.getInstance(this).addUser(user1);
        User user=DBHandler.getInstance(this).searchUser("zhang");
        if(user!=null){
            LogUtil.i("",user.toString());
        }

    }


}
