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
	   
	   //메인 페이징
	    @RequestMapping("/")
	    public String root() throws Exception{	    	
	    	//MyBatis : SimpleBBS
	        return "public/mainPage";
	    }
	    //--------공지사항 페이지 ------------
	    //공지사항 리스트 페이지
	    @RequestMapping("/board")
	    public String board(Model model){
	    	
	    	List<BbsDto> board = dao.board();
	    	
	    	model.addAttribute("board", dao.board());
	    	return "public/board";
	    }
	    //관리자 공지사항 작성 페이지 
	    @RequestMapping("/admin/writeForm")
	    public String adminWriteForm() {

	    	return "admin/writeFormAdmin";
	    }
	  //공지사항 상세보기 페이지 (만들어야함)######################
	    @RequestMapping("/public/confirmboard")
	    public String confirmBoard() {

	    	return "public/confirmboard";
	    }
	  //---------주변 파출소 안내--------------
	    @RequestMapping("/navi")
	    public String navi(){
	        return "public/navigator";
	    }
	  
	   
	   //--------건의,민원 페이지 ----------- 
	    //건의.민원 글 작성 페이지
	   @RequestMapping("/writeForm")
	    public String writeForm(){
	        return "private/writeForm";
	    }
	  
	  //민원,건의 리스트 페이지 
	   @RequestMapping("/help")
	    public String help(){
	        return "public/help";
	    }
	 //민원,건의 상세보기 페이지 #####################
	   @RequestMapping("/confirmHelp")
	    public String confirmHelp(){
	        return "private/confirmHelp";
	    }
	   
	   //------시각화 자료 페이지 --------------
	 //시각화 자료 보기 페이지 (페이지 만들어야 함)##################
	   @RequestMapping("/dataView")
	    public String dataView(){
	        return "public/dataView";
	    }  
	   
	  //-------로그인,회원가입 페이징 ------------
	   // 로그인 페이징
	    @RequestMapping("/loginForm")
		public String loginForm() {
			return "security/loginForm";
	    }
	 // 회원가입 페이징
	    @RequestMapping("/joinForm")
		public String JoinForm() {
	    	
			return "security/joinForm";
	    }
	 // 로그아웃 처리
	    @RequestMapping("/logout")
		public String logout() {
			return "security/logout";
	    }
	    // 가입확인 처리
	    @RequestMapping("/joinOk")
		public String joinOk() {
	    	
			return "#";
	    }
	    
	   //관리자 회원관리 페이지 
	    @RequestMapping("/admin/list")
	    public String userlistPage(Model model) {
	    	model.addAttribute("list", dao.listDao());
	    	return "admin/ManageForMem";
	    }
	  
	    
}