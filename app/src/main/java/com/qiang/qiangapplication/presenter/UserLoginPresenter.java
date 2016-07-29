package com.qiang.qiangapplication.presenter;

import android.os.Handler;

import com.qiang.qiangapplication.aInterface.IUserLoginView;
import com.qiang.qiangapplication.bean.User;
import com.qiang.qiangapplication.biz.IUserBiz;
import com.qiang.qiangapplication.biz.OnLoginListener;
import com.qiang.qiangapplication.biz.UserBiz;

/**
 * Created by Qiang on 2016/7/12.
 *
 */
public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler;


    public UserLoginPresenter(IUserLoginView userLoginView){
        this.userLoginView=userLoginView;
        userBiz=new UserBiz();
        mHandler=new Handler();
    }

    public void login(){
        userLoginView.showLoading();
        userLoginView.hideKeyboard();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener()
        {
            @Override
            public void loginSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
