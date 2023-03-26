package com.cilent;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Course;
import com.model.Student;

public class Test {
	static Scanner sc = new Scanner(System.in);

	private static void setData(Session session) {
		Course c1=new Course();
		c1.setCid(101);
        c1.setCname("Java");
        Course c2=new Course();
		c2.setCid(102);
        c2.setCname("Phython");
        Student A = new Student();
		A.setSid(1);
		A.setSname("Manik");
		A.getC().add(c1);
		A.getC().add(c2);
		c1.getS().add(A);
		c2.getS().add(A);
		Student  B = new Student();
		B.setSid(2);
		B.setSname("Sajnik");
		B.getC().add(c2);
		c2.getS().add(B);
		
        session.save(c1);
        session.save(c2);

		session.save(A);
		session.save(B);
		session.beginTransaction().commit();
		System.out.println("Data has been saved in our database");
	}
	private static void getStudentData(Session session) {
		System.out.println("Enter Student ID ");
		int id = sc.nextInt();
		Student s = session.get(Student.class, id);
		System.out.println("Student Name: "+s.getSname());
		System.out.println("Student Id: "+s.getSid());
		System.out.println("Student Enrolled in following Courses:");
       s.getC().forEach((c)->{
    	   System.out.println("         "+c.getCname()+"  ("+c.getCid()+")");
    	 
       });
		
		
	}
	private static void getCourseData(Session session) {
		System.out.println("Enter Course ID ");
		int id = sc.nextInt();
		Course c = session.get(Course.class, id);
		System.out.println("Course Name: "+c.getCname());
		System.out.println("Course Id: "+c.getCid());
		System.out.println("Students Enrolled in "+c.getCname()+" are as follows:");
		c.getS().forEach((s)->{
			System.out.println("         "+s.getSname()+"  ("+s.getSid()+")");
				
		});
	}

//	  private static void deleteCourseData(Session session) {
//		System.out.println("Enter Student ID ");
//		int id = sc.nextInt();
//		Student s = session.get(Student.class, id);
//		System.out.println("Enter Course ID you want to delete");
//		int cid=sc.nextInt();
//		Course c = session.get(Course.class, cid);
//
//		System.out.println("Data has been deleted from our database");
//
//	}
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//setData(session);
		//getStudentData(session);
		//getCourseData(session);
		//deleteCourseData(session);
		

	}
	

	

}
