package com.project.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.springboot.dto.BbsDto;
import com.project.springboot.dto.BbsPage;

@Mapper	
public interface BbsDao {
	
	// 공지사항 Mapper
	public int writeDao(String title, String content);
	public List<BbsDto> notice(int curPage);
	public List<BbsDto> noticeview(int num);
	public int noticedelete(int num);
	public int noticeupdate(int num,String title,String content);
	public String noticemodify(int num);
	public int noticehit(int num);
	public List<BbsDto> noticesearch(String title,int curPage);
	public BbsPage articlePage();
	public BbsPage searchPage(String title);
	
	// 민원 건의 Mapper
	public int writeDao1(String id,String title1, String content1,int help_open);
	public int writeDao2(int num1,String title2, String content2,String user);
	public List<BbsDto> help(int curPage);
	public List<BbsDto> helpview(int num1);
	public int helpdelete(int num1);
	public int helpupdate(int num1, String title1, String content1);
	public String helpmodify(int num1);
	public int helphit(int num1);
	public List<BbsDto> help_search(String title1);
	public BbsPage articlePage1();
	
}
