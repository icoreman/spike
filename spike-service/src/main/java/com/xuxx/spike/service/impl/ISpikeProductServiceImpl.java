package com.xuxx.spike.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuxx.spike.dao.ISpikeProductDao;
import com.xuxx.spike.entity.SpikeProductInfo;
import com.xuxx.spike.service.ISpikeProductService;
import com.xuxx.spike.util.DateUtils;
import com.xuxx.spike.vo.spike.ConstomSpikeProduct;
import com.xuxx.spike.vo.spike.SpikeProductVO;

@Service
public class ISpikeProductServiceImpl implements ISpikeProductService {

	@Autowired
	ISpikeProductDao spikeProductDao;

	/**
	 * 申请秒杀商品
	 * 
	 * @param msproductinfo
	 */
	@Override
	public void applySpikeProduct(SpikeProductInfo spikeProductInfo) {
		String startTime = spikeProductInfo.getStartTimeString();
		String endTime = spikeProductInfo.getEndTimeString();

		spikeProductInfo.setStartTime(DateUtils.parseDate(startTime, DateUtils.DEFAULT_DATE_FORMAT_FULL));
		spikeProductInfo.setEndTime(DateUtils.parseDate(endTime, DateUtils.DEFAULT_DATE_FORMAT_FULL));

		spikeProductInfo.setApplyDate(new Date());
		spikeProductInfo.setAuditState(0);
		spikeProductDao.applySpikeProduct(spikeProductInfo);
	}

	/**
	 * 秒杀商品列表
	 * 
	 * @param msproductinfo
	 */
	@Override
	public List<SpikeProductInfo> listSpikeProduct(SpikeProductVO spikeProductVO) {
		return spikeProductDao.listByVO(spikeProductVO);
	}

	/**
	 * 根据秒杀商品id查询秒杀商品
	 * 
	 * @param msproductinfo
	 */
	@Override
	public SpikeProductInfo querySpikeProductById(String id) {
		return spikeProductDao.getById(id);
	}

	@Override
	public void deleteSpikeProductById(String id) {
		spikeProductDao.delete(id);
	}

	@Override
	public void updateSpikeProduct(SpikeProductInfo spikeProductInfo) {
		String startTime = spikeProductInfo.getStartTimeString();
		String endTime = spikeProductInfo.getEndTimeString();
		spikeProductInfo.setStartTime(DateUtils.parseDate(startTime, DateUtils.DEFAULT_DATE_FORMAT_FULL));
		spikeProductInfo.setEndTime(DateUtils.parseDate(endTime, DateUtils.DEFAULT_DATE_FORMAT_FULL));

		spikeProductDao.update(spikeProductInfo);
	}

	/**
	 * 更新状态
	 * 
	 * @param id
	 * @param state
	 */
	@Override
	public void updateSpikeProductState(String id, int state) {
		SpikeProductVO msProductVo = new SpikeProductVO();
		ConstomSpikeProduct constomProduct = new ConstomSpikeProduct();
		constomProduct.setId(id);
		constomProduct.setAuditState(state);
		msProductVo.setConstomProduct(constomProduct);
		
		spikeProductDao.updateSpikeProductState(msProductVo);
	}
}
