package com.client;

import java.util.List;
import java.util.Scanner;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
	static Scanner sc = new Scanner(System.in);

	private static void setData(Session session) {
		
		ProcedureCall call = session.createStoredProcedureCall("setData");
		call.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
		System.out.println("Enter Student Id");
		call.setParameter("id", sc.nextInt());
		call.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);

		System.out.println("Enter Student Name");
		call.setParameter("name", sc.next() + sc.nextLine());
		call.execute();
		System.out.println("Data Saved");
	}

	private static void getAllData(Session session) {
		ProcedureCall call = session.createStoredProcedureCall("getData", Student.class);
		List<Student> list = call.getResultList();
		call.execute();
		list.forEach((stu) -> {
			System.out.println("Student Name: " + stu.getName());
			System.out.println("Student ID: " + stu.getId());
		});

	}

	private static void getSingleData(Session session) {
		ProcedureCall call = session.createStoredProcedureCall("getSingleData", Student.class);
		call.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
		System.out.println("Enter Student Id");
		call.setParameter("id", sc.nextInt());
		Student stu = (Student) call.getSingleResult();
		call.execute();
		System.out.println("Student Name: " + stu.getName());
		System.out.println("Student ID: " + stu.getId());

	}

	private static void updateName(Session session) {

		ProcedureCall call = session.createStoredProcedureCall("updateName");
		call.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
		System.out.println("Enter Student ID to Update Name");
		call.setParameter("id", sc.nextInt());
		call.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
		System.out.println("Enter Name to Update");
		call.setParameter("name", sc.next() + sc.nextLine());
		call.execute();
		getSingleData(session);
		getAllData(session);
	}

	private static void deleteData(Session session) {

		ProcedureCall call = session.createStoredProcedureCall("deleteData");
		call.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
		System.out.println("Enter Student ID to Delete from Database");
		call.setParameter("id", sc.nextInt());
		call.execute();
		System.out.println("Data has been deleted from our database");
		getAllData(session);
	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		// setData(session);
		// getAllData(session);
		// updateName(session);
		// deleteData(session);
		// getSingleData(session);

	}

}
