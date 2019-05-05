package com.xuxx.spike.service;

import java.util.List;

import com.xuxx.spike.entity.Merchant;

/**
 * 
 * @ClassName: MerchantService
 *
 * @author xuxx
 * @date 2019-05-05 21:27:33
 * @since  JDK 1.8
 *
 */
public interface MerchantService {
	public void insertMerchant(Merchant merchant);
	public Merchant queryMerchantById(int id);
	public void updateMerchant(Merchant merchant);
	public void deleteMerchantById(int id);
	public List<Merchant> queryMerchantByVO();
	public Merchant queryMerchantByaccount(String account);
}
