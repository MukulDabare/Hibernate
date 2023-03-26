package com.client;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
	static Scanner sc = new Scanner(System.in);

	private static void setData(Session session) {
		// Can not be done in case of Criteria Builder API
	}

	private static void getAllData(Session session) {
		// select * from student
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.select(root);
		Query<Student> query = session.createQuery(cq);
		List<Student> list = query.getResultList();
		list.forEach(s -> {
			System.out.println("Student Name: " + s.getName());
			System.out.println("Student Id: " + s.getId());
			System.out.println("Student PSN: " + s.getPsn());
		});
	}

	private static void getSingleData(Session session) {
		// select * from student where id=1;
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		System.out.println("Enter Student Id ");
		cq.where(cb.equal(root.get("id"), sc.nextInt()));
		Query<Student> query = session.createQuery(cq);
		Student s = query.getSingleResult();
		System.out.println("Student Name: " + s.getName());
		System.out.println("Student Id: " + s.getId());
		System.out.println("Student PSN: " + s.getPsn());
	}

	private static void getNames(Session session) {
		// select name from student
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Student> root = cq.from(Student.class);
		cq.select(root.get("name"));
		Query<String> query = session.createQuery(cq);
		List<String> list = query.getResultList();
		list.forEach(sn -> {
			System.out.println("Student Name: " + sn);

		});
	}

	private static void updateName(Session session) {
		// update Student set name='' where id=2;
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaUpdate<Student> cu = cb.createCriteriaUpdate(Student.class);
		Root<Student> root = cu.from(Student.class);
		System.out.println("Enter Student Id to Update his Name");
		int id = sc.nextInt();
		System.out.println("Enter Updated Name");
		cu.set(root.get("name"), sc.next() + sc.nextLine());
		cu.where(cb.equal(root.get("id"), id));
		Query<Student> query = session.createQuery(cu);
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		getSingleData(session);
	}

	private static void deleteData(Session session) {
		// delete from Student where id=1;
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<Student> cd = cb.createCriteriaDelete(Student.class);
		Root<Student> root = cd.from(Student.class);
		System.out.println("Enter Student Id to Delete from our Database");
		int id = sc.nextInt();
		cd.where(cb.equal(root.get("id"), id));
		Query<Student> query = session.createQuery(cd);
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		getAllData(session);
	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		   getAllData(session);
		 //getSingleData(session);
		// getNames(session);
	   //updateName(session);
	  // deleteData(session);

	}

}
