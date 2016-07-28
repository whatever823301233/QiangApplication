package com.lovedou.qiang.qiangapplication.activity;

import android.os.Bundle;

import com.lovedou.qiang.qiangapplication.R;
import com.lovedou.qiang.qiangapplication.bean.User;
import com.lovedou.qiang.qiangapplication.db.DBHandler;
import com.lovedou.qiang.qiangapplication.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActivityBase {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<User> users=new ArrayList<>();

        User user1=new User();
        user1.setUsername("zhang");
        user1.setPassword("123");

        User user2=new User();
        user2.setUsername("wang");
        user2.setPassword("456");

        User user3=new User();
        user3.setUsername("li");
        user3.setPassword("789");

        User user4=new User();
        user4.setUsername("zhao");
        user4.setPassword("987");

        User user5=new User();
        user5.setUsername("lin");
        user5.setPassword("654");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);


        DBHandler.getInstance(this).addUsers(users);


        List<User> mList=DBHandler.getInstance(this).query();
        for(User user:mList){
            LogUtil.i("",user.toString());
        }


        LogUtil.i("","-------------------------------");
        /*User mUser=DBHandler.getInstance(this).queryUser("lin");
        if(null!=mUser){
            LogUtil.i("",mUser.toString());
        }*/


        DBHandler.getInstance(this).deleteOldUser("zhao");


        List<User> mList2=DBHandler.getInstance(this).query();
        for(User user:mList2){
            LogUtil.i("",user.toString());
        }


    }


}
