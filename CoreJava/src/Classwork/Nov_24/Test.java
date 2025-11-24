package Classwork.Nov_24;

public class Test {
	
	public static void main(String[] args) {
		
		//int a = Integer.parseInt(args[0]);
		//int b = Integer.parseInt(args[1]);
		//if(b==0)
		//	System.out.println("second value can't be zero");
		//else {
		//	int c = a/b;
		//	System.out.println(c);
		//}
		
		String s = args[0];
		
		//way 1
		if (s.matches("-?\\d+")) {  
		    int n = Integer.parseInt(s);
		    System.out.println(n);
		} else {
		    System.out.println("Not a valid integer");
		}
		
		//way 2
		boolean valid = true;

		int start = (s.startsWith("-") ? 1 : 0);
		for (int i = start; i < s.length(); i++) {
		    if (!Character.isDigit(s.charAt(i))) {
		        valid = false;
		        break;
		    }
		}

		if (valid) {
		    int n = Integer.parseInt(s);
		} else {
		    System.out.println("Not a number");
		}

	}
}
