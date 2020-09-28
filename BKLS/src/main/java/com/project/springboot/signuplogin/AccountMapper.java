package com.project.springboot.signuplogin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.springboot.signuplogin.Account;
import com.project.springboot.signuplogin.Authority;

@Mapper
public interface AccountMapper{
	public Account readAccount(String id);
	
	public List<String> readAuthorites(String id);
	
	public void insertUser(Account account);
	
	public void insertUserAuthority(Authority authority);
	
	public List<Account> readAllUsers();
	
	/*
	 *  실패횟수 update
	 */
	public void failCntUpdate(String id);
	/*
	 *  실패횟수, isEnabled 조회.
	 */
	public Account getFailCnt(String id);
	
	/* 
	 * 계정 활성화 여부변경, 1이었으면 0으로 0이었으면 1로 바꾼다.
	 * 0은 false, 1은 true이다.
	*/
	public void changeEnabled(String id);
	
	/*
	 * 실패횟수 초기화
	 */
	public void resetFailCnt(String id);
}