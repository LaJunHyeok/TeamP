package de;

import lombok.Data;

@Data
public class BbsPage {
	private int totalCount;
	private int listCount;
	private int totalPage;
	private int curPage;
	private int pageCount;
	private int startPage;
	private int endPage;
}
