package com.xa.fourth_p.service;

import com.xa.fourth_p.pojo.OrderForm;
import com.xa.fourth_p.pojo.PageBean;

import java.util.List;

public interface OrderFormService {
    public List<OrderForm> getAllOrderForm();
    public List<OrderForm> getUserOrderForm(int uid);
    public boolean insertOrderForm(OrderForm of);
    public List<OrderForm> getAllOrd(PageBean pb);
    public int getOrdNum();
}
