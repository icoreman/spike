package com.xuxx.spike.vo.order;

import com.xuxx.spike.entity.Order;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConstomOrder extends Order {
	private int stockcount;

}
