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
	
	
	
}
