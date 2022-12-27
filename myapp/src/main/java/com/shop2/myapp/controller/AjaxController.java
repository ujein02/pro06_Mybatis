package com.shop2.myapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop2.myapp.dto.MemberDTO;
import com.shop2.myapp.service.AjaxService;
import com.shop2.myapp.util.AES256;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
	
	@Resource
	private AjaxService ajaxService;
	
	@GetMapping("test1")
	public String testLoad(Model model) throws Exception {
		return "ajax/test1";
	}
	
	@ResponseBody
	@GetMapping("idCheck.do")
	public boolean idCheck(@RequestParam("userId") String userId) throws Exception {
		MemberDTO member = ajaxService.getUser(userId);
		if(member==null) {
			return true;
		} else {
			return false;
		}
	}
	@GetMapping("test2")
	public String testLoad2(Model model) throws Exception {
		return "ajax/test2";
	}
	
	@GetMapping("userList.do")
	@ResponseBody
	public List<MemberDTO> userList(Model model) throws Exception{
		List<MemberDTO> userList = ajaxService.memberList();
		return userList;
	}
	
	@GetMapping("test3")
	public String testLoad3(Model model) throws Exception {
		return "ajax/test3";
	}
	
	@GetMapping("getUser.do")
	@ResponseBody
	public MemberDTO getUser(@RequestParam("userId") String userId, Model model) throws Exception{
		MemberDTO member = ajaxService.getUser(userId);
		return member;
	}
	
	@GetMapping("test4")
	public String testLoad4(Model model) throws Exception {
		return "member/login";
	}
	
//	@PostMapping("getLogin.do")
//	@ResponseBody
//	public HttpSession getLogin(@ModelAttribute("user") MemberDTO user, Model model) throws Exception{
//		MemberDTO member = ajaxService.getLogin(user.getUserId(), user.getUserPw());
//		if(member==null) {
//			session.invalidate();
//		} else {
//			session.setAttribute("sid", member.getUserId());
//			session.setAttribute("sname", member.getUserName());
//		}
//		return session;
//		
//	}
	
	//로그인
	@GetMapping("getLogin.do")
	@ResponseBody
	public MemberDTO getLogin(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, Model model, HttpServletRequest request) throws Exception{
		AES256 aes256 = new AES256();
		userPw = aes256.encrypt(userPw);
		HttpSession session = request.getSession();
		MemberDTO user = ajaxService.getLogin(userId, userPw);
		if(user==null) {
			session.invalidate();
		} else {
			session.setAttribute("loginUser", user);
			session.setAttribute("sid", user.getUserId());
			session.setAttribute("sname", user.getUserName());
		}
		return user;
		
	}
	
	//회원가입
	@GetMapping("test5")
	public String testLoad5(@ModelAttribute("member") MemberDTO member, Model model) throws Exception {
		return "member/join";
	}
	
	@PostMapping("signUser.do")
	public String signUser(@ModelAttribute("member") MemberDTO member, Model model) throws Exception{
		AES256 aes256 = new AES256();
		member.setUserPw(aes256.encrypt(member.getUserPw()));
		ajaxService.signUser(member);
		return "/";
	}
	
	@GetMapping("test6")
	public String testLoad6(@ModelAttribute("member") MemberDTO member, Model model) throws Exception {
		return "member/agree";
	}
}
