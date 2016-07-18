package com.lovedou.qiang.qiangapplication.bean;

import android.content.ContentValues;

/**
 * Created by Qiang on 2016/7/18.
 */
public class User extends BaseBean{

    public static final String INTENT_USER="intent_user";

    private static final String  USERNAME="username";
    private static final String  PASSWORD="password";


    private String username ;
    private String password ;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


    @Override
    ContentValues toContentValues() {
        ContentValues cv=new ContentValues();
        cv.put(USERNAME,username);
        cv.put(PASSWORD,password);
        return cv;
    }

    @Override
    public BaseBean  toEntity(ContentValues cv){
        User user=new User();
        user.setUsername((String) cv.get(USERNAME));
        user.setPassword((String) cv.get(PASSWORD));
        return user;
    }

}
