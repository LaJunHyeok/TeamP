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
	
	
	
	
}
