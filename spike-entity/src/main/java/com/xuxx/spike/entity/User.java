package com.xuxx.spike.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {
	@Getter
	private static final long serialVersionUID = 3594977268950062804L;

	private String name;
	private String userAccount;
	private String userPassword;
	private String userAddress;
	private String userEmail;
	private int userGender;
	private int userAge;
}