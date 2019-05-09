package com.xuxx.spike.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuxx.spike.dao.IOrderDao;
import com.xuxx.spike.entity.Order;
import com.xuxx.spike.service.IOrderService;
import com.xuxx.spike.vo.order.ConstomOrder;
import com.xuxx.spike.vo.order.OrderVO;

@Service
@org.apache.dubbo.config.annotation.Service(interfaceClass = IOrderService.class)
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderDao orderDao;

	@Override
	public void insert(Order order) {
		orderDao.insert(order);
	}

	@Override
	public List<Order> listByUserId(String userid) {
		return orderDao.listByUserId(userid);
	}

	@Override
	public List<Order> listorByMerchantId(String merchantid) {
		return orderDao.listorByMerchantId(merchantid);
	}

	@Override
	public void updatePayStatusById(int paystatus, String id) {
		OrderVO orderVO = new OrderVO();
		ConstomOrder constomOrder = new ConstomOrder();
		
		constomOrder.setPayStatus(paystatus);
		constomOrder.setId(id);
		
		orderVO.setConstomOrder(constomOrder);
		orderDao.updatePayStatusById(orderVO);
	}

	@Override
	public void updatePay(int paystatus, String id, int paytype, Date paytime) {
		OrderVO orderVO = new OrderVO();
		ConstomOrder constomOrder = new ConstomOrder();
		
		constomOrder.setPayStatus(paystatus);
		constomOrder.setId(id);
		constomOrder.setPayType(paytype);
		constomOrder.setPayTime(paytime);
		
		orderVO.setConstomOrder(constomOrder);
		orderDao.updatePay(orderVO);
	}
}
