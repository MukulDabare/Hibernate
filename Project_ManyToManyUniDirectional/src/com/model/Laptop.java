package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@NamedQuery (name= "getAllLaptops", query="from Laptop")
public class Laptop {
	@Id
	private int lid;
	private int lram;
	private String lname;
	private float lprice;
	private float lweight;
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Mobile> m=new HashSet<Mobile>();
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Set<Mobile> getM() {
		return m;
	}
	public void setM(Set<Mobile> m) {
		this.m = m;
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
