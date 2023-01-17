package com.shop2.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop2.myapp.dto.MemberDTO;
import com.shop2.myapp.service.MemberService;

@Controller
@RequestMapping(value = "/member/")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	
	@Autowired
	HttpSession session;
	
	//회원 목록 보기
	@GetMapping("list")
	public String memberList(Model model) throws Exception {
		List<MemberDTO> memberList = memberService.memberList();
		model.addAttribute("memberList", memberList);
		return "member/memberList";
	}
	
	//로그인 폼 로딩
	@RequestMapping("loginForm")  
	public String memberLoginForm(Model model) throws Exception {
		return "member/loginForm";
	}
	
	@RequestMapping("info")  
	public String getInfo(Model model) throws Exception {
		return "member/info";
	}
	

}
