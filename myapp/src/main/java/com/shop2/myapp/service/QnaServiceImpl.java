package com.shop2.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop2.myapp.dto.QnaDTO;
import com.shop2.myapp.model.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	QnaMapper qnaMapper;

	@Override
	public List<QnaDTO> qnaList() throws Exception {
		return qnaMapper.qnaList();
	}

	@Override
	public QnaDTO getQna(String qno) throws Exception {
		return qnaMapper.getQna(qno);
	}
	
	

}
