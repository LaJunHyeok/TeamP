package com.project.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.springboot.dto.BbsDto;
import com.project.springboot.dto.BbsPage;

@Mapper	
public interface BbsDao {
	
	public List<BbsDto> listDao();
	public BbsDto viewDao(String id);
	public int writeDao(String title, String content);
	public int writeDao1(String title1, String content1);
	public int deleteDao(String id);
	
	public List<BbsDto> notice();
	public List<BbsDto> help(int curPage);
	
	public List<BbsDto> noticeview(int num);
	public List<BbsDto> helpview(int num1);
	
	public int noticedelete(int num);
	public int helpdelete(int num1);
	
	public int noticeupdate(int num,String title,String content);
	public int helpupdate(int num1, String title1, String content1);
	
	public String noticemodify(int num);
	public String helpmodify(int num1);
	
	public int noticehit(int num);
	public int helphit(int num1);
	
	public List<BbsDto> noticesearch(String title);
	public List<BbsDto> help_search(String title1);
	
	public BbsPage articlePage();
}
