package com.project.springboot.dao;

import com.project.springboot.dto.BbsPage;
import com.project.springboot.dto.BpageInfo;

public class PageInfo {
	public BpageInfo pInfo(int totalCount,int curPage) {
		BbsDao dao = null;
		int nPage=1;
		
		System.out.println(totalCount);

		int listCount =10;
		int pageCount =5;
		
		int totalPage= totalCount/listCount;
		if(totalCount % listCount > 0)
			totalPage++;
		int myCurPage = curPage;
		if(myCurPage > totalPage)
			myCurPage = totalPage;
		if(myCurPage < 1)
			myCurPage = 1;
		int startPage = 1; 
		if(myCurPage >= pageCount) {
			startPage = myCurPage - 2;
		}
		else {
			startPage = (myCurPage/(pageCount-1))+1;
		}

		int endPage = startPage + pageCount - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		BpageInfo pinfo = new BpageInfo();
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setTotalCount(totalCount);
		pinfo.setCurPage(totalCount);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);

		return pinfo;

	}

	

}
