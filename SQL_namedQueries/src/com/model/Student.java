package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;


@NamedNativeQueries({
	@NamedNativeQuery (name= "getAllData", query="select * from Student",resultClass=Student.class),
	@NamedNativeQuery (name= "getSingleData", query="select * from Student where id=?",resultClass=Student.class),
	@NamedNativeQuery (name= "deleteData", query="delete from Student where id=?",resultClass=Student.class),
	@NamedNativeQuery (name= "insertData", query="insert into Student values(?,?)",resultClass=Student.class),
    @NamedNativeQuery (name= "updateData", query="update Student set name=? where id=? ",resultClass=Student.class)
})
@Entity
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
