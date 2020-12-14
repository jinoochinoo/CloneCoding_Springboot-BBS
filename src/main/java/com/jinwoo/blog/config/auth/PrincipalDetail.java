package com.jinwoo.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jinwoo.blog.model.User;

import lombok.Getter;

@Getter
public class PrincipalDetail implements UserDetails{
	
	private User user;

	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override 
	public boolean isAccountNonExpired() {
		return true; // 계정 만료 여부
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // 계정 잠김 여부
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // 비밀번호 만료 여부
	}

	@Override
	public boolean isEnabled() {
		return true; // 계정 활성화 여부
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return "ROLE_"+user.getRole(); // ROLE_USER 롤 받을 때 규칙
			}
		});
		
		return collectors;
	}
}
