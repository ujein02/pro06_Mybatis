package com.shop2.myapp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop2.myapp.dto.MemberDTO;

@Mapper
@Repository
public interface MemberMapper {
	// 로그인
    MemberDTO getUserAccount(String userId);

    // 회원가입
    void saveUser(MemberDTO memberDTO);
    
    // 회원정보 수정
    void updateUser(MemberDTO memberDTO);

}
