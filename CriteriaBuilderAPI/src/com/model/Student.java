package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name ="Student")
public class Student {
    @Id
    @Column (name ="sid")
	private int id;
    @Column (name="sname", unique = true)
	private String name;
    @Column (name="PSN", unique = true)
    private int psn;
   
    public int getPsn() {
		return psn;
	}
	public void setPsn(int psn) {
		this.psn = psn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
