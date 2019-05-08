package com.xuxx.spike.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = false)
public class SpikeProductInfo extends BaseEntity {
	@Getter
	private static final long serialVersionUID = 4172075940533349622L;
	
	private String productId;//商品id
	private String productTitle;//商品标题
	private String productPicture;//商品图片地址
	private BigDecimal spikePrice;//秒杀价格
	private BigDecimal originalPrice;//商品原价
	private String merchantId;//商家id
	private Date applyDate;//申请时间
	private Date auditDate;//审核时间
	private int auditState;//审核转态0,未审核，1，审核通过，2，审核不通过
	private Date startTime;//秒杀开始时间
	private Date endTime;//秒杀结束时间
	private String startTimeString;//开始时间string
	private String endTimeString;//结束时间string
	private int productCount;//秒杀商品数量
	private int stockCount;//库存
	private String description;//描述
}
