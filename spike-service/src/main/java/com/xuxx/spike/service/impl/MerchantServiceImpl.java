package com.xuxx.spike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuxx.spike.dao.MerchantDao;
import com.xuxx.spike.entity.Merchant;
import com.xuxx.spike.service.MerchantService;

@Service
@org.apache.dubbo.config.annotation.Service(interfaceClass = MerchantService.class)
public class MerchantServiceImpl implements MerchantService{

	@Autowired
	private MerchantDao merchantDao;
	
	@Override
	public void insertMerchant(Merchant merchant) {
		merchantDao.insertMerchant(merchant);
	}

	@Override
	public Merchant queryMerchantById(int id) {
		return merchantDao.queryMerchantById(id);
	}

	@Override
	public void updateMerchant(Merchant merchant) {
		merchantDao.updateMerchant(merchant);
	}

	@Override
	public void deleteMerchantById(int id) {
		merchantDao.deleteMerchantById(id);
	}

	@Override
	public List<Merchant> queryMerchantByVO() {
		return merchantDao.queryMerchantByVO();
	}

	@Override
	public Merchant queryMerchantByaccount(String account) {
		return merchantDao.queryMerchantByAccount(account);
	}

}
