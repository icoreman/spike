package com.xuxx.spike.vo.order;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OrderVO implements Serializable{
	private ConstomOrder constomOrder;
	
}
