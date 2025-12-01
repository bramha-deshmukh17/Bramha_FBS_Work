package Classwork.Nov_28;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList al=new ArrayList();
		
		al.add(10);
		al.add(20);
		al.add(40);
		al.add(30);
		
		System.out.println(al);
		
		if(al.contains(40)) {
			System.out.println("Found");
		}else {
			System.out.println("Not found");
		}
		
		al.remove(2);//index
		
		if(al.contains(40)) {
			System.out.println("Found");
		}else {
			System.out.println("Not found");
		}
		
	}

}
