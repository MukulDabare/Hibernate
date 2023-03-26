package com.client;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Employee;

public class TestE {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//setData(session);
		//updateName(session);
		getAllData(session);
		deleteData(session);
		
	}

	private static void deleteData(Session session) {
		//delete from Employee where id=;
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaUpdate<Employee> cd = cb.createCriteriaUpdate(Employee.class);
		Root<Employee> root = cd.from(Employee.class);
		System.out.println("Enter Employee Id to delete its data from database");
		int id=sc.nextInt();
		cd.where(cb.equal(root.get("eid"), id));
		Query<Employee> query = session.createQuery(cd);
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		getAllData(session);
	}

	private static void getAllData(Session session) {
		//select * from Employee
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);//select 
		Root<Employee> root = cq.from(Employee.class);//from
		cq.select(root);//class name
		Query<Employee> query = session.createQuery(cq);
		List<Employee> list = query.getResultList();
		list.forEach(emp->{
			System.out.println("Employee Name: "+emp.getEname());
			System.out.println("Employee Id: "+emp.getEid());
		});
		
	}

	private static void updateName(Session session) {
		//update Employee set ename='' where id=1;
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaUpdate<Employee> cu = cb.createCriteriaUpdate(Employee.class);
		Root<Employee> root = cu.from(Employee.class);
		
		System.out.println("Enter Employee Id to Update his name");
		int id=sc.nextInt();
		System.out.println("Enter Updated Name");
		String name=sc.next()+sc.nextLine();
		cu.set(root.get("ename"), name);
		cu.where(cb.equal(root.get("eid"), id));
		Query<Employee> query = session.createQuery(cu);//creating programmed query.
		Transaction tx = session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		getAllData(session);
	}

	private static void setData(Session session) {
		Employee emp = new Employee();
		emp.setEid(1);
		emp.setDeg("CEO");
		emp.setEname("Amrit");
		emp.setSalary(250000f);
		session.save(emp);
		session.beginTransaction().commit();
		System.out.println("Data has been saved in our database");
	}

}
