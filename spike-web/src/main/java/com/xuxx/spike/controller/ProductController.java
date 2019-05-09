package com.xuxx.spike.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuxx.spike.entity.Merchant;
import com.xuxx.spike.entity.Product;
import com.xuxx.spike.service.IProductService;
import com.xuxx.spike.vo.product.ConstomProduct;
import com.xuxx.spike.vo.product.ProductVO;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value="toadd")
	public String toAdd(HttpServletRequest req){
		return "product/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(HttpServletRequest request, Product product){
		HttpSession session = request.getSession();
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		
		product.setMerchantId(merchant.getId());
		productService.add(product);
		
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
	
	@RequestMapping(value="query")
	public String query(HttpServletRequest req,String id){
		Product product = productService.getById(id);
		req.setAttribute("product", product);
		
		return "product/view";
	}
	
	@RequestMapping(value="list")
	public String list(HttpServletRequest request,ProductVO productVO){
		HttpSession session = request.getSession();
		if(session.getAttribute("merchant") != null) {
			Merchant merchant = (Merchant) session.getAttribute("merchant");
			ConstomProduct product = productVO.getConstomProduct();
			if(product == null) {
				product = new ConstomProduct();
			}
			
			product.setMerchantId(merchant.getId());
			productVO.setConstomProduct(product);
		}
		
		List<Product> list =  productService.listByProductVO(productVO);
		request.setAttribute("list", list);
		
		return "product/list";
	}
	
}
