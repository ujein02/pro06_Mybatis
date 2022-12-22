package com.shop2.myapp.dto;


import lombok.Data;

@Data
public class MemberDTO {
	
	private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String email;
	private String regdate;
    
	
}