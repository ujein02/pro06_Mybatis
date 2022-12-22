package com.shop2.myapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop2.myapp.dto.MemberDTO;
import com.shop2.myapp.service.AjaxService;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
	
	@Resource
	private AjaxService ajaxService;
	
	@Resource
	private HttpSession session;
	
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
	
	@GetMapping("getLogin.do")
	@ResponseBody
	public MemberDTO getLogin(@RequestParam("userId") String userId,@RequestParam("userPw") String userPw, Model model) throws Exception{
		MemberDTO user = ajaxService.getLogin(userId, userPw);
		if(user==null) {
			session.invalidate();
		} else {
			session.setAttribute("sid", user.getUserId());
			session.setAttribute("sname", user.getUserName());
		}
		return user;
		
	}
	
}