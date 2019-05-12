package com.xuxx.spike.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2019-05-12 17:11:00
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 商家id
     */
    private String merchantId;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 收货人地址
     */
    private String receiveAddress;

    /**
     * 收货人姓名
     */
    private String receiveName;

    /**
     * 收货人电话
     */
    private String receivePhone;

    /**
     * 交易流水号
     */
    private String tradeserialNumber;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 下单时间
     */
    private Date orderTime;

    public Order(String id, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String productId, BigDecimal payAmount, Integer payType, String userId, String merchantId, Date payTime, Integer payStatus, String receiveAddress, String receiveName, String receivePhone, String tradeserialNumber, Integer num, Date orderTime) {
        this.id = id;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.productId = productId;
        this.payAmount = payAmount;
        this.payType = payType;
        this.userId = userId;
        this.merchantId = merchantId;
        this.payTime = payTime;
        this.payStatus = payStatus;
        this.receiveAddress = receiveAddress;
        this.receiveName = receiveName;
        this.receivePhone = receivePhone;
        this.tradeserialNumber = tradeserialNumber;
        this.num = num;
        this.orderTime = orderTime;
    }
}