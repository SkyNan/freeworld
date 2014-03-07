package com.freeworld.share.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity(name="s_user")
public class User implements Serializable{

	private static final long serialVersionUID = -7545626386946040072L;

	@Id
	@Column(length = 30)
	private String id; //鐢ㄦ埛鐧诲綍鎵�敤璐﹀彿
	
	@Column(length = 256,nullable = false)
	private String password; //鐢ㄦ埛鐧诲綍鎵�敤瀵嗙爜
	
	@ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)  
    @JoinTable(name = "s_userrole", inverseJoinColumns = @JoinColumn(name = "rolename"), joinColumns = @JoinColumn(name = "id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToOne(mappedBy="user")
	private Family family;
	
	@OneToOne(mappedBy="user")
	private Teacher teacher;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user",fetch = FetchType.LAZY)
	private Set<Announcement> announcements = new HashSet<>();
	
	@Transient
	private String passwordAgain;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(Set<Announcement> announcements) {
		this.announcements = announcements;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
