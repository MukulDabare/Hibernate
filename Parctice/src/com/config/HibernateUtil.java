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



public class HibernateUtil {

	private static SessionFactory sf;
	private static StandardServiceRegistry registry;

	public static SessionFactory getSessionFactory() {

		try {
			if (sf==null) {
				Map<String, String> map = new HashMap<String, String>();
				// Connection mapping Command
				map.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				map.put(Environment.URL, "jdbc:mysql://localhost:3306/cbapi1");
				map.put(Environment.USER, "root");
				map.put(Environment.PASS, "root");
				// Hibernate mapping Commands
				map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				map.put(Environment.HBM2DDL_AUTO, "update");
				map.put(Environment.SHOW_SQL, "true");
				// Create object of StandardServiceRegistry
				registry = new StandardServiceRegistryBuilder().applySettings(map).build();
				// create object of MetadataSources
				MetadataSources mds = new MetadataSources(registry);
				//entity class Mapping
				mds.addAnnotatedClass(Employee.class);
				// create object of Metadata
				Metadata md = mds.getMetadataBuilder().build();
				// Create Object of SessionFactory
				sf = md.getSessionFactoryBuilder().build();
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return sf;
	}
}
