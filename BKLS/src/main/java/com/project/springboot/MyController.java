package com.project.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.springboot.dao.BbsDao;
import com.project.springboot.dto.BbsDto;
import com.project.springboot.signuplogin.UserService;

import lombok.AllArgsConstructor;;


@Controller
@AllArgsConstructor
public class MyController
{

	   @Autowired
	   private BbsDao dao;
	   @Autowired
	   private UserService user;
	   //MemberDao Mdao;
	   
	   //���� ����¡
	    @RequestMapping("/")
	    public String root() throws Exception{	    	
	    	//MyBatis : SimpleBBS
	        return "public/mainPage";
	    }
	   
	    //--------�������� ������ ------------
	    //�������� ����Ʈ ������
	    @RequestMapping("/public/notice")
	    public String notice(Model model){
	    	
	    	
	    	model.addAttribute("notice",dao.notice());
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
	    @RequestMapping("/public/navi")
	    public String navi(){
	        return "public/navigator";
	    }
	  
	   
	   //--------����,�ο� ������ ----------- 
	    //����.�ο� �� �ۼ� ������
	   @RequestMapping("/private/writeForm")
	    public String writeForm(){
	        return "private/writeForm";
	    }
	  
	  //�ο�,���� ����Ʈ ������ 
	   @RequestMapping("/public/help")
	    public String help(){
	        return "public/help";
	    }
	 //�ο�,���� �󼼺��� ������ #####################
	   @RequestMapping("/private/confirmHelp")
	    public String confirmHelp(){
	        return "private/confirmHelp";
	    }
	   
	   //------�ð�ȭ �ڷ� ������ --------------
	 //�ð�ȭ �ڷ� ���� ������ (������ ������ ��)##################
	   @RequestMapping("public/dataView")
	    public String dataView(){
	        return "public/dataView";
	    }  
	   
	  //-------�α���,ȸ������ ����¡ ------------
	   // ȸ������ ������
	    @RequestMapping("/security/joinForm")
	    public String dispSignup() {
	        return "security/joinForm";
	    }

	    // ����Ȯ�� ó��
	    @RequestMapping("/public/joinOk")
		public String joinOk(HttpServletRequest request,Model model) {
	    	String sName = request.getParameter("j_username");
	    	String sPassword = request.getParameter("j_password");
	    	
	    	Map<String,String> map = new HashMap<String,String>();
	    	map.put("item1",sName);
	    	map.put("item2",sPassword);
	    	System.out.println(map);
	    	user.join(map);
			return "security/loginForm";
	    }
	 // �α��� ����¡
	    @RequestMapping("/security/loginForm")
		public String loginForm() {
			return "security/loginForm";
	    }
	 // �α��� ����¡
	    @RequestMapping("/loginOk")
		public String loginOk() {
			return "public/mainPage";
	    }
	 // �α��� ���������
	    @RequestMapping("/security/loginSuccess")
		public String loginOk(Model model) {
	    	
			return "security/loginSuccess";
	    }
	 // �α׾ƿ� ó��
	    @RequestMapping("/logout")
		public String logout() {
			return "public/mainPage";
	    }
	   
	   //������ ȸ������ ������ 
	    @RequestMapping("/admin/ManageForMem")
	    public String userlistPage(Model model) {
	    	model.addAttribute("list", dao.listDao());
	    	return "admin/ManageForMem";
	    }
	  
	    
}