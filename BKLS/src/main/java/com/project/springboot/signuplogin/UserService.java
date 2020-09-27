package com.project.springboot.signuplogin;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.project.springboot.dto.UserInfoDto;


@Mapper
public interface UserService {
	public int login(String email);
	public int join(Map<String,String> map);
}