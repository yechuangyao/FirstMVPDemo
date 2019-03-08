package com.example.firstmvpdemo.view;

/**
 * @author yechuangyao
 * @date 2019/3/8 11:02
 * @description IPersonView接口
 */
public interface IPersonView {
    boolean checkInputInfo();   //检查输入的合法性

    void onRegisterSucceed();   //注册成功

    void onRegisterFailed();     //注册失败

    void onLoginSucceed();      //登陆成功

    void onLoginFailed();        //登录失败
}
