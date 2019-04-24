package com.xa.fourth_p.controller;

import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.UserInfo;
import com.xa.fourth_p.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderFormController {
    @Autowired
    OrderFormService ofs;

    @RequestMapping("getAllOder")//获取所有订单
    public Object getAllOder(){
        return ofs.getAllOrderForm();
    }

    @RequestMapping("getUserOder")//获取该用户所有订单
    public Object getUserOder(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        int userid = user.getUserid();
        return ofs.getUserOrderForm(userid);
    }


    @RequestMapping("fenye4")//获取商品分页数据
    public Object fenye4(@RequestParam String page){
        int pages= Integer.valueOf(page);
        int rows = 5;
        int num1 = (pages*rows+1);
        int num2 = (pages-1)*rows;
        PageBean pb = new PageBean();
        pb.setParamMax(num1);
        pb.setParamMin(num2);
        return ofs.getAllOrd(pb);
    }
    @RequestMapping("getNum4")//获取页数
    public Object getNum4(){
        List<Integer> list = new ArrayList<Integer>();
        int rows= 6;
        int rowsnum=ofs.getOrdNum();
        int pageNum = rowsnum/rows;
        if (rowsnum % rows !=0){
            pageNum++;
        }
        for (int i =0;i<pageNum;i++){
            list.add(i+1);
        }
        return list;
    }
}
