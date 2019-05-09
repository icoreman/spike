package com.xuxx.spike.service;

import java.util.Date;
import java.util.List;

import com.xuxx.spike.entity.Order;

/**
 * 
 * @ClassName: IOrderService
 *
 * @author xuxx
 * @date 2019-05-09 16:47:37
 * @since JDK 1.8
 *
 */
public interface IOrderService {

	public void insert(Order order);

	public List<Order> listByUserId(String userid);
	public List<Order> listorByMerchantId(String merchantid);

	public void updatePayStatusById(int paystatus, String id);
	public void updatePay(int paystatus, String id, int paytype, Date paytime);
}
