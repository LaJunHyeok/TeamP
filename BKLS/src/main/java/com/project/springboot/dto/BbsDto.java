package com.project.springboot.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BbsDto {
	private int NOTICE_NUM;
	private String NOTICE_ID;
	private String NOTICE_TITLE;
	private String NOTICE_CONTENT;
	private Date NOTICE_DATE;
	private int NOTICE_HIT;
	
	public int getNOTICE_NUM() {
		return NOTICE_NUM;
	}
	public void setNOTICE_NUM(int nOTICE_NUM) {
		NOTICE_NUM = nOTICE_NUM;
	}
	public String getNOTICE_ID() {
		return NOTICE_ID;
	}
	public void setNOTICE_ID(String nOTICE_ID) {
		NOTICE_ID = nOTICE_ID;
	}
	public String getNOTICE_TITLE() {
		return NOTICE_TITLE;
	}
	public void setNOTICE_TITLE(String nOTICE_TITLE) {
		NOTICE_TITLE = nOTICE_TITLE;
	}
	public String getNOTICE_CONTENT() {
		return NOTICE_CONTENT;
	}
	public void setNOTICE_CONTENT(String nOTICE_CONTENT) {
		NOTICE_CONTENT = nOTICE_CONTENT;
	}
	public Date getNOTICE_DATE() {
		return NOTICE_DATE;
	}
	public void setNOTICE_DATE(Date nOTICE_DATE) {
		NOTICE_DATE = nOTICE_DATE;
	}
	public int getNOTICE_HIT() {
		return NOTICE_HIT;
	}
	public void setNOTICE_HIT(int nOTICE_HIT) {
		NOTICE_HIT = nOTICE_HIT;
	}
	
}
