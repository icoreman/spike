package com.xuxx.spike.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuxx.spike.entity.User;
import com.xuxx.spike.service.IUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 前端用户
 * 
 * @ClassName: FrontUserController
 * @author xuxx
 * @date 2019-05-08 21:10:06
 * @since JDK 1.8
 *
 */
@Slf4j
@Controller
@RequestMapping("frontUser")
public class FrontUserController {
	@Autowired
	IUserService userService;

	@RequestMapping(value = "toregister")
	public String toregiter() {
		return "user/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String regiter(HttpServletRequest req, User user) {
		log.info("user register:{}", user);
		
		userService.insertUser(user);
		HttpSession session = req.getSession();
		session.setAttribute("user", user);

		return "home/index";
	}

	@RequestMapping(value = "tologin")
	public String tologin(HttpServletRequest req, User user) {

		return "user/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, User user) {
		log.info("login:{}", user);

		String returnUrl = "home/error";
		String account = user.getUserAccount();
		String password = user.getUserPassword();
		User userResult = userService.queryUserByUserAccount(account);
		if (userResult == null) {
			req.setAttribute("errorInfo", "无此用户");
		} else if (!userResult.getUserPassword().equals(password)) {
			req.setAttribute("errorInfo", "密码错误");
		} else {
			HttpSession sess = req.getSession();
			sess.setAttribute("user", userResult);
			returnUrl = "home/index";
		}
		return returnUrl;
	}

	@RequestMapping(value = "logout")
	public String exit(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		
		return "home/index";
	}
}
