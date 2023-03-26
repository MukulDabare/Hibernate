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
		A.setDep(HR);
		Employee B = new Employee();
		B.setEid(2);
		B.setEname("Sajnik");
		B.setDep(HR);

		session.save(A);
		session.save(B);
		session.beginTransaction().commit();
		System.out.println("Data has been saved in our database");
	}
	private static void getData(Session session) {
		System.out.println("Enter Employee ID ");
		int id = sc.nextInt();
		Employee e = session.get(Employee.class, id);
		System.out.println("Employee Name: "+e.getEname());
		System.out.println("Employee Id: "+e.getEid());
        System.out.println("Department Name: " +e.getDep().getDname());
		System.out.println("Department Id: " + e.getDep().getDid());
		
	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//setData(session);
		getData(session);

	}

	

}
