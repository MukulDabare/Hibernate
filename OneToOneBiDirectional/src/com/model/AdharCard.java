package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class AdharCard {
	@Id
	private long adharNo;
	private String adharName;
	@OneToOne (cascade = CascadeType.ALL)
	private Person p;
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public long getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}
	public String getAdharName() {
		return adharName;
	}
	public void setAdharName(String adharName) {
		this.adharName = adharName;
	}
	

}
