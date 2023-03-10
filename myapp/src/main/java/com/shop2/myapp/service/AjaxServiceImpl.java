package com.shop2.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop2.myapp.dto.MemberDTO;
import com.shop2.myapp.model.AjaxMapper;

@Service
public class AjaxServiceImpl implements AjaxService {
	
	@Autowired
	AjaxMapper ajaxMapper;

	@Override
	public List<MemberDTO> memberList() throws Exception {
		return ajaxMapper.memberList();
	}

	@Override
	public MemberDTO getUser(String userId) throws Exception {
		return ajaxMapper.getUser(userId);
	}

	@Override
	public MemberDTO getLogin(String userId, String userPw) throws Exception {
		return ajaxMapper.getLogin(userId, userPw);
	}
	
	@Override
	public void signUser(MemberDTO member) throws Exception {
		ajaxMapper.signUser(member);
		
	}
	
	

}
