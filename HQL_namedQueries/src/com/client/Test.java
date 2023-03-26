package com.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
	static Scanner sc=new Scanner(System.in);
	private static void setData(Session session) {
		Student s=new Student();
		System.out.println("Enter Student ID ");
		s.setId(sc.nextInt());
		System.out.println("Enter Student Name");
		s.setName(sc.next());
        session.save(s);
		session.beginTransaction().commit();
		System.out.println("Data Saved");
	}
	private static void getSingleData(Session session) {
		System.out.println("Enter Student ID to view Data");
		Query <Student>query1 = session.getNamedQuery("getSingleData");
		query1.setParameter(0, sc.nextInt());
		Student stu= (Student) query1.getSingleResult();
		System.out.println("Student Name: "+stu.getName());
		System.out.println("Student ID: "+stu.getId());
	}
	private static void getAllData(Session session) {
		System.out.println("Enter Student ID to view Data");
		Query <Student> query1 = session.getNamedQuery("getAllData");
		
		query1.getResultList().forEach(stu->{
			System.out.println("Student Name: "+stu.getName());
			System.out.println("Student ID: "+stu.getId());
		});
		
	}
	private static void updateName(Session session) {
		session.clear();
		Query <Student> query = session.getNamedQuery("updateData");
		System.out.println("Enter Student ID to Update Name");
		query.setParameter(1, sc.nextInt());
		System.out.println("Enter Name to Update");
		query.setParameter(0, sc.next()+sc.nextLine());
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		getSingleData(session);
	}
	private static void deleteData(Session session) {
		Query <Student> query = session.getNamedQuery("deleteData");
		System.out.println("Enter Student ID to Delete from Database");
		query.setParameter(0, sc.nextInt());
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		System.out.println("Data has been deleted from our database");
		getAllData(session);
	}
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		setData(session);
    	//getAllData(session);
		//getSingleData(session);
	    //updateName(session);
		//deleteData(session);
		
		
		
	}
	
	
	

	

}
