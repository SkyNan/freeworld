package com.freeworld.share.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "s_teacher")
public class Teacher implements Serializable{

	private static final long serialVersionUID = 3204207982604986980L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)  
    @JoinTable(name = "s_teacher_student", inverseJoinColumns = @JoinColumn(name = "studentid"), joinColumns = @JoinColumn(name = "teacherid"))
	private Set<Student> studets = new HashSet<Student>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Student> getStudets() {
		return studets;
	}

	public void setStudets(Set<Student> studets) {
		this.studets = studets;
	}
	
	
}
