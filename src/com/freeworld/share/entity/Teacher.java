package com.freeworld.share.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity(name = "s_teacher")
public class Teacher implements Serializable{

	private static final long serialVersionUID = 3204207982604986980L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)  
    @JoinTable(name = "s_teacher_student", inverseJoinColumns = @JoinColumn(name = "student_id"), joinColumns = @JoinColumn(name = "teacher_id"))
	private Set<Student> students = new HashSet<Student>();
	
	@Column(length=1000)
	private String description;
	
	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "teachers", fetch = FetchType.LAZY)
	private Set<Grade> grades = new HashSet<>();
	
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(cascade=CascadeType.REFRESH,mappedBy="teachers")
	private Set<Announcement> announces = new HashSet<Announcement>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Announcement> getAnnounces() {
		return announces;
	}

	public void setAnnounces(Set<Announcement> announces) {
		this.announces = announces;
	}
	
	
}
