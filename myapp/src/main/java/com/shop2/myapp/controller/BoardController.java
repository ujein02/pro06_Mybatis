package com.shop2.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop2.myapp.dto.BoardDTO;
import com.shop2.myapp.service.BoardService;

@Controller
@RequestMapping(value = "/board/")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("list")	//localhost:8095/board/list
    public String getBoardList(Model model) {
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }
	@GetMapping("detail")
    public String getBoardDetail(@RequestParam int bno, Model model) {
    	BoardDTO board = boardService.getBoard(bno);
    	model.addAttribute("board", board);
    	return "board/detail";
    }
    
    @GetMapping("add")
    public String addBoardForm(Model model, BoardDTO board) {
    	model.addAttribute("board", board);
    	return "board/add";
    }
    
    @PostMapping("add")
    public String addBoard(@ModelAttribute("board") BoardDTO board) {
    	board.setWriter("관리자");
    	boardService.addBoard(board);
    	return "redirect:/board/list";
    }

    @GetMapping("update")
    public String updateBoardForm(@RequestParam int bno, Model model) {
    	BoardDTO board = boardService.getBoard(bno);
    	model.addAttribute("board", board);
    	return "board/update";
    }
    
    @PostMapping("update")
    public String updateBoard(@ModelAttribute("board") BoardDTO board, Model model) {
    	board.setWriter("관리자");
    	boardService.updateBoard(board);
    	return "redirect:/board/list";
    }
    
    @GetMapping("del")
    public String delBoard(@RequestParam int bno, Model model) {
    	boardService.delBoard(bno);
    	return "redirect:/board/list";
    }


}
