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
	        return "public/mainPage";
	    }
	   @RequestMapping("/mainPage")
	    public String userlistPage(Model model) {
	        model.addAttribute("list", dao.listDao());
	        return "public/mainPage";
	    }
	    
	    @RequestMapping("/loginForm")
		public String loginForm() {
			return "security/loginForm";
		}
		
	    @RequestMapping("/writeForm")
	    public String writeForm(){
	        return "private/writeForm";
	    }
	    
	    @RequestMapping("/CreateID")
	    public String CreateID() {
	    	return "security/CreateID";
	    }
}