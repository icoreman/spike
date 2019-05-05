package com.xuxx.spike.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuxx.spike.entity.Merchant;
import com.xuxx.spike.service.MerchantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/merchant")
public class MerchantController {
	@Reference
	private MerchantService merchantService;

	@RequestMapping("addPage")
	public String addPage() {
		return "merchant/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Merchant merchant) {
		merchantService.insertMerchant(merchant);
		log.debug("add merchant:{}", merchant);
		return "redirect:querybyvo";
	}

	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request, int id) {
		Merchant Merchant = merchantService.queryMerchantById(id);
		request.setAttribute("merchant", Merchant);
		return "merchant/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Merchant merchant) {
		merchantService.updateMerchant(merchant);
		return "redirect:querybyvo";
	}

	@RequestMapping("delete")
	public String del(HttpServletRequest request, int id) {
		merchantService.deleteMerchantById(id);
		return "redirect:querybyvo";
	}

	@RequestMapping("queryById")
	public String querybyid(HttpServletRequest request, int id) {
		Merchant merchant = merchantService.queryMerchantById(id);
		request.setAttribute("merchant", merchant);
		return "merchant/view";
	}

	@RequestMapping("queryByVO")
	public String queryByVO(HttpServletRequest request) {
		List<Merchant> list = merchantService.queryMerchantByVO();
		request.setAttribute("merchantlist", list);
		return "merchant/list";
	}
}
