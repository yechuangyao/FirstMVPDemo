package com.example.firstmvpdemo.bean;

/**
 * @author yechuangyao
 * @date 2019/3/8 10:40
 * @description Person的Bean类
 */
public class PersonBean {
    private String name;
    private String pwd;

    public PersonBean(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
