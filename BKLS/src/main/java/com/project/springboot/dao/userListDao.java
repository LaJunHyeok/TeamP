package com.project.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.springboot.dto.BbsDto;
import com.project.springboot.dto.BbsPage;
import com.project.springboot.dto.userListDto;

@Mapper   
public interface userListDao {
   public List<userListDto> userList(int curPage);
   public int userBan(String id);
   public int userRestore(String id);
   public BbsPage userArticlePage();
   public List<userListDto> user_search(String id,int curPage);
   public BbsPage userSearchPage(String id);
}