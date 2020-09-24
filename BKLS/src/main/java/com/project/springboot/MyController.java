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
	   
	   //���� ����¡
	    @RequestMapping("/")
	    public String root() throws Exception{	    	
	    	//MyBatis : SimpleBBS
	        return "public/mainPage";
	    }
	   
	    //--------�������� ������ ------------
	    //�������� ����Ʈ ������
	    @RequestMapping("/notice")
	    public String notice(Model model){

	    	List<BbsDto> notice= dao.notice();

	    	model.addAttribute("notice", dao.notice());
	    	return "public/notice";
	    }
	    //������ �������� �ۼ� ������ 
	    @RequestMapping("/admin/writeForm")
	    public String adminWriteForm() {

	    	return "admin/writeFormAdmin";
	    }
	  //�������� �󼼺��� ������ (��������)######################
	    @RequestMapping("/public/confirmboard")
	    public String confirmBoard() {

	    	return "public/confirmboard";
	    }
	  //---------�ֺ� ����� �ȳ�--------------
	    @RequestMapping("/navi")
	    public String navi(){
	        return "public/navigator";
	    }
	  
	   
	   //--------����,�ο� ������ ----------- 
	    //����.�ο� �� �ۼ� ������
	   @RequestMapping("/writeForm")
	    public String writeForm(){
	        return "private/writeForm";
	    }
	  
	  //�ο�,���� ����Ʈ ������ 
	   @RequestMapping("/help")
	    public String help(){
	        return "public/help";
	    }
	 //�ο�,���� �󼼺��� ������ #####################
	   @RequestMapping("/confirmHelp")
	    public String confirmHelp(){
	        return "private/confirmHelp";
	    }
	   
	   //------�ð�ȭ �ڷ� ������ --------------
	 //�ð�ȭ �ڷ� ���� ������ (������ ������ ��)##################
	   @RequestMapping("/dataView")
	    public String dataView(){
	        return "public/dataView";
	    }  
	   
	  //-------�α���,ȸ������ ����¡ ------------
	   // ȸ������ ������
	    @GetMapping("/joinForm")
	    public String dispSignup() {
	        return "security/joinForm";
	    }

	    // ����Ȯ�� ó��
	    @PostMapping("/joinOk")
		public String joinOk(MemberDto memberDto) {
	    	
			return "redirect:/security/loginForm";
	    }
	 // �α��� ����¡
	    @GetMapping("/security/loginForm")
		public String loginForm1() {
			return "loginForm";
	    }
	 // �α��� ���������
	    @PostMapping("/security/loginForm/result")
		public String loginOk1() {
	    	
			return "security/loginSuccess";
	    }
//	    // �α��� ����¡
//	    @GetMapping("/loginForm")
//		public String loginForm() {
//			return "security/loginForm";
//	    }
//	 // �α��� ���������
//	    @PostMapping("/loginOk")
//		public String loginOk() {
//	    	
//			return "security/loginSuccess";
//	    }
	 // �α׾ƿ� ó��
	    @RequestMapping("/logout")
		public String logout() {
			return "public/mainPage";
	    }
	   
	   //������ ȸ������ ������ 
	    @RequestMapping("/admin/list")
	    public String userlistPage(Model model) {
	    	model.addAttribute("list", dao.listDao());
	    	return "admin/ManageForMem";
	    }
	  
	    
}