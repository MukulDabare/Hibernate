package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({
	@NamedQuery (name= "getAllData", query="from Student"),
	@NamedQuery (name= "getSingleData", query="from Student where id=?"),
	@NamedQuery (name= "deleteData", query="delete Student where id=?"),
	@NamedQuery (name= "updateData", query="update Student set name=? where id=? ")
})
public class Student {
    @Id
    private int id;
	private String name;
  
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
