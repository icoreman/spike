package com.xuxx.spike.entity;

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
public class Product extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商家id
     */
    private String merchantId;

    /**
     * 商品产地
     */
    private String productPlace;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品品牌
     */
    private String brandName;

    /**
     * 商品重量
     */
    private String productWeight;

    /**
     * 规格和保证
     */
    private String specification;

    /**
     * 详情图片地址
     */
    private String productPicture;

    public Product(String id, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String merchantId, String productPlace, String productName, String brandName, String productWeight, String specification, String productPicture) {
        this.id = id;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.merchantId = merchantId;
        this.productPlace = productPlace;
        this.productName = productName;
        this.brandName = brandName;
        this.productWeight = productWeight;
        this.specification = specification;
        this.productPicture = productPicture;
    }
}