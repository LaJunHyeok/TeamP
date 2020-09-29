package com.project.springboot.dto;

import lombok.Data;

@Data
public class BpageInfo {
	private int listCount;
	private int totalPage;
	private int curPage;
	private int pageCount;
	private int startPage;
	private int endPage;
	private int totalCount;
}
