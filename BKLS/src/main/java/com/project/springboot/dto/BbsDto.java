package com.project.springboot.dto;

import lombok.Data;

@Data
public class BbsDto {
	private int id;
	private String writer;
	private String title;
	private String content;
}
