package com.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Akurdi;
import com.model.Cjc;
import com.model.Karvenagar;

public class Test {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//setData(session);
		getData(session);
		
		
		
	}

	private static void getData(Session session) {
		System.out.println("Enter Student Id");
		int id= sc.nextInt();
		Karvenagar ks = session.get(Karvenagar.class, id);
		System.out.println("Student Name: "+ks.getSname());
		System.out.println("Student Id: "+ ks.getSid());
		System.out.println("Ennrolled to Course: "+ks.getCourseName());
	}

	private static void setData(Session session) {
		Karvenagar k=new Karvenagar();
		k.setSname("Manik");
		k.setSid(1);
		k.setCourseName("Java");
		k.setRegularBatch("Regular");
		
		Akurdi a=new Akurdi();
		a.setSname("Sajnik");
		a.setSid(2);
		a.setWeekendBatch("Weekend");
		a.setCourseName("Java");
		session.save(a);	
		session.save(k);
		session.beginTransaction().commit();
	}
	

	

}
