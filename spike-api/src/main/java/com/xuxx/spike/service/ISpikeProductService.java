package com.xuxx.spike.service;

import java.util.List;

import com.xuxx.spike.entity.SpikeProductInfo;
import com.xuxx.spike.vo.spike.SpikeProductVO;


public interface ISpikeProductService {
	/**
	 * 申请秒杀商品
	 * @param productInfo
	 */
	public void applySpikeProduct(SpikeProductInfo spikeProductInfo);
	
	/**
	 * 秒杀商品列表
	 * @param productInfo
	 */
	public List<SpikeProductInfo> listSpikeProduct(SpikeProductVO productVO);
	
	/**
	 * 根据秒杀商品id查询秒杀商品
	 * @param productInfo
	 */
	public SpikeProductInfo querySpikeProductById(String id);
	
	public void deleteSpikeProductById(String id);
	
	public void updateSpikeProduct(SpikeProductInfo spikeProductInfo);
	
	/**
	 * 更新状态
	 * @param id
	 * @param state
	 */
	public void updateSpikeProductState(String id,int state);
}
