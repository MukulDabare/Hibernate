package com.cilent;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.config.HibernateUtil;
import com.model.Department;
import com.model.Employee;

public class Test {
	static Scanner sc = new Scanner(System.in);

	private static void setData(Session session) {
		Department HR = new Department();
		HR.setDid(101);
		HR.setDname("HR");

		Employee A = new Employee();
		A.setEid(1);
		A.setEname("Manik");

		Employee B = new Employee();
		B.setEid(2);
		B.setEname("Sajnik");
		HR.getE().add(A);
		HR.getE().add(B);
		session.save(HR);
		session.beginTransaction().commit();
	}
	private static void getData(Session session) {
		System.out.println("Enter Department ID ");
		int id = sc.nextInt();
		Department d = session.get(Department.class, id);
		System.out.println("Department Name: " + d.getDname());
		System.out.println("Department Id: " + d.getDid());
		d.getE().forEach((e) -> {
			System.out.println("Employee Name: " + e.getEname());
			System.out.println("Employee Id: " + e.getEid());
		});
	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		// setData(session);
		getData(session);

	}

	

}
