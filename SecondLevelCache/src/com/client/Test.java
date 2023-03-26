package com.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
	
	static Scanner sc=new Scanner(System.in);
	private static void setData(Session session) {
		Student s=new Student();
		System.out.println("Enter Student Id");
		s.setId(sc.nextInt());
		System.out.println("Enter Student Name");
		s.setName(sc.next());
		System.out.println("Enter Student Personal Security Number");
		s.setPsn(sc.nextInt());
		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Data Saved");
	}
	private static void getData(SessionFactory sf) {
		Session session = sf.openSession();
		System.out.println("Enter Student ID to view Data");
		int id=sc.nextInt();

			Student stu = session.get(Student.class, id);
			System.out.println("Student Name: " + stu.getName());
			System.out.println("Student ID: " + stu.getId());
			Student stu2 = session.get(Student.class, id);
			System.out.println("Student Name: " + stu2.getName());
			System.out.println("Student ID: " + stu2.getId());
			Student stu3 = session.get(Student.class, id);
			System.out.println("Student Name: " + stu3.getName());
			System.out.println("Student ID: " + stu3.getId());
			Session session2 = sf.openSession();
			Student stu4 = session2.get(Student.class, id);
			System.out.println("Student Name: " + stu4.getName());
			System.out.println("Student ID: " + stu4.getId());
			Student stu5 = session2.get(Student.class, id);
			System.out.println("Student Name: " + stu5.getName());
			System.out.println("Student ID: " + stu5.getId());
	}


	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		getData(sf);
		//setData(session);
        //updateName(session);
		//deleteData(session);
		
		
		
	}



	
	
	

	

}
