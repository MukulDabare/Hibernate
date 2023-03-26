package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@NamedQuery (name= "getAllMobile", query="from Mobile")
public class Mobile {
	@Id
	private int mid;
	
	private int mram;
	private String mname;
	private float mprice;
	private float mweight;
	public int getMram() {
		return mram;
	}
	public void setMram(int mram) {
		this.mram = mram;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public float getMprice() {
		return mprice;
	}
	public void setMprice(float mprice) {
		this.mprice = mprice;
	}
	public float getMweight() {
		return mweight;
	}
	public void setMweight(float mweight) {
		this.mweight = mweight;
	} 
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}

}
