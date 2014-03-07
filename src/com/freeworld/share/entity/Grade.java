package com.freeworld.share.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	private String grade;

	@Column(length = 30, nullable = false)
	private String clas;

	@Column(length = 30, nullable = false)
	private String level;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "s_gradeteacher", inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"), joinColumns = @JoinColumn(name = "grade_id", referencedColumnName = "id"))
	private Set<Teacher> teachers = new HashSet<>();

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "s_gradefamily", inverseJoinColumns = @JoinColumn(name = "family_id", referencedColumnName = "id"), joinColumns = @JoinColumn(name = "grade_id", referencedColumnName = "id"))
	private Set<Family> families = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Family> getStudents() {
		return getFamilies();
	}

	public void setStudents(Set<Family> families) {
		this.setFamilies(families);
	}

	public Set<Family> getFamilies() {
		return families;
	}

	public void setFamilies(Set<Family> families) {
		this.families = families;
	}
}
