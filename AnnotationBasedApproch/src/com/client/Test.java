package com.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Student;

public class Test {
	static Scanner sc = new Scanner(System.in);

	public static void setData(Session session) {
		Student s = new Student();
		System.out.println("Enter Student ID to Register");
		s.setSid(sc.nextInt());
		System.out.println("Enter Student Name");
		s.setSname(sc.next() + sc.nextLine());
		System.out.println("Enter Student Address ");
		s.setAddr(sc.next() + sc.nextLine());
		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Data has been Saved in our Database");
		 getData(session);
	}

	public static void getUpdateName(Session session) {
		System.out.println("Enter ID to update data");
		int id = sc.nextInt();
		Student stu = session.get(Student.class, id);
		System.out.println("Enter Updated Name ");
		stu.setSname(sc.next() + sc.nextLine());
		session.saveOrUpdate(stu);
		session.beginTransaction().commit();
		System.out.println("Data has been Updated in Database");
		 getData(session);
	}
	public static void getUpdateAddress(Session session) {
		System.out.println("Enter ID to update data");
		int id = sc.nextInt();
		Student stu = session.get(Student.class, id);
		System.out.println("Enter Updated Address ");
		stu.setAddr(sc.next() + sc.nextLine());
		session.saveOrUpdate(stu);
		session.beginTransaction().commit();
		System.out.println("Data has been Updated in Database");
        getData(session);
	}

	public static void deleteData(Session session) {
		System.out.println("Enter ID you want to delete from Database");
		int id = sc.nextInt();
		Student stu = session.get(Student.class, id);
		session.delete(stu);
		session.beginTransaction().commit();
		System.out.println("Data has been Deleted from Database");
	}

	public static void getData(Session session) {
		System.out.println("Enter ID to View Details");
		int id = sc.nextInt();
		Student stu = session.load(Student.class, id);
		//Student stu = session.get(Student.class, id);
		System.out.println("Student Name: " + stu.getSname());
		System.out.println("Student ID: " + stu.getSid());
		System.out.println("Student Address: "+stu.getAddr());

	}

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		getData(session);
		

	}

}
