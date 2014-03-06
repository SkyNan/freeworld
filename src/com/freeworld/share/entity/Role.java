package com.freeworld.share.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="s_role")
public class Role implements Serializable{

	private static final long serialVersionUID = 9919345432901098L;
	public static final String TRAVEL_ROLE_ID ="tourist";
	
	@Id
	@Column(length=20)
	private String rolename;
	
	@Column(length=40)
	private String description;

	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "roles", fetch = FetchType.LAZY)  
	private Set<User> user = new HashSet<User>();
	
	public Role(){
		
	}
	
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
}
