package com.imooc.vo;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/6
 * Time: 10:28
 * Description:
 */
public class User {

    private String username;

    private String password;

    private Date date;

    private boolean remenberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRemenberMe() {
        return remenberMe;
    }

    public void setRemenberMe(boolean remenberMe) {
        this.remenberMe = remenberMe;
    }
}
