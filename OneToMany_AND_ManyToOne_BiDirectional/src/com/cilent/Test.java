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
		Department RAD=new Department();
		RAD.setDid(102);
		RAD.setDname("R&D");
		Employee A = new Employee();
		A.setEid(1);
		A.setEname("Manik");
		Employee B = new Employee();
		B.setEid(2);
		B.setEname("Sajnik");
		HR.getE().add(A);
		HR.getE().add(B);
		A.setDep(HR);
		B.setDep(RAD);
		session.save(A);
		session.save(B);
		session.save(HR);
		session.save(RAD);
		session.beginTransaction().commit();
		System.out.println("Data has been saved in our database");
	}

	private static void getDepartmentData(Session session) {
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

	private static void getEmployeeData(Session session) {
		System.out.println("Enter Employee ID ");
		int id = sc.nextInt();
		Employee e = session.get(Employee.class, id);
		System.out.println("Employee Name: " + e.getEname());
		System.out.println("Employee Id: " + e.getEid());
		System.out.println("Department Name: " + e.getDep().getDname());
		System.out.println("Department ID: " + e.getDep().getDid());

	}
	private static void updateEmployeeName(Session session) {
		System.out.println("Enter Employee ID ");
			int id = sc.nextInt();
			Employee e = session.get(Employee.class, id);
			System.out.println("Enter updated Name");
			e.setEname(sc.next()+sc.nextLine());
			session.saveOrUpdate(e);
			session.beginTransaction().commit();
	}
	
	private static void updateDepartmentName(Session session) {
		System.out.println("Enter Department ID ");
		int id = sc.nextInt();
		Department e = session.get(Department.class, id);
		System.out.println("Enter updated Name");
		e.setDname(sc.next()+sc.nextLine());
		session.saveOrUpdate(e);
		session.beginTransaction().commit();
	}
	private static void deleteEmployee(Session session) {
		System.out.println("Enter Department ID of resp. Employee ");
		int id = sc.nextInt();
		Department d = session.get(Department.class, id);
		System.out.println("Enter Employee ID to delete from database");
		int eid = sc.nextInt();
		Employee e = session.get(Employee.class, eid);
		d.getE().remove(e);
		session.saveOrUpdate(d);
		session.beginTransaction().commit();
	}

	private static void deleteDepartment(Session session) {
		System.out.println("Enter Department ID to delete from database ");
		int id = sc.nextInt();
		Department d = session.get(Department.class, id);
		session.delete(d);
		session.beginTransaction().commit();
	}
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//setData(session);
		getDepartmentData(session);
		 //getEmployeeData(session);
		 //updateEmployeeName(session);
		 //updateDepartmentName(session);
		//deleteDepartment(session);
		// deleteEmployee(session);
		// getDepartmentData(session);
	}

	

	

	

}
