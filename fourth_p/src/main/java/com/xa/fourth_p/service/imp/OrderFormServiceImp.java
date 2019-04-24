package com.xa.fourth_p.service.imp;

import com.xa.fourth_p.mapper.OrderFormMapper;
import com.xa.fourth_p.pojo.OrderForm;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFormServiceImp implements OrderFormService {
    @Autowired
    OrderFormMapper ofm;

    public List<OrderForm> getAllOrderForm() {
        return ofm.getAllOrderForm();
    }

    public List<OrderForm> getUserOrderForm(int uid) {
        return ofm.getUserOrderForm(uid);
    }

    public boolean insertOrderForm(OrderForm of) {
        ofm.insertOrderForm(of);
        return true;
    }

    @Override
    public List<OrderForm> getAllOrd(PageBean pb) {
        return ofm.getAllOrd(pb);
    }

    @Override
    public int getOrdNum() {
        return ofm.getOrdNum();
    }
}
