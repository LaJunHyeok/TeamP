package com.project.springboot.dto;

import lombok.Data;

@Data
public class userListDto {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_email;
	private String user_address;
	private String user_date;
	private String isEnabled;
}
