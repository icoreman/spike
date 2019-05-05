package com.xuxx.spike.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = false)
public class Merchant extends BaseEntity {
	@Getter
	private static final long serialVersionUID = 2544628278369164066L;
	
	private String merchantName;
	private String merchantAccount;
	private String merchantPassword;
	private String merchantScope;
	private String merchantShopname;
}
