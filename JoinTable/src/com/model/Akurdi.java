package com.model;

import javax.persistence.Entity;

@Entity
public class Akurdi extends Cjc	 {

	private String weekendBatch;

	public String getWeekendBatch() {
		return weekendBatch;
	}

	public void setWeekendBatch(String weekendBatch) {
		this.weekendBatch = weekendBatch;
	}
}
