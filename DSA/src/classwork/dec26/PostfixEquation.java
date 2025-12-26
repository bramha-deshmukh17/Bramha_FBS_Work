package classwork.dec26;

import classwork.dec25.StackInt;

public class PostfixEquation {

	static int getResult(String postfix) throws IllegalArgumentException {
		StackInt s = new StackInt(20);

		for (int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);

			if (Character.isDigit(ch)) {
				s.push(Integer.parseInt(ch + ""));
			} else {
				int num2 = s.pop();
				int num1 = s.pop();

				switch (ch) {
				case '+':
					s.push(num1 + num2);
					break;
				case '-':
					s.push(num1 - num2);
					break;
				case '*':
					s.push(num1 * num2);
					break;
				case '/':
					s.push(num1 / num2);
					break;
				default:
					throw new IllegalArgumentException("Invalid equation contains invalid character - " + ch);
				}

			}
		}
		return s.pop();
	}

	public static void main(String[] args) {

		String postfix = "23*a4+9-";
		try{
			System.out.println("Result: " + getResult(postfix));
		}catch(IllegalArgumentException e){
			System.out.println(e);
		}
	}

}
