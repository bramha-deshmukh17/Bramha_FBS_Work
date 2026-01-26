package com.layer.aspect;

import java.io.FileInputStream;
import java.util.Properties;
import com.layer.service.LoginValidationService;

public class ObjectCreater {
	// building an object of Business Logic class-Aspect --service provider
	public static LoginValidationService createObject() {
		String classname = null;
		LoginValidationService login = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("e:/Bramha_FBS_Work/AdvJava/FullStackSturcture/resources/info.properties");
			Properties p = new Properties();
			p.load(fis);
			classname = p.getProperty("businessClass");
		} catch (Exception e) {
			System.out.println("Could not load info.properties. Check the path and file existence.");
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				// ignore
			}
		}
		if (classname == null || classname.isEmpty()) {
			System.out.println("businessClass property not found in info.properties.");
			return null;
		}
		try {
			login = (LoginValidationService) Class.forName(classname).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			System.out.println("Could not instantiate class: " + classname);
			e.printStackTrace();
			return null;
		}
		return login;
	}
}
