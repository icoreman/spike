package com.xuxx.spike.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuxx.spike.entity.Product;
import com.xuxx.spike.service.IProductService;
import com.xuxx.spike.vo.product.ProductVO;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value="toadd")
	public String toAdd(HttpServletRequest req){
		return "productDetail/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(Product productDetail){
		productService.add(productDetail);
		
		return "redirect:/product/list";
	}
	
	
	@RequestMapping(value="toupdate")
	public String toUpdate(HttpServletRequest req,String id){
		Product product = productService.getById(id);
		req.setAttribute("product", product);
		
		return "product/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(HttpServletRequest req,Product product){
		productService.update(product);
		return "redirect:/product/list";
	}
	
	@RequestMapping(value="list")
	public String list(HttpServletRequest req,ProductVO productVO){
		List<Product> list =  productService.listByProductVO(productVO);
		req.setAttribute("list", list);
		
		return "product/list";
	}
	
}
