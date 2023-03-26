package com.model;

public class A {
	
	int aid;
	String aname;
	B b;
	public A(int aid, String aname, B b) {
	
		this.aid = aid;
		this.aname = aname;
		this.b = b;
	}
	public int getAid() {
		return aid;
	}
	
	public String getAname() {
		return aname;
	}
	
	public B getB() {
		return b;
	}
	
	
	
}
