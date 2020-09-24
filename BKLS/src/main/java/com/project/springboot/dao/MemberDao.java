package com.project.springboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.dto.MemberDto;
import com.project.springboot.signuplogin.MemberEntity;
import com.project.springboot.signuplogin.MemberRepository;
import com.project.springboot.signuplogin.Role;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MemberDao implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional
    public String joinUser(MemberDto memberDto) {
        // 비밀번호 암호화
               BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getId();
    }
@Override
public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
	Optional<MemberEntity> userEntityWrapper = memberRepository.findById(userID);
    MemberEntity userEntity = userEntityWrapper.get();
    
	List<GrantedAuthority> authorities = new ArrayList<>();
	
    if (("ADMIN").equals(userID)) {
        authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
    } else {
        authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
    }

    return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
	}
}


