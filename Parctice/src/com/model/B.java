package com.model;

public class B {

	int bid;
	String bname;
	 A a;
	public B(int bid, String bname) {
		this.bid = bid;
		this.bname = bname;
	}
	public B(A a)
	{
		this.a=a;
	}
	public int getBid() {
		return bid;
	}
	
	public String getBname() {
		return bname;
	}
	
	public A getA() {
		return a;
	}
	
	
}
