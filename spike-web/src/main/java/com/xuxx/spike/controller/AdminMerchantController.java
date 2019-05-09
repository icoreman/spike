package com.xuxx.spike.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuxx.spike.entity.Merchant;
import com.xuxx.spike.service.IMerchantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("merichantAdmin")
public class AdminMerchantController {

	@Autowired
	IMerchantService merchantService;

	@RequestMapping(value = "toregister")
	public String toregiter() {
		return "merchant/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String regiter(HttpServletRequest req, Merchant merchant) {
		log.info("merchant register:{}", merchant);
		merchantService.insertMerchant(merchant);
		
		HttpSession session = req.getSession();
		session.setAttribute("merchant", merchant);

		return "admin/index";
	}

	@RequestMapping(value = "tologin")
	public String tologin(HttpServletRequest req) {

		return "merchant/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, Merchant merchant) {
		String returnUrl = "admin/error";
		String account = merchant.getMerchantAccount();
		String password = merchant.getMerchantPassword();
		
		Merchant merchantResult = merchantService.queryMerchantByaccount(account);
		if (merchantResult == null) {
			req.setAttribute("errorInfo", "无此商家");
		} else if (!merchantResult.getMerchantPassword().equals(password)) {
			req.setAttribute("errorInfo", "商家密码错误");
		} else {
			HttpSession sess = req.getSession();
			sess.setAttribute("merchant", merchantResult);
			returnUrl = "admin/index";
		}
		return returnUrl;
	}

	@RequestMapping(value = "logout")
	public String exit(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("merchant");

		return "redirect:/admin/index";
	}
}
