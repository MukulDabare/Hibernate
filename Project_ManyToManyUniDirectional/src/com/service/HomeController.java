package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.model.Laptop;
import com.model.Mobile;


public class HomeController implements controller {
 Scanner sc=new Scanner(System.in);
	@Override
	public void lcreate(Session session) {
	Laptop l=new Laptop();
	System.out.println("Enter Laptop Model Number");
	l.setLid(sc.nextInt());
	System.out.println("Enter Laptop Brand");
	l.setLname(sc.next()+sc.nextLine());
	System.out.println("Enter Laptop RAM in GB");
	l.setLram(sc.nextInt());
	System.out.println("Enter Laptop Price");
	l.setLprice(sc.nextFloat());
	System.out.println("Enter Laptop Weight in kg");
	l.setLweight(sc.nextFloat());
	System.out.println("Laptop Data has been saved in our Database");
	System.out.println("Enter Choice, Do you want to link Mobiles to this Laptop \n1.Yes\n2.No");
	int ch=sc.nextInt();
	if(ch==1)
	{
		 System.out.println("Avilable Mobiles: ");
		  Query query = session.getNamedQuery("getAllMobile");
			List<Mobile> list = query.getResultList();
			list.forEach(mob->{
				System.out.println("Mobile Name: "+mob.getMname());
				System.out.println("Mobile Model Number: "+mob.getMid());
				System.out.println("--------------------------------");
			});
	     System.out.println("Enter Mobile model number to link with this Laptop");
	     int id=sc.nextInt();
	     Mobile m = session.get(Mobile.class, id);
	     l.getM().add(m);
	     session.save(m);
	     do
	     {
	    	 Boolean b=true;
	    	 while (b==true) {
				System.out.println("Enter choice: Do you want to link more Moblies ?" + "\n1.Yes \n2.No ");
				int cho = sc.nextInt();
				if (cho == 1 && b == true) {
					System.out.println("Avilable Mobiles: ");
					Query que = session.getNamedQuery("getAllMobile");
					List<Mobile> li = que.getResultList();
					li.forEach(mob -> {
						System.out.println("Mobile Name: " + mob.getMname());
						System.out.println("Mobile Model Number: " + mob.getMid());
						System.out.println("--------------------------------");
					});
					System.out.println("Enter Mobile model number to link with this Laptop");
					int id2 = sc.nextInt();
					Mobile m1 = session.get(Mobile.class, id2);
					l.getM().add(m1);
					session.save(m1);
				}
				if (cho == 2) {
					session.save(l);
					b = false;
				} 
			}
			session.beginTransaction().commit(); 
	 	 }while(false);
	}
	     if(ch==2)
		 	{
		 		session.save(l);
		 	}
	     session.beginTransaction().commit();
	     
	    
}
	@Override
	public void lread(Session session) {
		Query query = session.getNamedQuery("getAllLaptops");
		List<Laptop> list = query.getResultList();
		list.forEach(lap->{
			System.out.println("Laptop Brand: "+lap.getLname());
			System.out.println("Laptop Model Number: "+lap.getLid());
		});
		
	}

	@Override
	public void lupdate(Session session) {
		System.out.println("Enter Laptop Model Number for Updation");
		Laptop lap = session.get(Laptop.class, sc.nextInt());
		System.out.println("Enter Updated RAM in GB");
		lap.setLram(sc.nextInt());
		System.out.println("Enter Updated Price in Rs.");
		lap.setLprice(sc.nextFloat());
		System.out.println("Enter Laptop's Updated weight in Kg");
		lap.setLweight(sc.nextFloat());
		session.saveOrUpdate(lap);
		session.beginTransaction().commit();
		System.out.println("Laptop Configuration has been updated");
		
	}

	@Override
	public void ldelete(Session session) {
		System.out.println("Enter Laptop Model Number to delete from our Database");
		Laptop lap = session.get(Laptop.class, sc.nextInt());
		session.delete(lap);
		session.beginTransaction().commit();
		
		
	}

	@Override
	public void lgetSingleData(Session session) {
		System.out.println("Enter Laptop Model Number ");
		Laptop lap = session.get(Laptop.class, sc.nextInt());
		System.out.println("Laptop Model Number: "+lap.getLid());
		System.out.println("Laptop Brand: "+lap.getLname());
		System.out.println("Laptop RAM: "+lap.getLram()+" GB");
		System.out.println("Laptop Price: Rs."+lap.getLprice());
		System.out.println("Laptop Weight: "+lap.getLweight()+"kg");
		System.out.println("       Laptop Linked to Following Mobiles: ");
		lap.getM().forEach(mob->{
		
			System.out.println("Mobile Name: "+mob.getMname());
			System.out.println("Mobile Model No.: "+mob.getMid());
		});
		
	}

	@Override
	public void mcreate(Session session) {
		Mobile m=new Mobile();
		System.out.println("Enter Mobile Model Number");
		m.setMid(sc.nextInt());
		System.out.println("Enter Mobile Brand");
		m.setMname(sc.next()+sc.nextLine());
		System.out.println("Enter Mobile RAM in GB");
		m.setMram(sc.nextInt());
		System.out.println("Enter Mobile Price");
		m.setMprice(sc.nextFloat());
		System.out.println("Enter Mobile Weight in gm");
		m.setMweight(sc.nextFloat());
		Laptop lap=new Laptop();
		lap.getM().add(m);
		session.save(m);
		session.beginTransaction().commit();
		System.out.println("Mobile Data has been saved in our Database");
		
		
	}

	@Override
	public void mread(Session session) {
		Query query = session.getNamedQuery("getAllMobile");
		List<Mobile> list = query.getResultList();
		list.forEach(lap->{
			System.out.println("Mobile Brand: "+lap.getMname());
			System.out.println("Mobile Model Number: "+lap.getMid());
		});
		
	}

	@Override
	public void mupdate(Session session) {
		System.out.println("Enter Mobile Model Number for Updation");
		Mobile mob = session.get(Mobile.class, sc.nextInt());
		System.out.println("Enter Updated RAM in GB");
		mob.setMram(sc.nextInt());
		System.out.println("Enter Updated Price in Rs.");
		mob.setMprice(sc.nextFloat());
		System.out.println("Enter Mobile's Updated weight in mg");
		mob.setMweight(sc.nextFloat());
		session.saveOrUpdate(mob);
		session.beginTransaction().commit();
		System.out.println("Mobile Configuration has been updated");
		
	}

	@Override
	public void mdelete(Session session) {
		System.out.println("Enter Mobile Model Number to delete from our Database");
		Mobile mob = session.get(Mobile.class, sc.nextInt());
		session.delete(mob);
		session.beginTransaction().commit();
		
	}

	@Override
	public void mgetSingleData(Session session) {
		System.out.println("Enter Mobile Model Number ");
        Mobile mob = session.get(Mobile.class, sc.nextInt());
		System.out.println("Mobile Model Number: "+mob.getMid());
		System.out.println("Mobile Brand: "+mob.getMname());
		System.out.println("Mobile RAM: "+mob.getMram()+" GB");
		System.out.println("Mobile Price: Rs."+mob.getMprice());
		System.out.println("Mobile Weight: "+mob.getMweight()+"gm");
		
	}

	
}
