package com.example.firstmvpdemo.model;

/**
 * @author yechuangyao
 * @date 2019/3/8 10:47
 * @description IPersonModel接口
 */
public interface IPersonModel {
    //注册账号
    boolean onRegister(String name, String pwd);

    //登录账号
    boolean onLogin(String name, String pwd);
}
