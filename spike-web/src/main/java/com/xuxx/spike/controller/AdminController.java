package com.xuxx.spike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuxx.spike.service.TestService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("index")
	public String tohome(){
		return "admin/index";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		testService.test();
		return "test";
	}
}
