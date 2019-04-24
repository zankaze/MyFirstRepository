package com.xa.fourth_p.pojo;

public class AdminUser {
    int aid;
    String accountname;
    String password;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "aid=" + aid +
                ", accountname='" + accountname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
