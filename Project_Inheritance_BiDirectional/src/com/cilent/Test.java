package com.cilent;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.service.HomeController;

public class Test {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		HomeController h=new HomeController();
		while (true) {
		System.out.println("Enter choice:"
				+ "\n1. Save Laptop"
				+ "\n2.Get a Laptop Configuration"
				+ "\n3.Save Mobile "
		        + "\n4.Get Mobile Configuration"
				+ "\n5.Get All Laptops"
				+ "\n6.Get All Mobiles"
				+ "\n7.Update Laptop Configurations"
				+ "\n8.Update Mobile Configuration"
				+ "\n9.Delete Laptop From Database"
				+ "\n10.Delete Mobile From Database"
				+"\n11.Add Device (Laptop Or Mobile)"
				+"\n12.Remove Device (Laptop Or Mobile)"
				+"\n13.Exit"
				 );
		int ch=sc.nextInt();
		
			switch (ch) {
			case 1:
               h.lcreate(session);
				break;
			case 2:
	               h.lgetSingleData(session);
					break;
			case 3:
	               h.mcreate(session);
					break;
			case 4:
	               h.mgetSingleData(session);
	               
					break;
			case 5:
	               h.lread(session);
	               
					break;
			case 6:
	               h.mread(session);
	               
					break;
			case 7:
	               h.lupdate(session);
	               
					break;
					
			case 8:
				   h.mupdate(session);
	               
					break;
			case 9:
	               h.ldelete(session);
	               
					break;
			case 10:
	               h.mdelete(session);
	               
					break;
			case 11:
	              h.dcreate(session);
	               
					break;
			case 12:
	               
	               h.ddelete(session);
					break;
			case 13:
				System.exit(0);

			default:
				System.out.println("Enter Valid Choice");
				break;
			}
		}
	}

	
	
	

	

}
