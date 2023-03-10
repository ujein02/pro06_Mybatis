package com.shop2.myapp.service;

import java.util.List;

import com.shop2.myapp.dto.MemberDTO;


public interface AjaxService {
	public List<MemberDTO> memberList() throws Exception;
	public MemberDTO getUser(String userId) throws Exception;
	public MemberDTO getLogin(String userId, String userPw) throws Exception;
	public void signUser(MemberDTO member) throws Exception;

}
