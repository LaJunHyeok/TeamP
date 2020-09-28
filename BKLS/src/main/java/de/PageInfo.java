package de;

import com.project.springboot.dto.BbsPage;

public class PageInfo {
	public String pInfo(int curPage) {
	BbsDao dao = null;
	int nPage=1;
	
	int listCount =5;
	int pageCount =5;
	int totalCount = 0;
	BbsPage totalcount = dao.articlePage(nPage);
	System.out.println(nPage);
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
	if(endPage > totalPage)
		endPage = totalPage;
	return
}
}
