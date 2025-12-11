package Classwork.Dec_09;

import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;

class ThreadName extends Thread {
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("FirstName.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("Firstname: " + line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ThreadLastName extends Thread {
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("LastName.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("Lastname: " + line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class TestFileThread {

	public static void main(String[] args) throws InterruptedException {
		ThreadName tn = new ThreadName();
		tn.start();

		ThreadLastName tln = new ThreadLastName();
		tln.start();
	}
	
}
