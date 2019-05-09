package com.xuxx.spike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuxx.spike.dao.IProductDao;
import com.xuxx.spike.entity.Product;
import com.xuxx.spike.service.IProductService;
import com.xuxx.spike.vo.product.ProductVO;

@Service
@org.apache.dubbo.config.annotation.Service(interfaceClass = IProductService.class)
public class IProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao productDao;

	@Override
	public void add(Product product) {
		productDao.add(product);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	public Product getById(String productId) {
		return productDao.getById(productId);
	}

	@Override
	public List<Product> listByProductVO(ProductVO productVO) {
		return productDao.listByVO(productVO);
	}
}
