package com.shop2.myapp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop2.myapp.dto.MemberDTO;

@Mapper
public interface AjaxMapper {
	public List<MemberDTO> memberList() throws Exception;
	public MemberDTO getUser(String userId) throws Exception;
	public MemberDTO getLogin(String userId, String userPw) throws Exception;
}
