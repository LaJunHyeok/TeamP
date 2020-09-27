package com.project.springboot.signuplogin;

import java.io.IOException;

import javax.security.auth.login.CredentialExpiredException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
										HttpServletResponse response,
										AuthenticationException exception)
	throws IOException, ServletException {
		String loginid = request.getParameter("username");
		String errormsg = "";
		
		if (exception instanceof BadCredentialsException) {
			loginFailureCount(loginid);
			errormsg = "���̵� ��й�ȣ�� ���� �ʽ��ϴ�. �ٽ� Ȯ�����ּ���.";
		}else if (exception instanceof InternalAuthenticationServiceException) {
			loginFailureCount(loginid);
			errormsg = "���̵� ��й�ȣ�� ���� �ʽ��ϴ�. �ٽ� Ȯ�����ּ���.";
		}else if (exception instanceof DisabledException) {
			errormsg = "������ ��Ȱ��ȭ�Ǿ����ϴ�. �����ڿ��� �������ּ���.";
		}
		
		request.setAttribute("username", loginid);
		request.setAttribute("error_message", errormsg);
		
		request.getRequestDispatcher("/security/loginForm?error=ture").forward(request, response);
	}
	
	//��й�ȣ�� 3�� �̻� Ʋ�� �� ���� ��� ó��
	protected void loginFailureCount(String username) {
		/*
		 //Ʋ�� Ƚ�� ������Ʈ
		  
		 */
	}
	
}
