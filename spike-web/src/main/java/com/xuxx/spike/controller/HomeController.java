package com.xuxx.spike.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuxx.spike.entity.User;

@Controller
@RequestMapping("home")
public class HomeController {

	@RequestMapping("index")
	public String tohome(HttpServletRequest req) {
		req.setAttribute("list", new ArrayList<>());

		return "home/index";
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
