package com.Logistics.entity;

/**
 * Created by JIAHAO on 2018/3/18.
 */
public class Customer {
    private Integer id; // 主键
    private String userName; // 用户姓名
    private String password; // 密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password="
                + password + "]";
    }
}
