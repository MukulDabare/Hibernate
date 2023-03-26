package com.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Detective;

public class TestD {
	static Scanner sc=new Scanner(System.in);
	public static  void setData(Session session)
	{
		 Detective d=new Detective();
		 System.out.println("Enter Detective ID to Register");
	     d.setDid(sc.nextInt());
	     System.out.println("Enter Detective Name");
	     d.setDname(sc.next()+ sc.nextLine());
	    session.save(d);
	    session.beginTransaction().commit();
	    System.out.println("Data has been Saved in our Database");
	    getData(session);
	}
	public static  void getUpdateData(Session session)
	{
	   System.out.println("Enter ID to update");
	   int id= sc.nextInt();
	   Detective det = session.get(Detective.class, id);
	   System.out.println("Enter Updated Name ");
	   det.setDname(sc.next()+ sc.nextLine());
	   session.saveOrUpdate(det);
	   session.beginTransaction().commit();
	   System.out.println("Data has been Updated in Database");
	   getData(session);
	}
	public static void deleteData(Session session)
	{
		System.out.println("Enter ID you want to delete from Database");
		int id= sc.nextInt();
		Detective det = session.get(Detective.class, id);
		session.delete(det);
		session.beginTransaction().commit();
		System.out.println("Data has been Deleted from Database");
	}
	public static void getData(Session session)
	{
		  System.out.println("Enter ID to View Details");
		   int id= sc.nextInt();
		   Detective det = session.get(Detective.class, id);
		   System.out.println("Detective Name: "+det.getDname());
		   System.out.println("Dectective ID: "+det.getDid());
		   
	}
	
	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
	    cfg.configure();
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	   getData(session);
	    
		
	}

}
