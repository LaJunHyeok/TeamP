package com.project.springboot.dto;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class BbsDto {
	
	private int notice_num;
	private String notice_id;
	private String notice_title;
	private String notice_content;
	private int	notice_hit;
	private Timestamp notice_date;
	
	private int help_num;
	private String help_id;
	private String help_title;
	private String help_content;
	private Timestamp help_date;
	private int help_group;
	private int help_open;
	private int help_hit;
	private int help_step;
	
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	public String getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public int getNotice_hit() {
		return notice_hit;
	}
	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}
	public Timestamp getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Timestamp notice_date) {
		this.notice_date = notice_date;
	}
	public int getHelp_num() {
		return help_num;
	}
	public void setHelp_num(int help_num) {
		this.help_num = help_num;
	}
	public String getHelp_id() {
		return help_id;
	}
	public void setHelp_id(String help_id) {
		this.help_id = help_id;
	}
	public String getHelp_title() {
		return help_title;
	}
	public void setHelp_title(String help_title) {
		this.help_title = help_title;
	}
	public String getHelp_content() {
		return help_content;
	}
	public void setHelp_content(String help_content) {
		this.help_content = help_content;
	}
	public Timestamp getHelp_date() {
		return help_date;
	}
	public void setHelp_date(Timestamp help_date) {
		this.help_date = help_date;
	}
	public int getHelp_group() {
		return help_group;
	}
	public void setHelp_group(int help_group) {
		this.help_group = help_group;
	}
	public int getHelp_open() {
		return help_open;
	}
	public void setHelp_open(int help_open) {
		this.help_open = help_open;
	}
	public int getHelp_hit() {
		return help_hit;
	}
	public void setHelp_hit(int help_hit) {
		this.help_hit = help_hit;
	}
	public int getHelp_step() {
		return help_step;
	}
	public void setHelp_step(int help_step) {
		this.help_step = help_step;
	}
	
}
