package com.xuxx.spike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admmin")
public class AdminController {
	@RequestMapping("index")
	public String tohome(){
		return "admin/index";
	}
}
