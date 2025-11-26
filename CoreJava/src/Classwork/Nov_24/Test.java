package Classwork.Nov_24;

public class Test {

	public static void main(String[] args) {

		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			
			int c = a / b;
			System.out.println(c);
		}
		catch (ArithmeticException ae) {
			System.out.println("2nd value should non zero");
		} 
		catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println("Enter at least two args");
		}
		catch (NumberFormatException ne) {
			System.out.println("Enter only digits");
		}
		catch (Exception e) {
			System.out.println("Oops something went wrong...!!");
		}

	}
}
