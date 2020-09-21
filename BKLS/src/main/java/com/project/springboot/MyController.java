package com.project.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.springboot.dao.BbsDao;

@Controller
public class MyController
{
	   @Autowired
	   BbsDao dao;
	   //MemberDao Mdao;
	    
	    @RequestMapping("/")
	    public @ResponseBody String root() throws Exception{
	    	//MyBatis : SimpleBBS
	        return "처음";
	    }
	   @RequestMapping("/mainPage")
	    public String userlistPage(Model model) {
	        model.addAttribute("list", dao.listDao());
	        return "public/mainPage";
	    }
	    // 로그인 폼 관련 페이징 시작
	    @RequestMapping("/loginForm")
		public String loginForm() {
			return "security/loginForm";
		}

		// 로그인 폼 페이징 끝
		
	    @RequestMapping("/writeForm")
	    public String writeForm(){
	        return "private/writeForm";
	    }
}