package Classwork.Dec_05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
	int rollNo;
	String name;

	Student(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}

	int getRollNo() {
		return rollNo;
	}

	void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}

}

public class FileTest {
	
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("data.txt");
			//DataOutputStream dos = new DataOutputStream(fos);
			ObjectInputStream dis = new ObjectInputStream(fis);
			
			Student s1 = (Student) dis.readObject();
			System.out.println(s1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main1(String[] args) {
		
		
		try {
			FileOutputStream fos = new FileOutputStream("data.txt");
			//DataOutputStream dos = new DataOutputStream(fos);
			ObjectOutputStream dos = new ObjectOutputStream(fos);
			dos.writeObject(new Student(12, "Bramha"));
			System.out.println("Written succcessfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
