package org.worklog.worklogservice.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -5171924477766790949L;
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl() {
	}

	public UserDetailsImpl(Staff staff) {
		this.username = staff.getUsername();
		this.password = staff.getPassword();
		this.active = staff.isActive();
		this.authorities = getRoles(staff.getRole());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

	private List<GrantedAuthority> getRoles(String roles) {
		String[] roleList = roles.split(";");
		List<GrantedAuthority> authorities = new ArrayList<>();
		if (roles != null && !roles.isEmpty()) {
			for (String role : roleList) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
		}
		return authorities;
	}

}
