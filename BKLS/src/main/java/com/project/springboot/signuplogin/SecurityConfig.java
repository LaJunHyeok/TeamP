package com.project.springboot.signuplogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.project.springboot.signuplogin.CustomAuthenticationFailureHandler;
import com.project.springboot.signuplogin.CustomAuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration 
public class SecurityConfig extends WebSecurityConfigurerAdapter { 
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	private AuthenticationFailureHandler failureHandler;

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
//  @Override
//  public void configure(WebSecurity web) { // ������ ���� ������ �������ð��
//    web.ignoring().antMatchers("/css/**","/src/**","/js/**", "/img/**","/seoul.png",
//    		"/security/**","/public/**");
//  }

  @Override
  protected void configure(HttpSecurity http) throws Exception { 
    http
          .authorizeRequests() // 7
            .antMatchers("/","/security/**", "/public/**", "/footer","/menubar","/**").permitAll() // ������ ���� ���
            .antMatchers("/private/**").hasAnyRole("ADMIN","USER")
            .antMatchers("/admin/**").hasRole("ADMIN") // ADMIN�� ���� ����
            .antMatchers("/**").permitAll()
        .and() 
          .formLogin()
            .loginPage("/security/loginForm") // �α��� ������ ��ũ
            .loginProcessingUrl("/loginOk")
            .defaultSuccessUrl("/security/loginSuccess") // �α��� ���� �� �����̷�Ʈ �ּ�
            .failureHandler(failureHandler)
            .successHandler(successHandler)
            .permitAll()
        .and()
          	.logout() // 9
            .logoutSuccessUrl("/") // �α׾ƿ� ������ �����̷�Ʈ �ּ�
            .invalidateHttpSession(true) // ���� ������
        ;
  }
  /*
  @Bean 
  public BCryptPasswordEncoder passwordEncoder() { // ��й�ȣ ��ȣȭ�Ҷ� ����� ���ڴ��� �̸� bean���� ����ϴ� ����
    return new BCryptPasswordEncoder();
  }
  */
  
  @Bean
  public PasswordEncoder passwordEncoder() {
	log.info("[ BEAN ] : passwordEncoder");
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
  
  // �α��� ���� ó���� ���� Handler
  @Bean
  public AuthenticationSuccessHandler successHandler() {
	  log.info("[ BEAN ] : AuthenticationSuccessHandler");
	  // loginIdname, defaultUrl
      return new CustomAuthenticationSuccessHandler("username", "/security/loginSuccess");
  }
  
  // ���� ó���� ���� Handler
  @Bean
  public AuthenticationFailureHandler failureHandler() {
	  log.info("[ BEAN ] : failureHandler");
	  return new CustomAuthenticationFailureHandler("username", "password" , "/security/loginSuccess" , "exceptionMsgName" , "/security/loginForm");
  }


}