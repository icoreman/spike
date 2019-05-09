package com.xuxx.spike.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuxx.spike.entity.Merchant;
import com.xuxx.spike.entity.Product;
import com.xuxx.spike.entity.SpikeProductInfo;
import com.xuxx.spike.service.IProductService;
import com.xuxx.spike.service.ISpikeProductService;
import com.xuxx.spike.util.DateUtils;
import com.xuxx.spike.vo.spike.SpikeProductVO;

@Controller
@RequestMapping("spikeProduct")
public class SpikeProductController {

	@Autowired
	private ISpikeProductService spikeProductService;

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "toApply")
	public String toApplymsproduct(HttpServletRequest request, String productId) {
		Product product = productService.getById(productId);
		SpikeProductInfo spikeProductInfo = new SpikeProductInfo();
		spikeProductInfo.setProductId(product.getId());
		spikeProductInfo.setMerchantId(product.getMerchantId());
		spikeProductInfo.setProductTitle(product.getBrandName() + "-" + product.getProductName());
		spikeProductInfo.setProductPicture(product.getProductPicture());
		
		request.setAttribute("spikeProductInfo", spikeProductInfo);
		return "spikeProduct/apply";
	}

	@RequestMapping(value = "apply", method = RequestMethod.POST)
	public String apply(HttpServletRequest request, SpikeProductInfo spikeProductInfo) {
		spikeProductService.applySpikeProduct(spikeProductInfo);
		return "redirect:list";
	}

	@RequestMapping(value = "list")
	public String list(HttpServletRequest req, SpikeProductVO spikeProductVO) {
		List<SpikeProductInfo> list = spikeProductService.listSpikeProduct(spikeProductVO);
		req.setAttribute("list", list);
		return "spikeProduct/list";
	}

	@RequestMapping(value = "queryById")
	public String queryById(HttpServletRequest req, String id) {
		SpikeProductInfo spikeProductInfo = spikeProductService.querySpikeProductById(id);
		req.setAttribute("spikeProductInfo", spikeProductInfo);
		return "spikeProduct/view";
	}

	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest req, String id) {
		spikeProductService.deleteSpikeProductById(id);
		return "redirect:list";
	}

	@RequestMapping(value = "toupdate")
	public String toUpdate(HttpServletRequest req, String id) {
		SpikeProductInfo spikeProductInfo = spikeProductService.querySpikeProductById(id);
		Date startTime = spikeProductInfo.getStartTime();
		Date endTime = spikeProductInfo.getEndTime();
		String startTimeString = "";
		String endTimeString = "";

		if (startTime != null) {
			startTimeString = DateUtils.formatDate(startTime, DateUtils.DEFAULT_DATE_FORMAT_FULL);
		}
		if (endTime != null) {
			endTimeString = DateUtils.formatDate(endTime, DateUtils.DEFAULT_DATE_FORMAT_FULL);
		}

		req.setAttribute("spikeProductInfo", spikeProductInfo);
		req.setAttribute("startTimeString", startTimeString);
		req.setAttribute("endTimeString", endTimeString);
		return "spikeProduct/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest req, SpikeProductInfo spikeProductInfo) {
		spikeProductService.updateSpikeProduct(spikeProductInfo);
		return "redirect:list";
	}

	@RequestMapping(value = "toaudit")
	public String toupdatemsproductstate(HttpServletRequest req, String id) {
		SpikeProductInfo spikeProductInfo = spikeProductService.querySpikeProductById(id);
		Date startTime = spikeProductInfo.getStartTime();
		Date endTime = spikeProductInfo.getEndTime();
		String startTimeString = "";
		String endTimeString = "";

		if (startTime != null) {
			startTimeString = DateUtils.formatDate(startTime, DateUtils.DEFAULT_DATE_FORMAT_FULL);
		}
		if (endTime != null) {
			endTimeString = DateUtils.formatDate(endTime, DateUtils.DEFAULT_DATE_FORMAT_FULL);
		}

		req.setAttribute("spikeProductInfo", spikeProductInfo);
		req.setAttribute("startTimeString", startTimeString);
		req.setAttribute("endTimeString", endTimeString);
		return "spikeProduct/audit";
	}

	@RequestMapping(value = "audit", method = RequestMethod.POST)
	public String audit(HttpServletRequest req, String id, int state) {
		spikeProductService.updateSpikeProductState(id, state);
		return "redirect:list";
	}

}
