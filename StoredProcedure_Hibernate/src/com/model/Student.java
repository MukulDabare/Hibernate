package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@NamedNativeQueries ({
	@NamedNativeQuery(name= "getData", query= "{call getData()}",resultClass = Student.class),
	@NamedNativeQuery(name ="setData", query="{call setData(?, ?)}",resultClass = Student.class),
	@NamedNativeQuery(name ="updateName", query="{call updateName(?, ?)}",resultClass = Student.class),
	@NamedNativeQuery(name ="getSingleData", query="{call getSingleData(?)}",resultClass = Student.class),
	@NamedNativeQuery(name ="deleteData", query="{call deleteData(?)}",resultClass = Student.class)
                    })
@DynamicUpdate
@Table(name ="Student")
public class Student {
    @Id
  
    @Column (name ="sid")
	private int id;
    @Column (name="sname", unique = true)
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
