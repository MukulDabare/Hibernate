package com.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
		//updateName(session);

	}

	private static void updateName(Session session) {
		session.clear();
		Transaction tx = session.beginTransaction();
		System.out.println("Enter Student Id from Akurdi Branch to update his name");
		int aid= sc.nextInt();
		
		Akurdi a = session.get(Akurdi.class, aid);
		System.out.println("Enter Updated Name");
		a.setSname(sc.next()+sc.nextLine());
		tx.commit();
		System.out.println("Name has been Updated");
	}

	private static void getData(Session session) {
		System.out.println("Enter Student Id from Akurdi Branch");
		int aid= sc.nextInt();
		Akurdi a = session.get(Akurdi.class, aid);
		System.out.println("Student Name: "+a.getSname());
		System.out.println("Student Id: "+a.getSid());
		System.out.println("Student Enrolled to course: "+a.getCourseName());
		System.out.println("Batch Mode: "+a.getWeekendBatch());
		System.out.println("Enter Student Id from Karvenagar Branch");
		int kid= sc.nextInt();
		
		Karvenagar k = session.get(Karvenagar.class, kid);
		System.out.println("Student Name: "+k.getSname());
		System.out.println("Student Id: "+k.getSid());
		System.out.println("Student Enrolled to course: "+k.getCourseName());
		System.out.println("Batch Mode: "+k.getRegularBatch());
	}

	private static void setData(Session session) {
		session.clear();
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
		
		Cjc c=new Cjc();
		c.setSid(3);
		c.setSname("Manik");
		Cjc c2=new Cjc();
		c2.setSid(4);
		c2.setSname("Sajnik");
		session.save(c2);
		session.save(c);
		session.save(a);	
		session.save(k);
		session.beginTransaction().commit();
		System.out.println("Data  has been saved in our database");
	}
	

	

}
