package com.xuxx.spike.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @ClassName: Order
 *
 * @author xuxx
 * @date 2019-05-09 15:26:18
 * @since JDK 1.8
 *
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class Order extends BaseEntity {
	private static final long serialVersionUID = 6287866588951674963L;
	private String productId;// 秒杀商品id
	private BigDecimal payAmount;// 支付金额
	private String userId;// 用户id
	private String merchantId;// 商家id
	private Date orederTime;// 创建时间
	private Date payTime;// 支付时间
	private int payStatus;// 支付转态 1,未支付 2,已支付，3，退款成功,4。用户发起退款申请 5，退款失败
	private String receiveAddress;// 收货人地址
	private String receiveName;// 收货人姓名
	private String receivePhone;// 收货人电话
	private String tradeSerialNumber;// 交易流水号
	private int num;// 数量
	private int payType;// 1代表支付宝 2代表微信 3代表银联
}
