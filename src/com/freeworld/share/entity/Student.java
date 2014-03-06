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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "s_student")
public class Student implements Serializable{

	private static final long serialVersionUID = -3201120074490678381L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(length = 20)
	private String stuno;
	
	@Column(length = 30)
	private String school;
	
	@Column(length = 15)
	private String grade;
	
	@Column(length = 15)
	private String clas;
	
	@Column(length = 15)
	private String level;
	
	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "students", fetch = FetchType.LAZY)  
	private Set<Teacher> teachers = new HashSet<>();
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="family_id")
	private Family family;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}
}
