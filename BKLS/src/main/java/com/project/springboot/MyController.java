package com.project.springboot;

import java.util.List;

import com.project.springboot.dto.MemberDto;
import com.project.springboot.dao.MemberDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.springboot.dao.BbsDao;
import com.project.springboot.dto.BbsDto;

@Controller
@AllArgsConstructor
public class MyController
{
	 private MemberDao memberDao;
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
	    @RequestMapping("/notice")
	    public String notice(Model model){

	    	List<BbsDto> notice= dao.notice();

	    	model.addAttribute("notice", dao.notice());
	    	return "public/notice";
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
	   // 회원가입 페이지
	    @GetMapping("/joinForm")
	    public String dispSignup() {
	        return "security/joinForm";
	    }

	    // 가입확인 처리
	    @PostMapping("/joinOk")
		public String joinOk(MemberDto memberDto) {
	    	
			return "redirect:/security/loginForm";
	    }
	 // 로그인 페이징
	    @GetMapping("/security/loginForm")
		public String loginForm1() {
			return "loginForm";
	    }
	 // 로그인 결과페이지
	    @PostMapping("/security/loginForm/result")
		public String loginOk1() {
	    	
			return "security/loginSuccess";
	    }
//	    // 로그인 페이징
//	    @GetMapping("/loginForm")
//		public String loginForm() {
//			return "security/loginForm";
//	    }
//	 // 로그인 결과페이지
//	    @PostMapping("/loginOk")
//		public String loginOk() {
//	    	
//			return "security/loginSuccess";
//	    }
	 // 로그아웃 처리
	    @RequestMapping("/logout")
		public String logout() {
			return "public/mainPage";
	    }
	   
	   //관리자 회원관리 페이지 
	    @RequestMapping("/admin/list")
	    public String userlistPage(Model model) {
	    	model.addAttribute("list", dao.listDao());
	    	return "admin/ManageForMem";
	    }
	  
	    
}