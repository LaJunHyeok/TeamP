package com.project.springboot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.springboot.dao.BbsDao;
import com.project.springboot.dao.userListDao;
import com.project.springboot.dto.BbsDto;

@Controller
public class MyController
{
	@Autowired
	BbsDao dao;
	@Autowired
	userListDao uDao;
	
	//MemberDao Mdao;

	//���� ����¡
	@RequestMapping("/")
	public String root() throws Exception{	    	
		//MyBatis : SimpleBBS
		return "public/mainPage";
	}
	//--------�������� ������ ------------
	//�������� ����Ʈ ������
	@RequestMapping("admin/write")
	public String write(String title,String content){
		dao.writeDao(title, content);
		System.out.println("write");
		return "redirect:/notice";
	}
	@RequestMapping("/notice")
	public String notice(Model model){
		List<BbsDto> notice = dao.notice();
		System.out.println("notice");
		model.addAttribute("notice", notice);
		System.out.println(notice);
		return "public/notice";
	}
	@RequestMapping("/noticeview")
	public String noticeview(Model model, int num){

		System.out.println("noticeview");
		List<BbsDto> noticeview = dao.noticeview(num);
		model.addAttribute("notice", noticeview);
		System.out.println(noticeview);
		return "public/noticeView";
	}
	@RequestMapping("/noticedelete")
	public String noticedelete(Model model,int num){

		dao.noticedelete(num);
		System.out.println("noticedelete");

		return "redirect:/notice";
	}
	@RequestMapping("/noticeupdate")
	public String update(Model model ,String num,String title,String content){
		int bnum = Integer.parseInt(num);
		dao.noticeupdate(bnum,title,content);
		System.out.println("noticeupdate");
		System.out.println(num);
		System.out.println(title);
		System.out.println(content);
		return "redirect:/notice";
	}
	@RequestMapping("/noticemodify")
	public String noticemodify(Model model ,int num){
		
		System.out.println("noticemodify");
		List<BbsDto> noticeview = dao.noticeview(num);
		model.addAttribute("notice", noticeview);

		System.out.println(noticeview);

		//model.addAttribute("notice", dao.notice());
		return "admin/noticemodify";
	}
	
	//������ �������� �ۼ� ������ 
	@RequestMapping("/admin/writeForm")
	public String adminWriteForm() {

		return "admin/writeNotice";
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
	// �α��� ����¡
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "security/loginForm";
	}
	// ȸ������ ����¡
	@RequestMapping("/joinForm")
	public String JoinForm() {

		return "security/joinForm";
	}
	// �α׾ƿ� ó��
	@RequestMapping("/logout")
	public String logout() {
		return "security/logout";
	}
	// ����Ȯ�� ó��
	@RequestMapping("/joinOk")
	public String joinOk() {

		return "#";
	}

	// admin user manage mapping
	@RequestMapping("/admin/userList")
	public String userlistPage(Model model) {
		model.addAttribute("userList", uDao.userList());
		return "admin/userList";
	}
	
	@RequestMapping("/admin/userBan")
	public String userBan(HttpServletRequest request, Model model) {
		uDao.userBan(request.getParameter("user_id"));
		return "redirect:userList";
	}
	
	@RequestMapping("/admin/userRestore")
	public String userRestore(HttpServletRequest request, Model model) {
		uDao.userRestore(request.getParameter("user_id"));
		return "redirect:userList";
	}
}