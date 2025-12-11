package Classwork.Dec_09;

class Worker extends Thread {

	@Override
	public void run() {
		String arr = "1234567890987654321";

		for (int i = 0; i < arr.length(); i++) {
			System.out.print(" " + arr.charAt(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Worker w = new Worker();
		w.start();

		String arr = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < arr.length(); i++) {
			System.out.print(" " + arr.charAt(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
