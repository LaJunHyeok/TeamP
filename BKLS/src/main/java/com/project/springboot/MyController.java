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

import com.project.springboot.dao.BbsDao;
import com.project.springboot.dao.PageInfo;
import com.project.springboot.dto.BbsDto;
import com.project.springboot.dto.BbsPage;
import com.project.springboot.dto.BpageInfo;
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

		int nPage = 1;
		try {
			String page = request.getParameter("page");
			System.out.println("Page :" +page);
			nPage = Integer.parseInt(page);
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}

		BbsPage total = dao.articlePage(); 
		model.addAttribute("total",dao.articlePage());
		int totalCount = total.getTotal();
		//System.out.println(total);
		System.out.println("total"+totalCount);
		PageInfo info = new PageInfo();
		BpageInfo binfo = info.pInfo(totalCount,nPage);
		int nStart = (nPage -1) * listCount;
		System.out.println("현재 페이지는"+nPage);
		List<BbsDto> notice = dao.notice(nStart);

		System.out.println(binfo);
		model.addAttribute("notice", notice);
		model.addAttribute("page", binfo);
		System.out.println("글목록"+notice);
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



	@RequestMapping("/admin/writeForm")
	public String adminWriteForm() {

		return "admin/writeNotice";
	}

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

	// �α��� ����¡
	@RequestMapping("/security/loginForm")
	public String loginForm(Model model, HttpServletRequest req) {
		return "security/loginForm";
	}

	// �α��� ���������
	@RequestMapping("/security/loginSuccess")
	public String loginOk() {

		return "security/loginSuccess";
	}
	// LOGIN Fail	
	@GetMapping("/loginFail")
	@ResponseBody
	public String loginFail() {
		return "Fail !";
	}
	// �α׾ƿ� ó��
	@RequestMapping("/logout")
	public String logout() {
		return "public/mainPage";
	}

	//������ ȸ������ ������ 
	@RequestMapping("/admin/ManageForMem")
	public String userlistPage(Model model) {

		return "admin/ManageForMem";
	}


}