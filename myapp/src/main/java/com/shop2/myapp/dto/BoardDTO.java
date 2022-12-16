package com.shop2.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	private int bno;
	private String title;
	private String content;
    private String writer;
    private String regdate;
    private int visited;
}
