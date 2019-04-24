package com.xa.fourth_p.controller;

import com.xa.fourth_p.pojo.Goods;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.UserInfo;
import com.xa.fourth_p.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    GoodsService gs;

    @RequestMapping("getAllG")//全部商品展示
    public Object getAllG(){
        return gs.getAllGoods();
    }
//    @RequestMapping("getAllG2")//全部后台商品展示
//    public Object getAllG2(){
//        return gs.getAllGoods2();
//    }
    @RequestMapping("getOneG")//一个商品展示
    public Object getOneG(@RequestParam String gid){
        Integer id = Integer.valueOf(gid);
        Goods goods = gs.getOneGoods(id);
        return goods;
    }

    @RequestMapping("checkGlike")//商品模糊查询
    public Object checkGlike(@RequestParam String gname){
            if (gname==""){
                return gs.getAllGoods();
            }else{
                Goods goods = new Goods();
                goods.setGoodsname(gname);
                return gs.checkGoodsLike(goods);
            }
    }

    @RequestMapping("getNum2")//获取页数
    public Object getNum2(){
        List<Integer> list = new ArrayList<Integer>();
        int rows= 6;
        int rowsnum=gs.GetGoodsNum();
        int pageNum = rowsnum/rows;
        if (rowsnum % rows !=0){
            pageNum++;
        }
        for (int i =0;i<pageNum;i++){
            list.add(i+1);
        }
        return list;
    }



    @RequestMapping("fenye2")//获取商品分页数据
    public Object fenye2(@RequestParam String page){
        int pages= Integer.valueOf(page);
        int rows = 6;
        int num1 = (pages*rows+1);
        int num2 = (pages-1)*rows;
        PageBean pb = new PageBean();
        pb.setParamMax(num1);
        pb.setParamMin(num2);
        return gs.GoodsFenye(pb);
    }
    @RequestMapping("fenyeG2")//获取商品分页数据
    public Object fenyeG2(@RequestParam String page){
        int pages= Integer.valueOf(page);
        int rows = 6;
        int num1 = (pages*rows+1);
        int num2 = (pages-1)*rows;
        PageBean pb = new PageBean();
        pb.setParamMax(num1);
        pb.setParamMin(num2);
        return gs.GoodsFenye2(pb);
    }
    @RequestMapping("insertG")//新增商品
    public boolean insertG(@RequestBody Goods g,HttpSession session){
        boolean b = gs.insertGoods(g);
        session.setAttribute("goods",g);
        return b;

    }

    @RequestMapping("updateG")
    public boolean updateG(@RequestBody Goods g){
        return gs.updateGoods(g);
    }


}
