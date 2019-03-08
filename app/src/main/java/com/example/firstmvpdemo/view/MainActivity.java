package com.example.firstmvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firstmvpdemo.R;
import com.example.firstmvpdemo.presenter.PersonPresenter;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity implements IPersonView, View.OnClickListener {
    /*=====控件相关=====*/
    private MaterialEditText nameEText;
    private MaterialEditText pwdEText;
    /*=====数据相关=====*/
    private Toast toast;
    private String inputName;
    private String inputPwd;
    private PersonPresenter personPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();     //初始化View
        initData();     //初始化Data
    }

    /**
     * 初始化View
     */
    private void initView() {
        nameEText = findViewById(R.id.met_main_name);
        pwdEText = findViewById(R.id.met_main_pwd);
        Button registerButton = findViewById(R.id.btn_main_register);
        Button loginButton = findViewById(R.id.btn_main_login);

        registerButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    /**
     * 初始化Data
     */
    private void initData() {
        //需要持有一个Presenter的实例
        personPresenter = new PersonPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_register:
                if (checkInputInfo()) {
                    //通过Presenter对View和Model进行沟通
                    personPresenter.registerPerson(inputName, inputPwd);
                }
                break;
            case R.id.btn_main_login:
                if (checkInputInfo()) {
                    //通过Presenter对View和Model进行沟通
                    personPresenter.loginPerson(inputName, inputPwd);
                }
                break;
        }
    }

    /*========== IPersonView接口方法 START ==========*/

    /**
     * 检查输入信息的合法性
     *
     * @return true：输入合法，false：输入不合法
     */
    @Override
    public boolean checkInputInfo() {
        if (nameEText.getText() != null) {
            inputName = nameEText.getText().toString().trim();
        }
        if (pwdEText.getText() != null) {
            inputPwd = pwdEText.getText().toString().trim();
        }
        if (inputName.equals("")) {
            nameEText.setError("用户名不能为空");
            return false;
        }
        if (inputPwd.equals("")) {
            pwdEText.setError("密码不能为空");
            return false;
        }
        return true;
    }

    @Override
    public void onRegisterSucceed() {
        showToast("注册成功");
    }

    @Override
    public void onRegisterFailed() {
        showToast("用户已存在");
    }

    @Override
    public void onLoginSucceed() {
        showToast("登录成功");
    }

    @Override
    public void onLoginFailed() {
        showToast("用户不存在或密码错误");
    }

    /*========== IPersonView接口方法 END ==========*/

    /**
     * 显示Toast
     *
     * @param string Toast内容
     */
    private void showToast(String string) {
        if (toast == null) {
            toast = Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.setText(string);
            toast.show();
        }
    }
}
