package edu.hi.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDetailsVO implements UserDetails {

	private String username; // ID
	private String password; // PW
	private List<GrantedAuthority> authorities;

	
	public UserDetailsVO(UserVO user) {
		this.setAuthorities(user);
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
		
	}
	
	// setter
	public void setUsername(String username) {
		this.username = username;
	}

	// setter
	public void setPassword(String password) {
		this.password = password;
	}

	// setter
	public void setAuthorities(UserVO userVO) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (AuthVO auth : userVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}
		
		this.authorities = authorities;
	}

	// ID
	@Override
	public String getUsername() {
		return username;
	}

	// PW
	@Override
	public String getPassword() {
		return password;
	}

	// 권한
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	// 계정이 만료 되지 않았는가?
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠기지 않았는가?
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 패스워드가 만료되지 않았는가?
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화 되었는가?
	@Override
	public boolean isEnabled() {
		return true;
	}

}
