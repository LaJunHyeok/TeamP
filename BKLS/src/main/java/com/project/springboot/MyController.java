package com.project.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.springboot.dao.BbsDao;
import com.project.springboot.dto.BbsDto;

@Controller
public class MyController
{
	   @Autowired
	   BbsDao dao;
	   //MemberDao Mdao;
	   
	   //占쏙옙占쏙옙 占쏙옙占쏙옙징
	    @RequestMapping("/")
	    public String root() throws Exception{	    	
	    	//MyBatis : SimpleBBS
	        return "public/mainPage";
	    }
	    //--------占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 ------------
	    //占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙트 占쏙옙占쏙옙占쏙옙
	    @RequestMapping("/notice")
	    public String notice(Model model){
	    	
	    	List<BbsDto> notice = dao.notice();
	    	
	    	model.addAttribute("notice", dao.notice());
	    	return "public/notice";
	    }
	    //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌜쇽옙 占쏙옙占쏙옙占쏙옙 
	    @RequestMapping("/admin/writeForm")
	    public String adminWriteForm() {

	    	return "admin/writeFormAdmin";
	    }
	  //占쏙옙占쏙옙占쏙옙占쏙옙 占쏢세븝옙占쏙옙 占쏙옙占쏙옙占쏙옙 (占쏙옙占쏙옙占쏙옙占쏙옙)######################
	    @RequestMapping("/public/confirmboard")
	    public String confirmBoard() {

	    	return "public/confirmboard";
	    }
	  //---------占쌍븝옙 占쏙옙占쏙옙占� 占싫놂옙--------------
	    @RequestMapping("/navi")
	    public String navi(){
	        return "public/navigator";
	    }
	  
	   
	   //--------占쏙옙占쏙옙,占싸울옙 占쏙옙占쏙옙占쏙옙 ----------- 
	    //占쏙옙占쏙옙.占싸울옙 占쏙옙 占쌜쇽옙 占쏙옙占쏙옙占쏙옙
	   @RequestMapping("/writeForm")
	    public String writeForm(){
	        return "private/writeForm";
	    }
	  
	  //占싸울옙,占쏙옙占쏙옙 占쏙옙占쏙옙트 占쏙옙占쏙옙占쏙옙 
	   @RequestMapping("/help")
	    public String help(){
	        return "public/help";
	    }
	 //占싸울옙,占쏙옙占쏙옙 占쏢세븝옙占쏙옙 占쏙옙占쏙옙占쏙옙 #####################
	   @RequestMapping("/confirmHelp")
	    public String confirmHelp(){
	        return "private/confirmHelp";
	    }
	   
	   //------占시곤옙화 占쌘뤄옙 占쏙옙占쏙옙占쏙옙 --------------
	 //占시곤옙화 占쌘뤄옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 (占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙)##################
	   @RequestMapping("/dataView")
	    public String dataView(){
	        return "public/dataView";
	    }  
	   
	  //-------占싸깍옙占쏙옙,회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙징 ------------
	   // 占싸깍옙占쏙옙 占쏙옙占쏙옙징
	    @RequestMapping("/loginForm")
		public String loginForm() {
			return "security/loginForm";
	    }
	 // 회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙징
	    @RequestMapping("/joinForm")
		public String JoinForm() {
	    	
			return "security/joinForm";
	    }
	 // 占싸그아울옙 처占쏙옙
	    @RequestMapping("/logout")
		public String logout() {
			return "security/logout";
	    }
	    // 占쏙옙占쏙옙확占쏙옙 처占쏙옙
	    @RequestMapping("/joinOk")
		public String joinOk() {
	    	
			return "#";
	    }
	    
	   //占쏙옙占쏙옙占쏙옙 회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 
	    @RequestMapping("/admin/list")
	    public String userlistPage(Model model) {
	    	model.addAttribute("list", dao.listDao());
	    	return "admin/ManageForMem";
	    }
	    
	    @RequestMapping("/map")
	    public String map() {
	    	return "public/map";
	    }
	  
	    
}