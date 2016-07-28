package com.lovedou.qiang.qiangapplication.bean;

import android.content.ContentValues;

/**
 * Created by Qiang on 2016/7/18.
 */
public class User extends BaseBean{

    public static final String TABLE_NAME="user";

    public static final String INTENT_USER="intent_user";

    public static final String  USER_ID="_id";
    public static final String  USERNAME="username";
    public static final String  PASSWORD="password";
    public static final String  OTHER="other";

    private int _id;
    private String username ;
    private String password ;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public ContentValues toContentValues() {
        ContentValues cv=new ContentValues();
        cv.put(USER_ID,_id);
        cv.put(USERNAME,username);
        cv.put(PASSWORD,password);
        return cv;
    }

    @Override
    public BaseBean  toEntity(ContentValues cv){
        User user=new User();
        user.set_id((Integer) cv.get(USER_ID));
        user.setUsername((String) cv.get(USERNAME));
        user.setPassword((String) cv.get(PASSWORD));
        return user;
    }


    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
