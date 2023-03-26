package com.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Employee;
import com.model.Stu;

public class Test {
	static Scanner sc=new Scanner(System.in);
	private static void setData(Session session) {
		Stu s=new Stu();
		System.out.println("Enter Student Id");
		s.setId(sc.nextInt());
		System.out.println("Enter Student Name");
		s.setName(sc.next());
		System.out.println("Enter Student Personal Security Number");
		s.setPsn(sc.nextInt());
		session.save(s);
		session.beginTransaction().commit();
		session.close();
		System.out.println("Data Saved");
	}
	private static void setEmployee(Session session) {
		session.clear();
		Employee e=new Employee();
		System.out.println("Enter Employee Name");
		e.setEname(sc.next());
		System.out.println("Enter Employee Id: ");
		e.setEid(sc.nextInt());
		session.save(e);
		session.beginTransaction().commit();
		session.close();
		System.out.println("Data Saved");
	}
	private static void getData(Session session) {
		System.out.println("Enter Student ID to view Data");
		int id=sc.nextInt();
		Stu stu = session.get(Stu.class, id);
		System.out.println("Student Name: "+stu.getName());
		System.out.println("Student ID: "+stu.getId());
	}
	private static void updateName(Session session) {
		System.out.println("Enter Student ID to Update Name");
		int id=sc.nextInt();
		Stu stu = session.get(Stu.class, id);
		System.out.println("Enter Name to Update");
		stu.setName(sc.next()+sc.nextLine());
		session.saveOrUpdate(stu);
		session.beginTransaction().commit();
		getData(session);
	}
	private static void deleteData(Session session) {
		System.out.println("Enter Student ID to Delete from Database");
		int id=sc.nextInt();
		Stu stu = session.get(Stu.class, id);
		session.delete(stu);
		session.beginTransaction().commit();
		System.out.println("Data has been deleted from our database");
	}
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory("test");
		Session session = sf.openSession();
		setData(session);
		
		SessionFactory sf2 = HibernateUtil.getSessionFactory("emp");
		Session session2 = sf2.openSession();
		setEmployee(session2);
	
	}
	
	
	

	

}
