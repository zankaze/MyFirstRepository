package com.xa.fourth_p.mapper;

import com.xa.fourth_p.pojo.AdminUser;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.UserInfo;

import java.util.List;

public interface UserMapper {
    public List<UserInfo> getAllUser();//后台查看所有用户
    public UserInfo getOneUser(int uid);//获得一个用户的信息
    public List<UserInfo> checkLikeUser(UserInfo u);//模糊查询
    public List<UserInfo> PaiMing();//积分排名前10
    public UserInfo checkRes(String s);//注册时查重
    public UserInfo checkLogin(UserInfo u);//登录

    public int getCountNum();//分页参数
    public List<UserInfo> fenye(PageBean page);//分页
    public void insertUser(UserInfo u);//注册

    public void deleteUser(int uid);//删除

    public void updateUser(UserInfo u);//所有修改行为

    public AdminUser getAdminUser(AdminUser ad);
}
