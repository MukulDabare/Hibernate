package com.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Employee;
import com.model.Stu;

public class HibernateUtil {

//	private static SessionFactory sf;
//	private static StandardServiceRegistry registry;
//
//	public static SessionFactory getSessionFactoryTest() {
//
//		try {
//			if (sf==null) {
//				Map<String, String> map = new HashMap<String, String>();
//				// Connection mapping Command
//				map.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//				map.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
//				map.put(Environment.USER, "root");
//				map.put(Environment.PASS, "root");
//				// Hibernate mapping Commands
//				map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//				map.put(Environment.HBM2DDL_AUTO, "update");
//				map.put(Environment.SHOW_SQL, "true");
//				// Create object of StandardServiceRegistry
//				registry = new StandardServiceRegistryBuilder().applySettings(map).build();
//				// create object of MetadataSources
//				MetadataSources mds = new MetadataSources(registry);
//				//entity class Mapping
//				mds.addAnnotatedClass(Stu.class);
//				// create object of Metadata
//				Metadata md = mds.getMetadataBuilder().build();
//				// Create Object of SessionFactory
//				sf = md.getSessionFactoryBuilder().build();
//				
//			}
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		return sf;
//	}
//	
//	public static SessionFactory getSessionFactoryEmp() {
//
//		try {
//			if (sf==null) {
//				Map<String, String> map = new HashMap<String, String>();
//				// Connection mapping Command
//				map.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//				map.put(Environment.URL, "jdbc:mysql://localhost:3306/emp");
//				map.put(Environment.USER, "root");
//				map.put(Environment.PASS, "root");
//				// Hibernate mapping Commands
//				map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//				map.put(Environment.HBM2DDL_AUTO, "update");
//				map.put(Environment.SHOW_SQL, "true");
//				// Create object of StandardServiceRegistry
//				registry = new StandardServiceRegistryBuilder().applySettings(map).build();
//				// create object of MetadataSources
//				MetadataSources mds = new MetadataSources(registry);
//				//entity class Mapping
//				mds.addAnnotatedClass(Employee.class);
//				// create object of Metadata
//				Metadata md = mds.getMetadataBuilder().build();
//				// Create Object of SessionFactory
//				sf = md.getSessionFactoryBuilder().build();
//				
//			}
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		return sf;
//	}
	
	public static SessionFactory getSessionFactory(String databasename)
	{
		Configuration cfg=new Configuration();
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/"+ databasename);
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		cfg.setProperty("show_sql", "true");
		if (databasename =="emp")
		{
			cfg.addAnnotatedClass(Employee.class);
	
		}
		if(databasename=="test")
		{
			cfg.addAnnotatedClass(Stu.class);

		}
		
		
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
		
	}
}
