package com.xa.fourth_p.mapper;

import com.xa.fourth_p.pojo.OrderForm;
import com.xa.fourth_p.pojo.PageBean;

import java.util.List;

public interface OrderFormMapper {
    public List<OrderForm> getAllOrderForm();
    public List<OrderForm> getUserOrderForm(int uid);
    public void insertOrderForm(OrderForm of);

    public List<OrderForm> getAllOrd(PageBean pb);
    public int getOrdNum();
}
