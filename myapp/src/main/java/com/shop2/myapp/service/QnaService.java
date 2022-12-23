package com.shop2.myapp.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop2.myapp.dto.QnaDTO;

@Mapper
public interface QnaService {
	public List<QnaDTO> qnaList() throws Exception;
	public QnaDTO getQna(String qno) throws Exception;
}