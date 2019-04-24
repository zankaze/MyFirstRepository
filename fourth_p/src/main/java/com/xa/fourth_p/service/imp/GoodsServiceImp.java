package com.xa.fourth_p.service.imp;

import com.xa.fourth_p.mapper.GoodsMapper;
import com.xa.fourth_p.pojo.Goods;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService {
    @Autowired
    GoodsMapper gm;

    public List<Goods> getAllGoods() {
        return gm.getAllGoods();
    }

    public Goods getOneGoods(int gid) {
        return gm.getOneGoods(gid);
    }

    public List<Goods> checkGoodsLike(Goods g) {
        return gm.checkGoodsLike(g);
    }

    public int GetGoodsNum() {
        return gm.GetGoodsNum();
    }

    public List<Goods> GoodsFenye(PageBean p) {
        return gm.GoodsFenye(p);
    }

    public boolean insertGoods(Goods g) {
        gm.insertGoods(g);
        return true;
    }

    public boolean deleteGoods(int gid) {
        gm.deleteGoods(gid);
        return true;
    }

    public boolean updateGoods(Goods g) {
        gm.updateGoods(g);
        return true;
    }

    @Override
    public List<Goods> getAllGoods2() {
        return gm.getAllGoods2();
    }

    @Override
    public List<Goods> GoodsFenye2(PageBean p) {
        return gm.GoodsFenye2(p);
    }

    @Override
    public Goods getOneGoodsByName(String gname) {
        return gm.getOneGoodsByName(gname);
    }
}
