package com.project.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.springboot.dao.*;
import com.project.springboot.dto.*;

import com.project.springboot.signuplogin.AccountMapper;
import com.project.springboot.signuplogin.AccountService;
import com.project.springboot.signuplogin.Authority;
import com.project.springboot.signuplogin.UserService;
import com.project.springboot.signuplogin.Account;


@Controller
public class MyController
{

	@Autowired
	private BbsDao dao;
	@Autowired
	private userListDao uDao;


	int listCount =10;
	int pagecount= 5;
	@Autowired
	private UserService user;

	@Autowired
	AccountService accountService;
	@Autowired
	AccountMapper accountMapper;

	Authority authority;

	@Autowired
	private PasswordEncoder encoder;

	Logger log = LoggerFactory.getLogger(this.getClass());


	@RequestMapping("/")
	public String root() throws Exception{	    	
		//MyBatis : SimpleBBS
		return "public/mainPage";
	}

	@RequestMapping("/notice")
	public String notice(HttpServletRequest request ,Model model){
		System.out.println("notice");

		int nPage = 0;
		try {
			String page = request.getParameter("page");
			System.out.println("Page :" +page);
			nPage = Integer.parseInt(page);
		} catch (Exception e) {
			System.out.println("error");
			 nPage = 1;
		}

		BbsPage total = dao.articlePage(); 
		model.addAttribute("total",dao.articlePage());
		int totalCount = total.getTotal();
		//System.out.println(total);
		System.out.println("total"+totalCount);
		PageInfo info = new PageInfo();
		BpageInfo binfo = info.pInfo(totalCount,nPage);
		int nStart = (nPage -1) * listCount;
		System.out.println("curPage"+nPage);
		List<BbsDto> notice = dao.notice(nStart);

		System.out.println(binfo);
		model.addAttribute("notice", notice);
		model.addAttribute("page", binfo);
		System.out.println("list"+notice);
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
	public String noticesearch(HttpServletRequest request ,String title, Model model){
		System.out.println(title);
		int nPage = 0;
		try {
			String page = request.getParameter("page");
			System.out.println("Page :" +page);
			nPage = Integer.parseInt(page);
		} catch (Exception e) {
			System.out.println("error");
			nPage = 1;
		}
		BbsPage total = dao.searchPage(title); 
		model.addAttribute("total",dao.searchPage(title));
		int totalCount = total.getTotal();
		//System.out.println(total);
		System.out.println("total"+totalCount);
		PageInfo info = new PageInfo();
		BpageInfo binfo = info.pInfo(totalCount,nPage);
		int nStart = (nPage -1) * listCount;
		System.out.println("현재 페이지는"+nPage);
		List<BbsDto> noticesearch = dao.noticesearch(title,nStart);
		System.out.println("search");
		model.addAttribute("notice", noticesearch);
		model.addAttribute("page", binfo);
		model.addAttribute("title",title);
		System.out.println(binfo);
		System.out.println("글목록"+noticesearch);
		return "public/noticeSearch";
	}


	@RequestMapping("/admin/writeForm")
	public String adminWriteForm() {

		return "admin/writeNotice";
	}

	@RequestMapping("/public/confirmboard")
	public String confirmBoard() {

		return "public/confirmboard";
	}
	//---------찾아오는 길 페이지--------------
	@RequestMapping("/public/navi")
	public String navi(){
		return "public/navigator";
	}


	//--------민원 건의사항 메뉴 ----------- 

	//민원 페이지
	@RequestMapping("/public/help")
	public String help(HttpServletRequest request, Model model) {

		int nPage = 1;
		try {
			String page = request.getParameter("page");
			System.out.println("Page :" +page);
			nPage = Integer.parseInt(page);
		} catch (Exception e) {

		}


		BbsPage total = dao.articlePage1(); 
		model.addAttribute("total",dao.articlePage1());
		int totalCount = total.getTotal();	
		PageInfo info = new PageInfo();
		BpageInfo binfo = info.pInfo(totalCount,nPage);
		int nStart = (nPage -1) * listCount;
		List<BbsDto> help = dao.help(nStart);

		System.out.println(binfo);
		model.addAttribute("help", help);
		model.addAttribute("page", binfo);
		return "public/help";
	}
	//민원 상세 페이지##################
	@RequestMapping("/public/helpview")
	public String helpview(Model model, int num1){

		System.out.println("helpview");
		dao.helphit(num1);
		List<BbsDto> helpview = dao.helpview(num1);

		model.addAttribute("help", helpview);
		System.out.println(helpview);
		return "public/helpView";
	}
	// 민원 글쓰기 
	@RequestMapping("/write1")
	public String write1(String title1, String content1) {
		dao.writeDao1(title1, content1);
		return "redirect:/help";
	}
	//민원 글작성 업데이트
	@RequestMapping("/helpupdate")
	public String update1(Model model ,String num1,String title1,String content1){
		int bnum1 = Integer.parseInt(num1);
		dao.helpupdate(bnum1,title1,content1);
		System.out.println("helpupdate");
		System.out.println(num1);
		System.out.println(title1);
		System.out.println(content1);
		return "redirect:/public/help";
	}
	//민원 수정
	@RequestMapping("/helpmodify")
	public String helpmodify(Model model ,int num1){

		System.out.println("helpmodify");
		List<BbsDto> helpview = dao.helpview(num1);
		model.addAttribute("help", helpview);

		System.out.println(helpview);

		//model.addAttribute("notice", dao.notice());
		return "admin/helpmodify";
	}
	// 민원(제목) 검색 기능
	@RequestMapping("/help_search")
	public String help_search(Model model, String title1) {

		List<BbsDto> help_search = dao.help_search(title1);
		model.addAttribute("help",help_search);
		return "public/help";
	}
	// 민원 글 작성 폼
	@RequestMapping("/private/writeHelp")
	public String adminWriteForm2() {

		return "private/writeHelp";
	}

	//------시각화자료 페이지 --------------
	//시각화 자료 페이지 만들어야함)##################
	@RequestMapping("public/dataView")
	public String dataView(){
		return "public/dataView";
	}  

	//-------회원가입 메뉴------------
	// 회원가입 페이지
	@RequestMapping("/security/joinForm")
	public String dispSignup() {
		return "security/joinForm";
	}

	// 가입 프로세스
	@RequestMapping("/public/joinOk")
	public String joinOk(HttpServletRequest request,Model model) {
		String id= request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email= request.getParameter("email");
		String address = request.getParameter("address");
		Map<String,String> map = new HashMap<String,String>();

		map.put("item1",id);
		map.put("item2",encoder.encode(password));
		map.put("item3",name);
		map.put("item4",email);
		map.put("item5",address);
		System.out.println(map);
		user.join(map);

		Account account=new Account();
		Authority authority = new Authority();
		account.setId(id);
		account.setPassword(password);
		authority.setUserName(id);
		accountService.save(account, authority);
		return "security/loginForm";
	}

	// 로그인 폼
	@RequestMapping("/security/loginForm")
	public String loginForm(Model model, HttpServletRequest req) {
		return "security/loginForm";
	}

	// 로그인 프로세스
	@RequestMapping("/security/loginSuccess")
	public String loginOk() {

		return "security/loginSuccess";
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout() {
		return "public/mainPage";
	}

	// admin user manage mapping
	@RequestMapping("/admin/userList")
	public String userlistPage( Model model) {
		model.addAttribute("userList", uDao.userList());
		return "admin/userList";
	}

	@RequestMapping("/admin/userBan")
	public String userBan(HttpServletRequest request, Model model) {
		uDao.userBan(request.getParameter("id"));
		return "redirect:userList";
	}

	@RequestMapping("/admin/userRestore")
	public String userRestore(HttpServletRequest request, Model model) {
		uDao.userRestore(request.getParameter("id"));
		return "redirect:userList";
	}

}