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
	 *  ����Ƚ�� update
	 */
	public void failCntUpdate(String id);
	/*
	 *  ����Ƚ��, isEnabled ��ȸ.
	 */
	public Account getFailCnt(String id);
	
	/* 
	 * ���� Ȱ��ȭ ���κ���, 1�̾����� 0���� 0�̾����� 1�� �ٲ۴�.
	 * 0�� false, 1�� true�̴�.
	*/
	public void changeEnabled(String id);
	
	/*
	 * ����Ƚ�� �ʱ�ȭ
	 */
	public void resetFailCnt(String id);
}