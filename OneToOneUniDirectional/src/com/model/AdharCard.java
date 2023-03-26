package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class AdharCard {
	@Id
	private long adharNo;
	private String adharName;
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
