package com.layer.aspect;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionProvider {
	public static Connection provideConnection() {
		Connection con = null;
		try {
			FileInputStream fis = new FileInputStream(
					"e:/Bramha_FBS_Work/AdvJava/FullStackSturcture/resources/dbconfig.properties");
			Properties p = new Properties();
			p.load(fis);
			String classname = p.getProperty("classname");
			String url = p.getProperty("url");
			String user = p.getProperty("username");
			String pass = p.getProperty("password");

			Class.forName(classname);
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
