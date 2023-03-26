package com.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.config.HibernateUtill;
import com.model.Employee;

public class TestAnnotationBased {
	
	public static void main(String[] args) {
		//annotationBased();
		//javaBased();
		//criteriaBuilderAPI();
		
	}

	private static void criteriaBuilderAPI() {
		SessionFactory sf = HibernateUtill.getSessionFactory();
		Session session = sf.openSession();
		CriteriaBuilder cb = sf.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		Query<Employee> query = session.createQuery(cq);
		List<Employee> list = query.getResultList();
		list.forEach(emp->{
			System.out.println("Employee Name: "+emp.getEname());
			System.out.println("Employee Id: "+emp.getEid());
		});
	}

	private static void javaBased() {
		SessionFactory sf = HibernateUtill.getSessionFactory();
		Session session = sf.openSession();
		Employee emp=new Employee();
		emp.setEid(2);
		emp.setEname("Lucifer");
		emp.setDeg("GOD");
		emp.setSalary(100000f);
		session.save(emp);
		session.beginTransaction().commit();
		System.out.println("Data saved");
	}

	private static void annotationBased() {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Manik");
		emp.setDeg("CEO");
		emp.setSalary(250000f);
		session.save(emp);
	    session.beginTransaction().commit();
	    System.out.println("Data saved");
	}

}
