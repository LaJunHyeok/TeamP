package com.project.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.springboot.dto.BbsDto;

@Mapper	
public interface BbsDao {
	
	public List<BbsDto> listDao();
	public BbsDto viewDao(String id);
	public int writeDao(String title, String content);
	public int deleteDao(String id);
	public List<BbsDto> notice();
	public List<BbsDto> noticeview(int num);
	public int noticedelete(int num);
	public int noticeupdate(int num,String title,String content);
	public String noticemodify(int num);
	
}
