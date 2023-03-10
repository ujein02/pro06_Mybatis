package com.shop2.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.shop2.myapp.dto.MemberDTO;

@Controller
public class IndexController {
	
	@RequestMapping(value="/")
	public String Index(@SessionAttribute(name = "loginUser", required = false) MemberDTO loginUser, Model model) {
		String userId = "";
		if(loginUser != null) {
			userId = loginUser.getUserId();
		}
		model.addAttribute("sid", userId);
		model.addAttribute("loginUser", loginUser);
		return "/index";
	}

}
