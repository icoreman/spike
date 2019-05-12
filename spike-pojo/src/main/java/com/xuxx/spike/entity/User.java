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
public class User extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 性别
     */
    private Integer userGender;

    /**
     * 年龄
     */
    private Integer userAge;

    /**
     * 地址
     */
    private String userAddress;

    /**
     * 邮箱
     */
    private String userEmail;

    public User(String id, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String userName, String userAccount, String userPassword, Integer userGender, Integer userAge, String userAddress, String userEmail) {
        this.id = id;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
    }
}