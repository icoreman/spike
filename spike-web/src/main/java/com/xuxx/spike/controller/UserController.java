package com.xuxx.spike.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuxx.spike.entity.User;
import com.xuxx.spike.service.IUserService;
import com.xuxx.spike.vo.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	IUserService userService;

	@RequestMapping("toadd")
	public String toadd() {
		return "user/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(User user) {
		userService.insertUser(user);
		log.info("add user:{}", user);
		return "redirect:queryByVO";
	}

	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request, String id) {
		User user = userService.queryUserById(id);
		request.setAttribute("user", user);
		return "user/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, User user) {
		userService.updateUser(user);
		log.info("upate user:{}", user);
		return "redirect:queryByVO";
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request, String id) {
		userService.deleteUserById(id);
		return "redirect:queryByVO";
	}

	@RequestMapping("queryById")
	public String queryById(HttpServletRequest request, String id) {
		User user = userService.queryUserById(id);
		request.setAttribute("user", user);
		return "user/view";
	}

	@RequestMapping("queryByVO")
	public String queryByVO(HttpServletRequest request, UserVO userVO) {
		List<User> list = userService.queryUserByVO(userVO);
		request.setAttribute("userList", list);
		return "user/list";
	}

}
