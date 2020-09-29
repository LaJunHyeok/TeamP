package com.project.springboot.signuplogin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.springboot.signuplogin.AccountRepository;

import lombok.RequiredArgsConstructor;

import com.project.springboot.signuplogin.Account;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService{

	@Autowired
	private AccountRepository accounts;
	@Autowired
	private PasswordEncoder encoder;
	
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("## loadUserByUsername ##");

		Account account = accounts.findById(username);

		if( account == null ) {
			log.debug("## ���������� �������� �ʽ��ϴ�. ##");
			throw new UsernameNotFoundException(username);
		}
		return account;
	}

	public Collection<GrantedAuthority> getAuthorities(String username) { 
		
		List<String> string_authorities = accounts.findauthoritiesbyid(username);
		
		if( string_authorities == null ) {
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		
		for (String authority : string_authorities) { 
			authorities.add(new SimpleGrantedAuthority(authority)); 
		} 
		
		return authorities; 

	}
	
	
	
	public Account save(Account account,Authority authority) {
		account.setPassword(encoder.encode(account.getPassword()));
		account.setAccountNonExpired(true);
		account.setAccountNonLocked(true);
		account.setCredentialsNonExpired(true);
		account.setFailCnt(0);
		account.setEnabled(true);
		authority.setAuthorityName("ROLE_USER");
		 
		return accounts.save(account, authority);
		
	}
}
