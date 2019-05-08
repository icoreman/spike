package com.xuxx.spike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuxx.spike.dao.IMerchantDao;
import com.xuxx.spike.entity.Merchant;
import com.xuxx.spike.service.IMerchantService;
import com.xuxx.spike.vo.merchant.MerchantVO;

@Service
@org.apache.dubbo.config.annotation.Service(interfaceClass = IMerchantService.class)
public class IMerchantServiceImpl implements IMerchantService{

	@Autowired
	private IMerchantDao merchantDao;
	
	@Override
	public void insertMerchant(Merchant merchant) {
		merchantDao.add(merchant);
	}

	@Override
	public Merchant queryMerchantById(String id) {
		return merchantDao.getById(id);
	}

	@Override
	public void updateMerchant(Merchant merchant) {
		merchantDao.update(merchant);
	}

	@Override
	public void deleteMerchantById(String id) {
		merchantDao.delete(id);
	}

	@Override
	public List<Merchant> queryMerchantByVO(MerchantVO merchantVo) {
		return merchantDao.listByVO(merchantVo);
	}

	@Override
	public Merchant queryMerchantByaccount(String account) {
		return merchantDao.getByAccount(account);
	}

}
