package com.project.springboot.dto;

import java.sql.Timestamp;



import lombok.Data;
@Data
public class userListDto {
   private String id;
   private String pw;
   private String name;
   private String email;
   private String address;
   private String date;
   private String isEnabled;
}
