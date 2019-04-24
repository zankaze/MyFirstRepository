package com.xa.fourth_p.service.imp;

import com.xa.fourth_p.mapper.UserMapper;
import com.xa.fourth_p.pojo.AdminUser;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.UserInfo;
import com.xa.fourth_p.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper um;

    public List<UserInfo> getAllUser() {
        return um.getAllUser();
    }

    public UserInfo getOneUser(int uid) {
        return um.getOneUser(uid);
    }

    public List<UserInfo> checkLikeUser(UserInfo u) {
        return um.checkLikeUser(u);
    }

    public List<UserInfo> PaiMing() {
        return um.PaiMing();
    }

    public boolean checkRes(String s) {
        UserInfo userInfo = um.checkRes(s);
        if (userInfo==null){
            return true;
        }
        return false;
    }

    public UserInfo checkLogin(UserInfo u) {
       return um.checkLogin(u);
    }

    public int getCountNum() {
        return um.getCountNum();
    }

    public List<UserInfo> fenye(PageBean page) {
        return um.fenye(page);
    }

    public boolean insertUser(UserInfo u) {
        um.insertUser(u);
        return true;
    }

    public boolean deleteUser(int uid) {
        um.deleteUser(uid);
        return true;
    }

    public boolean updateUser(UserInfo u) {
        um.updateUser(u);
        return true;
    }

    @Override
    public AdminUser getAdminUser(AdminUser ad) {
        return um.getAdminUser(ad);
    }
}
