package com.aug.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		/*
		 * Configuration cfg = new Configuration(); SessionFactory factory =
		 * cfg.configure("config.xml").buildSessionFactory(); Session ses=
		 * factory.openSession(); Transaction tr = ses.beginTransaction();
		 */

		Session ses = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tr = ses.beginTransaction();

		Mobile mob = new Mobile(500, "IPHONE", 52000, "Iphone 13", "White");
		Application app = new Application(101, "Instagram", "Java Script", "Flutter");
		ses.save(mob);
		ses.save(app);
		tr.commit();
		ses.close();
	}

}
