package com.xuxx.spike.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {
	@Getter
	private static final long serialVersionUID = 3594977268950062804L;

	private String userName;
	private String userAccount;
	private String userPassword;
	private String userAddress;
	private String userEmail;
	private int userGender; // 性别，-1 未知，0 男性， 1女性
	private int userAge;
}