package com.xuxx.spike.vo.spike;

import java.math.BigDecimal;
import java.util.Date;

import com.xuxx.spike.entity.SpikeProductInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConstomSpikeProduct  extends SpikeProductInfo {
	private BigDecimal startSpikePrice;//秒杀价格查询范围开始
	private BigDecimal endmSpikePrice;//秒杀价格查询范围结束
	
	private BigDecimal startOriginalPrice;//商品原价查询范围开始
	private BigDecimal endOriginalPrice;//商品原价查询范围结束
	
	private Date startApplyDate;//申请时间查询范围开始时间
	private Date endApplyDate;//申请时间查询范围结束时间
	
	private Date startAuditDate;//审核时间查询范围开始时间
	private Date endAuditDate;//审核时间查询范围结束时间
	
	private Date startStartTime;//秒杀开始时间查询范围开始时间
	private Date endStartTime;//秒杀开始时间查询范围结束时间
	
	private Date startEndTime;//秒杀结束时间查询范围开始时间
	private Date endEndTime;//秒杀结束时间查询范围结束时间
	
	private int startProductCount;//秒杀商品数开始范围
	private int endProductCount;//秒杀商品数结束范围
	
	private int startStockCount;//库存开始范围
	private int endStockCount;//库存结束范围
}