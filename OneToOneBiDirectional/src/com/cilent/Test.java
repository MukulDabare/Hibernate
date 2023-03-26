package com.cilent;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.AdharCard;
import com.model.Person;

public class Test {
static Scanner sc= new Scanner(System.in);
	private static void setData(Session session) {
		AdharCard ad=new AdharCard();
		ad.setAdharNo(123);
		ad.setAdharName("Sajnik");
		Person p=new Person();
		p.setpId(2);
		p.setpName("Sajnik");
		p.setAd(ad);
		ad.setP(p);
		session.save(p);
		session.beginTransaction().commit();
		System.out.println("Data Saved");
	}
	private static void getData(Session session) {
		System.out.println("Enter Person ID to details");
		int id=sc.nextInt();
		Person p = session.get(Person.class, id);
		System.out.println("By using Person's 'p' Object\n");
		System.out.println("Person Id: "+p.getpId());
		System.out.println("Person Id: "+p.getpName());
		System.out.println("Person's Name On Adhar Card: "+p.getAd().getAdharName());
		System.out.println("Adhar Number : "+p.getAd().getAdharNo());
//		System.out.println("                By using Person's 'p' Object\n");
//		System.out.println("                      Enter Adhar Number");
//		long pid=sc.nextLong();
//		AdharCard ad = session.get(AdharCard.class, pid);
//		System.out.println("Name on Adhar Card: "+ad.getAdharName());
//		System.out.println("Adhar Number : "+ad.getAdharNo());
//		System.out.println("Person's Name linked to Adhar Card: "+ad.getP().getpName());
//		System.out.println("Person's ID linked to Adhar Card: "+ad.getP().getpId());
	}
	private static void updateName(Session session) {
		System.out.println("Enter Person ID to details");
		int id=sc.nextInt();
		Person p = session.get(Person.class, id);
		System.out.println("Enter Updated Name of Person");
		String name=sc.next()+sc.nextLine();
		p.setpName(name);
		p.getAd().setAdharName(name);
		session.saveOrUpdate(p);
		session.beginTransaction().commit();
		getData(session);
	}
	private static void deletePerson(Session session) {
		System.out.println("Enter Person ID to details");
		int id=sc.nextInt();
		Person p = session.get(Person.class, id);
		session.delete(p);
		session.beginTransaction().commit();
		System.out.println("Person has been deleted from our database");

	}
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		deletePerson(session);

	}
	
	
	

	
}
