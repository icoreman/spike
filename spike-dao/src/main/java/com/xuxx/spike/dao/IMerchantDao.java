package com.xuxx.spike.dao;

import java.util.List;

import com.xuxx.spike.entity.Merchant;
import com.xuxx.spike.vo.merchant.MerchantVO;

/**
 * 
 * @ClassName: MerchantDao
 *
 * @author xuxx
 * @date 2019-05-05 21:31:06
 * @since  JDK 1.8
 *
 */
public interface IMerchantDao {
	public void add(Merchant merchant);
	public Merchant getById(String id);
	public void update(Merchant merchant);
	public void delete(String id);
	public List<Merchant> listByVO(MerchantVO merchantVo);
	public Merchant getByAccount(String account);
}
