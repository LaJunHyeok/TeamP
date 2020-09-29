package com.project.springboot.signuplogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration 
public class SecurityConfig extends WebSecurityConfigurerAdapter { 
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	private AuthenticationFailureHandler failureHandler;

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
//  @Override
//  public void configure(WebSecurity web) { // 무조건 접근 가능한 인증무시경로
//    web.ignoring().antMatchers("/css/**","/src/**","/js/**", "/img/**","/seoul.png",
//    		"/security/**","/public/**");
//  }

  @Override
  protected void configure(HttpSecurity http) throws Exception { 
    http
          .authorizeRequests() // 7
            .antMatchers("/","/security/**", "/public/**", "/footer","/menubar","/**").permitAll() // 누구나 접근 허용
            .antMatchers("/private/**").hasAnyRole("ADMIN","USER")
            .antMatchers("/admin/**").hasRole("ADMIN") // ADMIN만 접근 가능
            .antMatchers("/**").permitAll()
        .and() 
          .formLogin()
            .loginPage("/security/loginForm") // 로그인 페이지 링크
            .loginProcessingUrl("/loginOk")
            .defaultSuccessUrl("/") // 로그인 성공 후 리다이렉트 주소
            .failureHandler(failureHandler)
            .successHandler(successHandler)
            .permitAll()
        .and()
          	.logout() // 9
            .logoutSuccessUrl("/") // 로그아웃 성공시 리다이렉트 주소
            .invalidateHttpSession(true) // 세션 날리기
        ;
  }
  
  // 인증에 필요한 관리자 정보 생성
  @Autowired
  public void authenticate(AuthenticationManagerBuilder auth) throws Exception{
	  auth.inMemoryAuthentication() //메모리에 사용자정보저장하는 메소드
	  	  .withUser("admin")
	  	  .password("{noop}1234")
	  	  .roles("ADMIN"); //권한설정
  }
  
  /*
  @Bean 
  public BCryptPasswordEncoder passwordEncoder() { // 비밀번호 암호화할때 사용할 인코더를 미리 bean으로 등록하는 과정
    return new BCryptPasswordEncoder();
  }
  */
  
  @Bean
  public PasswordEncoder passwordEncoder() {
	log.info("[ BEAN ] : passwordEncoder");
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }


  // 로그인 성공 처리를 위한 Handler
  @Bean
  public AuthenticationSuccessHandler successHandler() {
	  log.info("[ BEAN ] : AuthenticationSuccessHandler");
	  // loginIdname, defaultUrl
      return new CustomAuthenticationSuccessHandler("username", "/");
  }
  // 실패 처리를 위한 Handler
  @Bean
  public AuthenticationFailureHandler failureHandler() {
	  log.info("[ BEAN ] : failureHandler");
	  return new CustomAuthenticationFailureHandler("username", "password" , "/security/loginSuccess" , "exceptionMsgName" , "/security/loginForm");
  }


}