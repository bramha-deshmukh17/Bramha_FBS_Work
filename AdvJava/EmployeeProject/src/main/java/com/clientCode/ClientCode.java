package com.clientCode;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.DevicesPojo;
import com.bean.EmployeePojo;

public class ClientCode {

	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();
			SessionFactory factory = cfg.configure().buildSessionFactory();
			Session ses = factory.openSession();

			Transaction tr = ses.beginTransaction();
			EmployeePojo e;
			DevicesPojo d;
			List<DevicesPojo> devices;

//			using persist we can store many devices in to employee
//			 devices = new ArrayList<>();
//			devices.add(new DevicesPojo("Laptop", "Acer nitro", 125000));
//			devices.add(new DevicesPojo("Mobile", "Oneplus", 40000));
//			devices.add(new DevicesPojo("Monitor", "Hp", 25000));
//
//			e = new EmployeePojo("Ana Lave", 60000, "mainapp@gmail.com", 5000, devices);
//			ses.persist(e);

			e = ses.get(EmployeePojo.class, 1);
//			e = ses.getReference(EmployeePojo.class, 2);

			e.setEmail("amit123@gmail.com");
			e.setEName("Annasaheb");

			devices = e.getDev();

			devices.get(0).setDModule("Lenovo");
			devices.get(0).setDModule("Hp Omen");
			devices.get(0).setDVal(150000);

			devices.get(1).setDName("Mobile");
			devices.get(1).setDModule("Samsung");
			ses.merge(e);

			tr.commit();
			System.out.println(e);
			ses.close();
			factory.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
