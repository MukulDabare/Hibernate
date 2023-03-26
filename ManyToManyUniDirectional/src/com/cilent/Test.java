package com.cilent;

import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
        
		Student s1 = new Student();
		s1.setSid(1);
		s1.setSname("Manik");
		s1.getC().add(c1);
		s1.getC().add(c2);
		Student  s2 = new Student();
		s2.setSid(2);
		s2.setSname("Sajnik");
		s2.getC().add(c2);
		
        session.save(c1);
        session.save(c2);

		session.save(s1);
		session.save(s2);
		session.beginTransaction().commit();
		System.out.println("Data has been saved in our database");
	}
	private static void getData(Session session) {
		System.out.println("Enter Student ID ");
		int id = sc.nextInt();
		Student s = session.get(Student.class, id);
		System.out.println("Student Name: "+s.getSname());
		System.out.println("Student Id: "+s.getSid());
		System.out.println("Student Enrolled in following Courses:");
       s.getC().forEach((c)->{
    	   System.out.println("         "+c.getCname()+"("+c.getCid()+")");
    	 
       });
		     
		
	}
	private static void updateCourseName(Session session) {
		session.clear();
		Transaction tx = session.beginTransaction();
		System.out.println("Enter Student ID ");
		int sid = sc.nextInt();
		Student s = session.get(Student.class, sid);
		Set<Course> c = s.getC();
		System.out.println("Enter course Id to Update its name");
		int cid=sc.nextInt();
		c.forEach((cou)->{
			if(cou.getCid()==cid)
			{
				System.out.println("Enter the Updated Course Name");
				cou.setCname(sc.next()+sc.nextLine());
				s.setC(c);
				session.saveOrUpdate(s);
			}
		});
		
		tx.commit();
		getData(session);
	}
	private static void deleteStudentData(Session session) {
		session.clear();
		Transaction tx = session.beginTransaction();
		System.out.println("Enter Student ID ");
		int sid = sc.nextInt();
		Student s = session.get(Student.class, sid);
		Set<Course> c = s.getC();
		System.out.println("Enter course Id ");
		int cid=sc.nextInt();
		c.forEach((cou)->{
			if(cou.getCid()==cid)
			{
				c.remove(cou);
				session.saveOrUpdate(s);
				System.out.println("Data has been deleted from our database");
			}
		});
		
		tx.commit();
		getData(session);
	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//setData(session);
		//getData(session);
		updateCourseName(session);
		//deleteStudentData(session);
	

	}
	
	

	

}
