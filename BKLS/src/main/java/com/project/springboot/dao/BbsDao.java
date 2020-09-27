package com.project.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.springboot.dto.BbsDto;

@Mapper	
public interface BbsDao {
	
	public List<BbsDto> listDao();
	// ±Û ¸ñ·Ï
	public List<BbsDto> notice();
	public BbsDto viewDao(String id);
	public int writeDao(String writer,String title, String content);
	public int deleteDao(String id);
}
