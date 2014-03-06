package com.freeworld.share.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserInfo {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@OneToOne(mappedBy="info")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="family_id",nullable=true)
	private Family family;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="teacher_id",nullable=true)
	private Teacher teacher;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
