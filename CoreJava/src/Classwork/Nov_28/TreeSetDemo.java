package Classwork.Nov_28;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet ts=new TreeSet();
		
		ts.add(10);
		ts.add(20);
		ts.add(40);
		ts.add(30);
		
		System.out.println(ts);
		
		if(ts.contains(40)) {
			System.out.println("Found");
		}else {
			System.out.println("Not found");
		}
		
		ts.remove(40);//object or value
		
		if(ts.contains(40)) {
			System.out.println("Found");
		}else {
			System.out.println("Not found");
		}
	}

}
