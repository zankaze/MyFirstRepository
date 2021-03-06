package com.xa.fourth_p.service;

import com.xa.fourth_p.pojo.Goods;
import com.xa.fourth_p.pojo.PageBean;

import java.util.List;

public interface GoodsService {
    public List<Goods> getAllGoods();
    public Goods getOneGoods(int gid);
    public List<Goods> checkGoodsLike(Goods g);
    public int GetGoodsNum();
    public List<Goods> GoodsFenye(PageBean p);
    public boolean insertGoods(Goods g);
    public boolean deleteGoods(int gid);
    public boolean updateGoods(Goods g);
    public List<Goods> getAllGoods2();
    public List<Goods> GoodsFenye2(PageBean p);
    public Goods getOneGoodsByName(String gname);
}
