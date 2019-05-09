package com.xuxx.spike.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuxx.spike.entity.Product;
import com.xuxx.spike.entity.SpikeProductInfo;
import com.xuxx.spike.entity.User;
import com.xuxx.spike.service.IProductService;
import com.xuxx.spike.service.ISpikeProductService;
import com.xuxx.spike.vo.spike.ConstomSpikeProduct;
import com.xuxx.spike.vo.spike.SpikeProductVO;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ISpikeProductService spikeProductService;
	
	@RequestMapping("index")
	public String tohome(HttpServletRequest request) {
		SpikeProductVO spikeProductVO = new SpikeProductVO();
		ConstomSpikeProduct constomProduct = new ConstomSpikeProduct();
		constomProduct.setStartTime(new Date());
		constomProduct.setAuditState(1);
		spikeProductVO.setConstomProduct(constomProduct);
		
		List<SpikeProductInfo> list = spikeProductService.listSpikeProduct(spikeProductVO);
		
		request.setAttribute("list", list);

		return "home/index";
	}

	@RequestMapping("viewProductDetail")
	public String viewProductDetail(HttpServletRequest req,String id){
		SpikeProductInfo spikeProductInfo = spikeProductService.querySpikeProductById(id);
		Product product = productService.getById(spikeProductInfo.getProductId());
		
		req.setAttribute("product", product);
		req.setAttribute("spikeProductInfo", spikeProductInfo);
		return "order/order";
	}
	
	
	@RequestMapping("getUser")
	@ResponseBody
	public String getuser(HttpServletRequest req) {
		HttpSession sess = req.getSession();
		User user = (User) sess.getAttribute("user");
		String account = "";
		if (user != null) {
			account = user.getUserAccount();
		}
		
		return account;
	}
}
