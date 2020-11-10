package main.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import main.authority.Authority;

public class AdminDetails implements UserDetails {
	private String username;
	private String password;
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	private Admin admin;
	
	public AdminDetails(Admin admin) {
		this.username = admin.getUsername();
		this.password = admin.getPassword();
		for(Authority ele : admin.getAuthorities()) {
			this.authorities.add(new SimpleGrantedAuthority(ele.getAuthority()));
		}
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
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
		return true;
	}

}
