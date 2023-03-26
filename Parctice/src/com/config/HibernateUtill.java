package com.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.Employee;

public class HibernateUtill {
  private static SessionFactory sf;
	public static SessionFactory getSessionFactory() {
		try {
			if (sf==null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				map.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
				map.put(Environment.USER, "root");
				map.put(Environment.PASS, "root");
				map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				map.put(Environment.HBM2DDL_AUTO, "update");
				map.put(Environment.SHOW_SQL, "true");
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(map).build();
				MetadataSources mds = new MetadataSources(registry);
				mds.addAnnotatedClass(Employee.class);
				Metadata md = mds.getMetadataBuilder().build();
				 sf = md.getSessionFactoryBuilder().build();
				
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return sf;
	}
	
     
	
}
