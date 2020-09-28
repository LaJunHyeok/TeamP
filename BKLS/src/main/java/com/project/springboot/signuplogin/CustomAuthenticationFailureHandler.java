package com.project.springboot.signuplogin;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.project.springboot.signuplogin.AccountRepository;
import com.project.springboot.signuplogin.Account;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	private String loginIdName ;  			// �α��� id���� ������ input�±� name
	private String loginPasswordName ;		// �α��� pw���� ������ input�±� name
	private String loginRedirectUrl ;		// �α��� ������ redirect �� URL�� �����Ǿ� �ִ� input�±� name
	private String exceptionMsgName ;		// ���� �޽����� REQUEST�� ATTRIBUTE�� ������ �� ���
	private String defaultFailureUrl ;		// ȭ�鿡 ������ url(�α��� ȭ��)
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	AccountRepository accoutDao;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public CustomAuthenticationFailureHandler(String loginIdName, String loginPasswordName, String loginRedirectUrl,
			String exceptionMsgName, String defaultFailureUrl) {
		this.loginIdName = loginIdName;
		this.loginPasswordName = loginPasswordName;
		this.loginRedirectUrl = loginRedirectUrl;
		this.exceptionMsgName  = exceptionMsgName;
		this.defaultFailureUrl = defaultFailureUrl;
	}

	public String getLoginIdName() {
		return loginIdName;
	}
	public void setLoginIdName(String loginIdName) {
		this.loginIdName = loginIdName;
	}
	public String getLoginPasswordName() {
		return loginPasswordName;
	}
	public void setLoginPasswordName(String loginPasswordName) {
		this.loginPasswordName = loginPasswordName;
	}
	public String getLoginRedirectUrl() {
		return loginRedirectUrl;
	}
	public void setLoginRedirectUrl(String loginRedirectUrl) {
		this.loginRedirectUrl = loginRedirectUrl;
	}
	public String getExceptionMsgName() {
		return exceptionMsgName;
	}
	public void setExceptionMsgName(String exceptionMsgName) {
		this.exceptionMsgName = exceptionMsgName;
	}
	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}
	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		log.info("######### onAuthenticationFailure #########");
		
		String loginId = request.getParameter(loginIdName);
		String loginPw = request.getParameter(loginPasswordName);
		String loginRedirect = request.getParameter(loginRedirectUrl);
		String errormsg = exception.getMessage();
		
		if(exception instanceof BadCredentialsException) {
			// ���������� Ȯ���Ͽ�, errormsg�������ش�.
			boolean userUnLock = true;
			userUnLock = failCnt(loginId);
			if ( !userUnLock )
				errormsg = messageSource.getMessage("AccountStatusUserDetailsChecker.disabled", null , Locale.KOREA);
			else
				errormsg = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", null , Locale.KOREA);
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errormsg = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.InternalAuthentication", null , Locale.KOREA); 
		} else if(exception instanceof DisabledException) {
			errormsg = messageSource.getMessage("AccountStatusUserDetailsChecker.disabled", null , Locale.KOREA);
		} else if(exception instanceof CredentialsExpiredException) {
			errormsg = messageSource.getMessage("AccountStatusUserDetailsChecker.expired", null , Locale.KOREA);
		} else if(exception instanceof UsernameNotFoundException) {
			Object[] args = new String[] { loginId } ;
			errormsg = messageSource.getMessage("DigestAuthenticationFilter.usernameNotFound", args , Locale.KOREA);
		} else if(exception instanceof AccountExpiredException) {
			errormsg = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.expired", null , Locale.KOREA);
		} else if(exception instanceof LockedException) {
			errormsg = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.locked", null , Locale.KOREA);
		} 
		
		request.setAttribute(loginIdName, loginId);
		request.setAttribute(loginPasswordName, loginPw);
		request.setAttribute(loginRedirectUrl, loginRedirect);
		request.setAttribute(exceptionMsgName, errormsg);
		
		log.info(" exception.getMessage() : " + exception.getMessage() );
		
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}
	
	private boolean failCnt(String loginId) {
		
		// ������ ������� �߰��� ����Ƚ�� ������Ű���ʰ�, true�� return�Ѵ�.
		boolean userUnLock = true;

		// ����Ƚ�� select
		Account account = accoutDao.getUserInfo(loginId);
		userUnLock = account.isEnabled();

		// ������ Ȱ��ȭ �Ǿ��ִ� ��쿡�� ����Ƚ����, Enabled������ �����Ѵ�.
		// Enabled������ ����Ƚ���� 5�̻��� �� �ٲ��.
		if ( userUnLock ) {
			if( account.getFailCnt() < 5 )
				accoutDao.loginFailCnt(loginId);
			else
				accoutDao.changeEnabled(loginId);
		}
		return userUnLock;
	}
}