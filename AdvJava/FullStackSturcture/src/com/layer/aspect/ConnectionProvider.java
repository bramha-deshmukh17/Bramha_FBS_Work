package com.layer.aspect;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ConnectionProvider {
	
	static Session s;

	public static Session provideConnection() {
		try {
//			FileInputStream fis = new FileInputStream(".//Resources//Config.properties");
//			Properties prop = new Properties();
//			prop.load(fis);
//
//			String cname = prop.getProperty("classname");
//			String url = prop.getProperty("url");
//			String user = prop.getProperty("username");
//			String pass = prop.getProperty("password");
//
//			Class.forName(cname);
//			Connection con = DriverManager.getConnection(url, user, pass);
//			return con;
			
			s = new Configuration().configure().buildSessionFactory().openSession();
			
			return s;
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}