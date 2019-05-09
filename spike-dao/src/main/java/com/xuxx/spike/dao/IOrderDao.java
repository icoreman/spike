package com.xuxx.spike.dao;

import java.util.List;

import com.xuxx.spike.entity.Order;
import com.xuxx.spike.vo.order.OrderVO;

public interface IOrderDao {
	public void insert(Order msorder);
	public void updatePayStatusById(OrderVO orderVO);
	public void updatePay(OrderVO orderVO);
	
	public List<Order> listByUserId(String userId);
	public List<Order> listorByMerchantId(String merchantId);
}
