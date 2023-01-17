package com.shop2.myapp.service;

import java.util.List;

import com.shop2.myapp.dto.QnaDTO;


public interface QnaService {
	public List<QnaDTO> qnaList() throws Exception;
	public QnaDTO getQna(int qno) throws Exception;
	public void addQna(QnaDTO qna) throws Exception;
	public void addReply(QnaDTO qna) throws Exception;
	public void qnaDelete(int qno) throws Exception;
	public void qnaEdit(QnaDTO dto) throws Exception;
}
