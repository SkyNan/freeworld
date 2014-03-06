package com.freeworld.share.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="s_address")
public class Address implements Serializable{

	private static final long serialVersionUID = -8114321621757601593L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(length=20,nullable=false)
	private String country;
	
	@Column(length=20,nullable=false)
	private String province;
	
	@Column(length=20,nullable=false)
	private String area;

	@Column(length=40,nullable=true)
	private String addition;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="family_id")
	private Family family;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}
	
	
}
