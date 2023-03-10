package com.shop2.myapp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop2.myapp.dto.BoardDTO;

@Mapper
@Repository
public interface BoardMapper {
	List<BoardDTO> findAll();
	BoardDTO getBoard(int bno);
	void visitedUpdate(int bno);
	void addBoard(BoardDTO board);
	void updateBoard(BoardDTO board);
	void delBoard(int bno);
}

