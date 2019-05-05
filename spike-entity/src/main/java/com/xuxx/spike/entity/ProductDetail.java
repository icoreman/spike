package com.xuxx.spike.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDetail extends BaseEntity{
	@Getter
	private static final long serialVersionUID = -5990650636102050287L;
	
	private int merchantId;//商家id
	private String productPlace;//商品产地
	private String productName;//商品名称
	private String brandName;//商品品牌
	private String productWeight;//商品重量
	private String specification;//规格和包装
	private String productDetailPicture;//详情图片地址
}
