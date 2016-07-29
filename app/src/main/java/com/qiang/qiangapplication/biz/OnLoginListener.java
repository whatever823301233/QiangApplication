package com.qiang.qiangapplication.biz;

import com.qiang.qiangapplication.bean.User;

/**
 * Created by Qiang on 2016/7/18.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();

}
