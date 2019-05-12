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
	
	protected String id;
	protected Integer revision;
	protected String createdBy;
	protected Date createdTime;
	protected String updatedBy;
	protected Date updatedTime;
}
