package com.xuxx.spike.dao;

import java.util.List;

import com.xuxx.spike.entity.SpikeProductInfo;
import com.xuxx.spike.vo.spike.SpikeProductVO;

public interface ISpikeProductDao {
	public void applySpikeProduct(SpikeProductInfo spikeProductInfo);
	public List<SpikeProductInfo> listByVO(SpikeProductVO spikeProductVO);
	public SpikeProductInfo getById(String id);
	public void delete(String id);

	public void update(SpikeProductInfo spikeProductInfo);
	public void updateSpikeProductState(SpikeProductVO spikeProductVO);
}
