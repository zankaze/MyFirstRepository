package com.xa.fourth_p.service;

import com.xa.fourth_p.pojo.AdminUser;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.UserInfo;

import java.util.List;

public interface UserService {
    public List<UserInfo> getAllUser();//后台查看所有用户
    public UserInfo getOneUser(int uid);//获得一个用户的信息
    public List<UserInfo> checkLikeUser(UserInfo u);//模糊查询
    public List<UserInfo> PaiMing();//积分排名前10
    public boolean checkRes(String s);//注册时查重
    public UserInfo checkLogin(UserInfo u);//登录

    public int getCountNum();//分页参数
    public List<UserInfo> fenye(PageBean page);//分页
    public boolean insertUser(UserInfo u);//注册

    public boolean deleteUser(int uid);//删除

    public boolean updateUser(UserInfo u);//完善信息
//    public boolean JiFen(UserInfo u);//获取积分
//    public boolean VIP(UserInfo u);//办理VIP
//    public boolean ChongZhi(UserInfo u);//充值
//    public boolean GouMai(UserInfo u);//购买商品时扣除
public AdminUser getAdminUser(AdminUser ad);
}
