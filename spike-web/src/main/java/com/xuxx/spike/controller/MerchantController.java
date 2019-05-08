package com.xuxx.spike.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuxx.spike.entity.Merchant;
import com.xuxx.spike.service.IMerchantService;
import com.xuxx.spike.vo.merchant.MerchantVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/merchant")
public class MerchantController {
	@Autowired
	private IMerchantService merchantService;

	@RequestMapping("toadd")
	public String addPage() {
		return "merchant/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Merchant merchant) {
		merchantService.insertMerchant(merchant);
		log.info("add merchant:{}", merchant);
		return "redirect:queryByVO";
	}

	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request, String id) {
		Merchant Merchant = merchantService.queryMerchantById(id);
		request.setAttribute("merchant", Merchant);
		return "merchant/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Merchant merchant) {
		merchantService.updateMerchant(merchant);
		return "redirect:queryByVO";
	}

	@RequestMapping("delete")
	public String del(HttpServletRequest request, String id) {
		merchantService.deleteMerchantById(id);
		return "redirect:queryByVO";
	}

	@RequestMapping("queryById")
	public String querybyid(HttpServletRequest request, String id) {
		Merchant merchant = merchantService.queryMerchantById(id);
		request.setAttribute("merchant", merchant);
		return "merchant/view";
	}

	@RequestMapping("queryByVO")
	public String queryByVO(HttpServletRequest request, MerchantVO merchantVo) {
		List<Merchant> list = merchantService.queryMerchantByVO(merchantVo);
		request.setAttribute("merchantList", list);
		return "merchant/list";
	}
}
