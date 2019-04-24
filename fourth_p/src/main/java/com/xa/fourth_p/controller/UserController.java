package com.xa.fourth_p.controller;

import com.xa.fourth_p.mapper.GoodsMapper;
import com.xa.fourth_p.pojo.*;
import com.xa.fourth_p.service.GoodsService;
import com.xa.fourth_p.service.OrderFormService;
import com.xa.fourth_p.service.UserService;
import com.xa.fourth_p.utils.EmailUtis;
import com.xa.fourth_p.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService us;
    @Autowired
    GoodsService gs;
    @Autowired
    OrderFormService ofs;

    @RequestMapping("getuserall")//全部用户
    public Object getuserall(){
        return us.getAllUser();
    }
    @RequestMapping("getOneuser")//单个用户
    public Object getOneuser(@RequestParam String uid){
        int id = Integer.valueOf(uid);
        UserInfo user = us.getOneUser(id);
        if (user.getUserstatus().equals("false")){
            user.setUserstatus("信息未完善");
        }else{
            user.setUserstatus("信息已完善");
        }
        return user;
    }
    @RequestMapping("checkuserlike")//模糊
    public Object checkuserlike(@RequestParam String s){
        if (s==""){
            return us.getAllUser();
        }else{
            UserInfo userInfo = new UserInfo();
            userInfo.setEmail(s);
            userInfo.setUsername(s);
            userInfo.setAccountname(s);
            return us.checkLikeUser(userInfo);
        }

    }
    @RequestMapping("paiming")//排名
    public Object paiming(){
        return us.PaiMing();
    }

    @RequestMapping("doRes")//注册
    public boolean doRes(@RequestBody UserInfo u){
           boolean b = us.checkRes(u.getAccountname());
           if(b==false){
               return false;
           }else{
               String password = u.getPassword();
               MD5 md5 = new MD5();
               String pwd = md5.getMD5ofStr(password);
               u.setPassword(pwd);
               return   us.insertUser(u);
           }

    }
    @RequestMapping("insertUser")
    public boolean insertUser(@RequestBody UserInfo user){
        String password = user.getPassword();
        MD5 md5 = new MD5();
        String pwd = md5.getMD5ofStr(password);
        user.setPassword(pwd);
        boolean b = us.insertUser(user);
        return b;
    }
    @RequestMapping("getEmail")//获取邮箱发送验证码
    public Object getEmail(@RequestParam String email, HttpSession session){
        EmailUtis emailUtiles = new EmailUtis();
        String achieveCode= emailUtiles.achieveCode();
        EmailUtis.sendAuthCodeEmail(email,achieveCode);
        return achieveCode;
    }

    @RequestMapping("doLogin")//登录
    public Object doLogin(@RequestParam String accountname,@RequestParam String password,
                           @RequestParam String usertype, HttpSession session){
            if (usertype.equals("user")){
                UserInfo u = new UserInfo();
                u.setAccountname(accountname);
                MD5 md5 = new MD5();
                String pwd = md5.getMD5ofStr(password);
                u.setPassword(pwd);
                UserInfo userInfo = us.checkLogin(u);
                if(userInfo!=null){
                    session.setAttribute("user",userInfo);
                    return "user";
                }else {
                    return false;
                }
            }else{
                AdminUser ad = new AdminUser();
                ad.setAccountname(accountname);
                ad.setPassword(password);
                AdminUser adminUser = us.getAdminUser(ad);
                if(adminUser!=null){
                    session.setAttribute("admin",adminUser);
                    return "admin";
                }else {
                    return false;
                }
            }

    }

    @RequestMapping("getNum")//获取页数
    public Object getNum(){
        List<Integer> list = new ArrayList<Integer>();
        int rows= 5;
        int rowsnum=us.getCountNum();
        int pageNum = rowsnum/rows;
        if (rowsnum % rows !=0){
            pageNum++;
        }
        for (int i =0;i<pageNum;i++){
            list.add(i+1);
        }
        return list;
    }

    @RequestMapping("fenye")//获取分页数据
    public Object fenye(@RequestParam String page){
        int pages= Integer.valueOf(page);
        int rows = 5;
        int num1 = (pages*rows+1);
        int num2 = (pages-1)*rows;
        PageBean pb = new PageBean();
        pb.setParamMax(num1);
        pb.setParamMin(num2);
     return us.fenye(pb);
    }

    @RequestMapping("getUserName")//每个页面显示用户姓名
    public Object getUserName(HttpSession session){
        Object obj = session.getAttribute("user");
        UserInfo userInfo = (UserInfo) obj;

        return userInfo;
    }

    @RequestMapping("WanShan")//完善信息
    public boolean WanShan(@RequestBody UserInfo u , HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(u.getUsername()!=""&&u.getAddresses()!=""&u.getPhonenum()!=""){
            user.setUsername(u.getUsername());
            user.setAddresses(u.getAddresses());
            user.setPhonenum(u.getPhonenum());
            user.setUserstatus("true");
            return us.updateUser(user);
        }else{
            return false;
        }
    }
    @RequestMapping("Jifen")//记录积分
    public boolean Jifen(@RequestParam String sroce, HttpSession session){
        Integer point =Integer.valueOf(sroce);
        UserInfo user = (UserInfo) session.getAttribute("user");
        int userintegral = user.getUserintegral();
        if(user.getUserlevel().equals("1")){
            userintegral+=(point * 2);
            user.setUserintegral(userintegral);
            return us.updateUser(user);
        }else{
            userintegral+=point;
            user.setUserintegral(userintegral);
            return us.updateUser(user);
        }


    }

    @RequestMapping("Chongzhi")//充值
    public Object Chongzhi(@RequestParam String money,@RequestParam String pw, HttpSession session){
        String rex = "[0-9]{1,5}";
        boolean b = money.matches(rex);
        if (b==true){
            int m = money!=null?Integer.valueOf(money):0;
            UserInfo user = (UserInfo) session.getAttribute("user");
            MD5 md5 = new MD5();
            String pwd = md5.getMD5ofStr(pw);
            if(pwd.equals(user.getPassword())) {
                int usermoney = user.getUsermoney();
                usermoney += m;
                user.setUsermoney(usermoney);
                us.updateUser(user);
                return "true";
            }else{
                return "密码错误";
            }
        }else{
                return "充值金额只能为1~100000元";
        }


}

    @RequestMapping("getVIP")//升级VIP
    public Object getVIP(@RequestParam String password, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        int usermoney = user.getUsermoney();
        String pw = user.getPassword();
        MD5 md5 = new MD5();
        String pwd = md5.getMD5ofStr(password);
            if(user.getUserstatus().equals("true")){
                if(pw.equals(pwd)){
                    if (usermoney>=100){
                        usermoney -=100;
                        user.setUsermoney(usermoney);
                        user.setUserlevel("1");
                        us.updateUser(user);
                        return "true";
                    }else{
                        return "余额不足，请前往充值页面进行充值";
                    }
                }else {
                    return "密码错误，请重新输入";
                }
            }else{
                return "请您先完善信息";
            }

    }

    @RequestMapping("GouMai1")//余额支付、商品扣除、生成订单
    public Object GouMai1(@RequestParam String pw,@RequestParam String num,@RequestParam String gid,HttpSession session){
        Integer nums = Integer.valueOf(num);
        Integer goodsid = Integer.valueOf(gid);
        Goods goods = gs.getOneGoods(goodsid);
        int totalPrice = (goods.getGoodsprice()) * nums;
        UserInfo user = (UserInfo) session.getAttribute("user");
        MD5 md5 = new MD5();
        String pwd = md5.getMD5ofStr(pw);
        int usermoney = user.getUsermoney();
            if (user.getUserstatus().equals("true")){
                if (pwd.equals(user.getPassword())){
                    if(nums<=goods.getGoodsnum()){
                        if(usermoney>=totalPrice){
                            usermoney-=totalPrice;
                            user.setUsermoney(usermoney);
                            us.updateUser(user);//用户余额减少

                            int goodsnum = goods.getGoodsnum();
                            goodsnum -=nums;
                            goods.setGoodsnum(goodsnum);
                            gs.updateGoods(goods);//商品数量减少

                            OrderForm of = new OrderForm();
                            of.setUserid(user.getUserid());
                            of.setUsername(user.getUsername());
                            of.setAddresses(user.getAddresses());
                            of.setPhonenum(user.getPhonenum());
                            of.setGoodsname(goods.getGoodsname());
                            of.setGoodsprice(goods.getGoodsprice());
                            of.setGoodsphoto(goods.getGoodsphoto());
                            of.setOrdernum(nums);
                            ofs.insertOrderForm(of);//生成订单
                            return "true";
                        }else{
                            return "余额不足";
                        }
                    }else{
                        return "商品库存不足";
                    }
                }else{
                    return "密码错误";
                }
            }else {
                return "您还未完善信息，请前往个人中心";
            }
        }



    @RequestMapping("GouMai2")//积分支付、商品扣除、生成订单
    public Object GouMai2(@RequestParam String pw,@RequestParam String gid,HttpSession session){
        Integer nums = 1;
        Integer goodsid = Integer.valueOf(gid);
        Goods goods = gs.getOneGoods(goodsid);
        int totalPrice = (goods.getGoodsprice()) * nums * 300;
        UserInfo user = (UserInfo) session.getAttribute("user");
        MD5 md5 = new MD5();
        String pwd = md5.getMD5ofStr(pw);
        int point  = user.getUserintegral();
        if(user.getUserstatus().equals("true")){
            if (pwd.equals(user.getPassword())){
                if(nums<=goods.getGoodsnum()){
                    if(point >=totalPrice){
                        point -=totalPrice;
                        user.setUserintegral(point);
                        us.updateUser(user);//用户余额减少

                        int goodsnum = goods.getGoodsnum();
                        goodsnum -=1;
                        goods.setGoodsnum(goodsnum);
                        gs.updateGoods(goods);//商品数量减少

                        OrderForm of = new OrderForm();
                        of.setUserid(user.getUserid());
                        of.setUsername(user.getUsername());
                        of.setAddresses(user.getAddresses());
                        of.setPhonenum(user.getPhonenum());
                        of.setGoodsname(goods.getGoodsname());
                        of.setGoodsprice(goods.getGoodsprice());
                        of.setGoodsphoto(goods.getGoodsphoto());
                        of.setOrdernum(1);
                        ofs.insertOrderForm(of);//生成订单
                        return "true";
                    }else{
                        return "积分不足";
                    }
                }else {
                    return "商品库存不足";
                }
            }else{
                return "密码错误";
            }
        }else {
            return "您还未完善信息，请前往个人中心";
        }


    }


}
