package com.shop2.myapp.service;

import java.util.List;

import com.shop2.myapp.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> findAll();
	public BoardDTO getBoard(int bno);
	public void addBoard(BoardDTO board);
	public void updateBoard(BoardDTO board);
	public void delBoard(int bno);

}
