package com.xuxx.spike.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseEntity implements Serializable{
	@Getter
	private static final long serialVersionUID = 3333945537180514900L;
	
	private String id;
	private String revision;
	private String createBy;
	private Date createTime;
	private String updatedBy;
	private Date updatedTime;
}
