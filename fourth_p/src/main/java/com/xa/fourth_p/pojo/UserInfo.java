package com.xa.fourth_p.pojo;

public class UserInfo {
    int userid;
    String accountname;
    String password;
    String username = null;
    String email;
    String addresses;
    String phonenum;
    String headportrait;//用户头像
    String userstatus = "false";//信息是否完善
    String userlevel = "0";
    int userintegral = 0;//积分数
    int usermoney = 0;//余额

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public int getUserintegral() {
        return userintegral;
    }

    public void setUserintegral(int userintegral) {
        this.userintegral = userintegral;
    }

    public int getUsermoney() {
        return usermoney;
    }

    public void setUsermoney(int usermoney) {
        this.usermoney = usermoney;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid=" + userid +
                ", accountname='" + accountname + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", addresses='" + addresses + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", headportrait='" + headportrait + '\'' +
                ", userstatus='" + userstatus + '\'' +
                ", userlevel='" + userlevel + '\'' +
                ", userintegral=" + userintegral +
                ", usermoney=" + usermoney +
                '}';
    }
}
