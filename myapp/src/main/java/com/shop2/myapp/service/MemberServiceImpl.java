package com.shop2.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop2.myapp.dto.MemberDTO;
import com.shop2.myapp.model.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<MemberDTO> memberList() throws Exception {
		return memberMapper.memberList();
	}

	@Override
	public MemberDTO getUser(String userId) throws Exception {
		return memberMapper.getUser(userId);
	}

	@Override
	public MemberDTO getLogin(String userId, String userPw) throws Exception {
		return memberMapper.getLogin(userId, userPw);
	}

	@Override
	public void signUser(MemberDTO member) throws Exception {
		memberMapper.signUser(member);
		
	}
	
	

}
