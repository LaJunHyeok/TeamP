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
  public void configure(WebSecurity web) { // ������ ���� ������ �������ð��
    web.ignoring().antMatchers("/css/**","/src/**","/js/**", "/img/**","/seoul.png",
    		"/security/**","/public/**");
  }

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
            .defaultSuccessUrl("/security/loginSuccess") // �α��� ���� �� �����̷�Ʈ �ּ�
            .loginProcessingUrl("/loginOk")
            .failureHandler(authenticationFailureHandler)
            .permitAll()
        .and()
          	.logout() // 9
          	.logoutRequestMatcher(new AntPathRequestMatcher("/security/logout"))
            .logoutSuccessUrl("/public/mainPage") // �α׾ƿ� ������ �����̷�Ʈ �ּ�
            .invalidateHttpSession(true) // ���� ������
        ;
  }
  
  @Bean 
  public BCryptPasswordEncoder passwordEncoder() { // ��й�ȣ ��ȣȭ�Ҷ� ����� ���ڴ��� �̸� bean���� ����ϴ� ����
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