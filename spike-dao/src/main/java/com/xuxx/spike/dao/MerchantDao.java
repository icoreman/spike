package com.xuxx.spike.dao;

import java.util.List;

import com.xuxx.spike.entity.Merchant;

/**
 * 
 * @ClassName: MerchantDao
 *
 * @author xuxx
 * @date 2019-05-05 21:31:06
 * @since  JDK 1.8
 *
 */
public interface MerchantDao {
	public void insertMerchant(Merchant merchant);
	public Merchant queryMerchantById(int id);
	public void updateMerchant(Merchant merchant);
	public void deleteMerchantById(int id);
	public List<Merchant> queryMerchantByVO();
	public Merchant queryMerchantByAccount(String account);
}
