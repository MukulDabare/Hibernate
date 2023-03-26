package com.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;

public class TestSQL {
	static Scanner sc = new Scanner(System.in);

	private static void setData(Session session) {
		
		Query query = session.getNamedQuery("setData");
		System.out.println("Enter Student Id");
		query.setParameter(0, sc.nextInt());
		System.out.println("Enter Student Name");
		query.setParameter(1, sc.next() + sc.nextLine());
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		System.out.println("Data Saved");
		getAllData(session);
		
	}

	private static void getAllData(Session session) {
		
	NativeQuery<Student> query = session.getNamedNativeQuery("getData");
	query.getResultList().forEach(s->{
    	System.out.println("Student Name: " +s.getName());
    	System.out.println("Student Id: "+s.getId());
    });
		
	}
	private static void getSingleData(Session session) {
		Query query = session.getNamedQuery("getSingleData");
		System.out.println("Enter Student Id");
		query.setParameter(0, sc.nextInt());
		
	    Student stu = (Student) query.getSingleResult();
	    System.out.println("Student Name: " + stu.getName());
		System.out.println("Student ID: " + stu.getId());
		

	}

	private static void updateName(Session session) {

		Query query = session.getNamedQuery("updateName");
		System.out.println("Enter Student Id to update Name");
		query.setParameter(0, sc.nextInt());
		System.out.println("Enter Student Updated Name");
		query.setParameter(1, sc.next() + sc.nextLine());
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		getSingleData(session);
		
	}

	private static void deleteData(Session session) {

		Query query = session.getNamedQuery("deleteData");
		System.out.println("Enter Student Id to delete From Database");
		query.setParameter(0, sc.nextInt());
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		getAllData(session);
	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 //setData(session);
		// getAllData(session);
		// updateName(session);
		 deleteData(session);
		// getSingleData(session);

	}

}
