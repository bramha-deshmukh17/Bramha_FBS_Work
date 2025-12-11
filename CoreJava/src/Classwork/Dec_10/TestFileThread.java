package Classwork.Dec_10;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestFileThread {

    static String firstname;
    static boolean ready = false; // controls turn

    public static void main(String[] args) {

    	Thread t1 = new Thread(new FirstThread());
        Thread t2 = new Thread(new LastThread());

        t1.start();
        t2.start();
    }

    public synchronized void startThreads() {

        
    }

    class FirstThread implements Runnable {
        public synchronized void run() {
            try (BufferedReader br = new BufferedReader(new FileReader("FirstName.txt"))) {
                String line;

                while ((line = br.readLine()) != null) {

                    while (ready) {
                        wait();        
                    }

                    firstname = line;
                    ready = true;
                    notify();          
                }

                firstname = null;     
                ready = true;
                notify();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // ---------------- THREAD TO READ LASTNAME + PRINT ----------------
    class LastThread implements Runnable {
        public synchronized void run() {
            try (BufferedReader br = new BufferedReader(new FileReader("LastName.txt"))) {
                String last;

                while ((last = br.readLine()) != null) {

                    while (!ready) {
                        wait();        // wait for firstname
                    }

                    if (firstname == null) return;

                    System.out.println(firstname + " " + last);

                    ready = false;
                    notify();          // allow firstname thread to continue
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
