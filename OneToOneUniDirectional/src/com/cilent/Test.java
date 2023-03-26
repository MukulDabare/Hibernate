package com.cilent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.AdharCard;
import com.model.Person;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		AdharCard ad=new AdharCard();
		ad.setAdharNo(1456325632);
		ad.setAdharName("Manik");
		Person p=new Person();
		p.setpId(1);
		p.setpName("Manik");
		p.setAd(ad);
		session.save(p);
		session.beginTransaction().commit();
		System.out.println("Data Saved");
	}
}
