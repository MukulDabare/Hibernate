package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@NamedQuery(name = "getAllLaptops", query = "from Laptop")
public class Laptop {
	@Id
	private int lid;
	private int lram;
    private String lname;
	private float lprice;
	private float lweight;
	@OneToMany (cascade = CascadeType.ALL)
    private Mobile mobile;

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getLram() {
		return lram;
	}

	public void setLram(int lram) {
		this.lram = lram;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public float getLprice() {
		return lprice;
	}

	public void setLprice(float lprice) {
		this.lprice = lprice;
	}

	public float getLweight() {
		return lweight;
	}

	public void setLweight(float lweight) {
		this.lweight = lweight;
	}

}
