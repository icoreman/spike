package com.xuxx.spike.service;

import java.util.List;

import com.xuxx.spike.entity.Merchant;
import com.xuxx.spike.vo.merchant.MerchantVO;

/**
 * 
 * @ClassName: MerchantService
 *
 * @author xuxx
 * @date 2019-05-05 21:27:33
 * @since  JDK 1.8
 *
 */
public interface IMerchantService {
	public void insertMerchant(Merchant merchant);
	public Merchant queryMerchantById(String id);
	public void updateMerchant(Merchant merchant);
	public void deleteMerchantById(String id);
	public List<Merchant> queryMerchantByVO(MerchantVO merchantVo);
	public Merchant queryMerchantByaccount(String account);
}
