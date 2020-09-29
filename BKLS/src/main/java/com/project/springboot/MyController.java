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
	
	@RequestMapping("admin/write")
	public String write(String title,String content){
		dao.writeDao(title, content);
		System.out.println("write");
		return "redirect:/notice";
	}
	
	@RequestMapping("admin/write1")
	public String write1(String title1, String content1) {
		dao.writeDao1(title1, content1);
		return "redirect:/help";
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
		dao.noticehit(num);
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
	@RequestMapping("/noticesearch")
	public String noticesearch(Model model, String title ){
		System.out.println(title);
		List<BbsDto> noticesearch = dao.noticesearch(title);
		System.out.println("search");
		model.addAttribute("notice", noticesearch);
		System.out.println(noticesearch);
		return "public/noticeSearch";
	}





	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌜쇽옙 占쏙옙占쏙옙占쏙옙 
	@RequestMapping("/admin/writeForm")
	public String adminWriteForm() {

		return "admin/writeNotice";
	}
	
	@RequestMapping("/admin/writeHelp")
	public String adminWriteForm2() {
		
		return "admin/writeHelp";
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


	
	//占싸울옙,占쏙옙占쏙옙 占쏙옙占쏙옙트 占쏙옙占쏙옙占쏙옙 
	@RequestMapping("/help")
	public String help(Model model) {
		List<BbsDto> help = dao.help();
		model.addAttribute("help", help);

		System.out.println(help);
		return "public/help";
	}
	
	@RequestMapping("/helpview")
	public String helpview(Model model, int num1){
		
		System.out.println("helpview");
		dao.helphit(num1);
		List<BbsDto> helpview = dao.helpview(num1);
		
		model.addAttribute("help", helpview);
		System.out.println(helpview);
		return "public/helpView";
	}
	
	@RequestMapping("/helpupdate")
	public String update1(Model model ,String num1,String title1,String content1){
		int bnum1 = Integer.parseInt(num1);
		dao.helpupdate(bnum1,title1,content1);
		System.out.println("helpupdate");
		System.out.println(num1);
		System.out.println(title1);
		System.out.println(content1);
		return "redirect:/help";
	}
	
	@RequestMapping("/helpmodify")
	public String helpmodify(Model model ,int num1){
		
		System.out.println("helpmodify");
		List<BbsDto> helpview = dao.helpview(num1);
		model.addAttribute("help", helpview);

		System.out.println(helpview);

		//model.addAttribute("notice", dao.notice());
		return "admin/helpmodify";
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


}