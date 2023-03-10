package com.shop2.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop2.myapp.dto.BoardDTO;
import com.shop2.myapp.model.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> findAll() {
        return boardMapper.findAll();
    }

	@Override
	public BoardDTO getBoard(int bno) {
		boardMapper.visitedUpdate(bno);
		return boardMapper.getBoard(bno);
	}

	@Override
	public void addBoard(BoardDTO board) {
		boardMapper.addBoard(board);
	}

	@Override
	public void updateBoard(BoardDTO board) {
		boardMapper.updateBoard(board);
	}

	@Override
	public void delBoard(int bno) {
		boardMapper.delBoard(bno);
	}    
	
}