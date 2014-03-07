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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "s_family")
public class Family implements Serializable{

	private static final long serialVersionUID = -4674115304359235301L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=20)
	private String fathername;
	
	@Column(length=20)
	private String father_phone;
	
	@Column
	private Boolean father_get_message;
	
	@Column(length=20)
	private String mothername;
	
	@Column(length=20)
	private String mother_phone;
	
	@Column
	private Boolean mother_get_message;
	
	@Column(length=30)
	private String email;
	
	@OneToOne(cascade= CascadeType.REFRESH)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="family")
	private Set<Address> address = new HashSet<>();

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="families")
	private HashSet<Grade> grade = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.REFRESH,mappedBy="families")
	private Set<Announcement> announces = new HashSet<Announcement>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getMother_phone() {
		return mother_phone;
	}

	public void setMother_phone(String mother_phone) {
		this.mother_phone = mother_phone;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public String getFather_phone() {
		return father_phone;
	}

	public void setFather_phone(String father_phone) {
		this.father_phone = father_phone;
	}

	public Boolean isFather_get_message() {
		return father_get_message;
	}

	public void setFather_get_message(Boolean father_get_message) {
		this.father_get_message = father_get_message;
	}

	public Boolean isMother_get_message() {
		return mother_get_message;
	}

	public void setMother_get_message(Boolean mother_get_message) {
		this.mother_get_message = mother_get_message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
