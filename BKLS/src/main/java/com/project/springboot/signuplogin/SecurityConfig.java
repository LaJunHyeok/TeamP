package com.project.springboot.signuplogin;

import com.project.springboot.dao.MemberDao;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private MemberDao memberDao;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static ���͸��� ���� ���� ����� ���� ���� ( = �׻���� )
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**","/public/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // ������ ���� ����
                                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/private/myinfo").hasRole("MEMBER")
                .antMatchers("/**").permitAll()
            .and() // �α��� ����
                                .formLogin()
                .loginPage("/security/loginForm")
                .defaultSuccessUrl("/security/loginForm/result")
                .permitAll()
            .and() // �α׾ƿ� ����
                               .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
            .and()
                // 403 ����ó�� �ڵ鸵 ���ٱ��Ѿ����� ����ó�� �ڵ鸵
                               .exceptionHandling().accessDeniedPage("/");
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberDao).passwordEncoder(passwordEncoder());
    }
}