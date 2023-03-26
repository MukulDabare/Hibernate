package com.client;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
	static Scanner sc = new Scanner(System.in);

	private static void setData(Session session) {
		Student s = new Student();
		System.out.println("Enter Student Name");
		s.setName(sc.next());
		System.out.println("Enter Student ID");
		s.setId(sc.nextInt());
		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Data Saved");
	}

	private static void getAllData(Session session) {
		String hql = "from Student";
		Query query = session.createQuery(hql);
		List<Student> students = query.getResultList();
		students.forEach((stu) -> {
			System.out.println("Student Name: " + stu.getName());
			System.out.println("Student ID: " + stu.getId());
		});

	}

	private static void getSingleData(Session session) {
		String hql = "from Student where id=?";// ?=positional parameter
		// String hql="from Student where id=:id";//:name =Named parameter
		Query query = session.createQuery(hql);
		System.out.println("Enter Student Id for details");
		query.setParameter(0, sc.nextInt());
		// query.setParameter("id", sc.nextInt()); for Named parameter
		Student s = (Student) query.getSingleResult();
		System.out.println("Student Name: " + s.getName());
		System.out.println("Student ID: " + s.getId());

	}

	private static void updateName(Session session) {

		String hql = "update Student set name=:nm where id=:roll";
		Query<Student> query = session.createQuery(hql);
		System.out.println("Enter Student ID to Update Name");
		query.setParameter("roll", sc.nextInt());
		System.out.println("Enter Updated Name");
		query.setParameter("nm", sc.next() + sc.nextLine());

		System.out.println("Data has been updated in our database");
		getSingleData(session);
	}

	private static void deleteData(Session session) {
		String hql = "delete Student where id=:roll";
		Query<Student> query = session.createQuery(hql);
		System.out.println("Enter Student ID to Delete from Database");
		query.setParameter("roll", sc.nextInt());
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		System.out.println("Data has been deleted from our database");
		getAllData(session);
	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		// setData(session);
		// getAllData(session);
		// getSingleData(session);
		// updateName(session);
		deleteData(session);

	}

}
