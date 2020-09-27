package com.project.springboot.signuplogin;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration 
public class SecurityConfig extends WebSecurityConfigurerAdapter { 
	
  @Autowired
  public AuthenticationFailureHandler authenticationFailureHandler; 

  @Override
  public void configure(WebSecurity web) { // 무조건 접근 가능한 인증무시경로
    web.ignoring().antMatchers("/css/**","/src/**","/js/**", "/img/**","/seoul.png",
    		"/security/**","/public/**");
  }

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
            .defaultSuccessUrl("/security/loginSuccess") // 로그인 성공 후 리다이렉트 주소
            .loginProcessingUrl("/loginOk")
            .failureHandler(authenticationFailureHandler)
            .permitAll()
        .and()
          	.logout() // 9
          	.logoutRequestMatcher(new AntPathRequestMatcher("/security/logout"))
            .logoutSuccessUrl("/public/mainPage") // 로그아웃 성공시 리다이렉트 주소
            .invalidateHttpSession(true) // 세션 날리기
        ;
  }
  
  @Bean 
  public BCryptPasswordEncoder passwordEncoder() { // 비밀번호 암호화할때 사용할 인코더를 미리 bean으로 등록하는 과정
    return new BCryptPasswordEncoder();
  }

  @Autowired
  private DataSource dataSource;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	  
	  auth.jdbcAuthentication()
	  	  .dataSource(dataSource)
	  	  .usersByUsernameQuery("select email as username,password,enabled "
	  	  		+ " from USER_TEST1 where email = ?")
	  	  .authoritiesByUsernameQuery("select email as username,authority "
	  	  		+ " from USER_TEST1 where email = ?")
	  	  .passwordEncoder(new BCryptPasswordEncoder());
  }


}