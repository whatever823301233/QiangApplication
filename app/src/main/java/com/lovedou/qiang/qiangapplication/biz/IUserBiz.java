package com.lovedou.qiang.qiangapplication.biz;

/**
 * Created by Qiang on 2016/7/12.
 */
public interface IUserBiz {

    void login(String username, String password, OnLoginListener loginListener);

}
