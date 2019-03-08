package com.example.firstmvpdemo.presenter;

import com.example.firstmvpdemo.model.IPersonModel;
import com.example.firstmvpdemo.model.PersonModel;
import com.example.firstmvpdemo.view.IPersonView;

/**
 * @author yechuangyao
 * @date 2019/3/8 11:12
 * @description Person的Presenter类
 */
public class PersonPresenter {
    private IPersonModel iPersonModel;  //Model接口
    private IPersonView iPersonView;    //View接口

    public PersonPresenter(IPersonView iPersonView) {
        iPersonModel = new PersonModel();
        this.iPersonView = iPersonView;
    }

    public void registerPerson(String name, String pwd) {
        boolean isRegister = iPersonModel.onRegister(name, pwd);
        //根据Model中的结果调用不同的方法进行UI展示
        if (isRegister) {
            iPersonView.onRegisterSucceed();
        } else {
            iPersonView.onRegisterFailed();
        }
    }

    public void loginPerson(String name, String pwd) {
        boolean isLogin = iPersonModel.onLogin(name, pwd);
        //根据Model中的结果调用不同的方法进行UI展示
        if (isLogin) {
            iPersonView.onLoginSucceed();
        } else {
            iPersonView.onLoginFailed();
        }
    }
}
