package com.freeworld.share.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="s_userinformation")
public class UserInformation implements Serializable{
	
	private static final long serialVersionUID = 9114408386649588988L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(mappedBy="information",cascade=CascadeType.REFRESH)
	private User user;
	
	@OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="address_id")
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
