package com.qiang.qiangapplication.aInterface;

import com.qiang.qiangapplication.bean.User;

/**
 * Created by Qiang on 2016/7/12.
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void hideKeyboard();

    void toMainActivity(User user);

    void showFailedError();

}
