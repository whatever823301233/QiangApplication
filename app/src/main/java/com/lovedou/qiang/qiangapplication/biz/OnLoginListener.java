package com.lovedou.qiang.qiangapplication.biz;

import com.lovedou.qiang.qiangapplication.bean.User;

/**
 * Created by Qiang on 2016/7/18.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();

}
