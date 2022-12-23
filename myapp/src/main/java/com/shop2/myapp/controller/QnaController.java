package com.shop2.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop2.myapp.dto.QnaDTO;
import com.shop2.myapp.service.QnaService;

@Controller
@RequestMapping(value = "/qna/")
public class QnaController {
	
	@Autowired
	QnaService qnaService;
	
	@GetMapping("list")
	public String getQnaList(Model model) throws Exception {
		List<QnaDTO> qnaList = qnaService.qnaList();
		model.addAttribute("qnaList", qnaList);
		return "qna/list";
	}

}
