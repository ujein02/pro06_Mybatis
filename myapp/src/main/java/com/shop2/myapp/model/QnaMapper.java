package com.shop2.myapp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop2.myapp.dto.MemberDTO;
import com.shop2.myapp.dto.QnaDTO;

@Mapper
public interface QnaMapper {
	public List<QnaDTO> qnaList() throws Exception;
	public QnaDTO getQna(int qno) throws Exception;
	public void addQna(QnaDTO qna) throws Exception;
	public void addReply(QnaDTO qna) throws Exception;
	public void qnaDelete(int qno) throws Exception;
	public void qnaEdit(QnaDTO dto) throws Exception;

}
