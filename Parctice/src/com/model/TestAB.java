package com.model;

public class TestAB {
	
	public static void main(String[] args) {
		
		B b=new B(101, "Manik");
		A a=new A(201, "Chole", b);
	
		System.out.println("\nUsing a object");
		System.out.println(a.getAid());
		System.out.println(a.getAname());
		System.out.println(a.getB().getBid());
		System.out.println(a.getB().getBname());
		System.out.println("\nUsing b object");
		System.out.println(b.getBid());
		System.out.println(b.getBname());
		b=new B(a);
		System.out.println(b.getA().getAid());
		System.out.println(b.getA().getAname());
	}

}
