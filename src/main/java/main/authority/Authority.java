package main.authority;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import main.admin.Admin;
import main.client.Client;

@Entity
public class Authority {
	@Id
	private String authority;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="authoritiesofclient",
			   joinColumns=@JoinColumn(name="authority"),
			   inverseJoinColumns=@JoinColumn(name="clientId"))
	private Set<Client> client;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="authoritiesofadmin",
			   joinColumns=@JoinColumn(name="authority"),
			   inverseJoinColumns=@JoinColumn(name="adminId"))
	private Set<Admin> admin;

	public Set<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(Set<Admin> admin) {
		this.admin = admin;
	}

	public Set<Client> getClient() {
		return client;
	}

	public void setClient(Set<Client> client) {
		this.client = client;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
	

}
