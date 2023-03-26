package com.model;

import javax.persistence.Entity;

@Entity
public class Karvenagar extends Cjc {

	private String regularBatch;

	public String getRegularBatch() {
		return regularBatch;
	}

	public void setRegularBatch(String regularBatch) {
		this.regularBatch = regularBatch;
	}
	
}
