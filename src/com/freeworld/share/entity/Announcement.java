package com.freeworld.share.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Announcement implements Serializable {

	private static final long serialVersionUID = 8505849521755535794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	private String subject;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "type_id")
	private AnnouncementType type;

	@Column(length = 1000)
	private String content;

	@Column
	private Boolean pub;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "s_announcement_family", inverseJoinColumns = @JoinColumn(name = "family_id", referencedColumnName = "id"), joinColumns = @JoinColumn(name = "announcement_id", referencedColumnName = "id"))
	private Set<Family> families = new HashSet<>();

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "s_announcement_teacher", inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"), joinColumns = @JoinColumn(name = "announcement_id", referencedColumnName = "id"))
	private Set<Teacher> teachers = new HashSet<>();
	
	@PrePersist
	private void prePersist(){
		createdate = new Date();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Boolean getPub() {
		return pub;
	}

	public void setPub(Boolean pub) {
		this.pub = pub;
	}

	public AnnouncementType getType() {
		return type;
	}

	public void setType(AnnouncementType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Family> getFamilies() {
		return families;
	}

	public void setFamilies(Set<Family> families) {
		this.families = families;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
