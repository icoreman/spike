package com.xuxx.spike.service;

import java.util.List;

import com.xuxx.spike.entity.Product;
import com.xuxx.spike.vo.product.ProductVO;


public interface IProductService {
	public void add(Product product);
	public void update(Product product);
	public Product getById(String productId);
	public List<Product> listByProductVO(ProductVO productVO);
}
