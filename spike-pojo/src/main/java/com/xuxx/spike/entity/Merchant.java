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
public class Merchant extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String merchantName;

    /**
     * 账号
     */
    private String merchantAccount;

    /**
     * 密码
     */
    private String merchantPassword;

    /**
     * 经营范围
     */
    private String merchantScope;

    /**
     * 店铺名称
     */
    private String merchantShopname;

    public Merchant(String id, String merchantName, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String merchantAccount, String merchantPassword, String merchantScope, String merchantShopname) {
        this.id = id;
        this.merchantName = merchantName;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.merchantAccount = merchantAccount;
        this.merchantPassword = merchantPassword;
        this.merchantScope = merchantScope;
        this.merchantShopname = merchantShopname;
    }
}