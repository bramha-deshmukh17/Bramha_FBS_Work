package Classwork.Dec_12;

public class StringDuplicate {

	public static void main(String[] args) {
		// remove duplicate from string
		StringBuffer str = new StringBuffer("aBaaramha");

		System.out.println(str);

		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);

			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) == current) {
					str.deleteCharAt(j);
					j--;
				}
			}
		}

		System.out.println(str);

	}

}

//get first non repeating char from string
//longest word from given string
//input = 5 output = A+AA+AAA+AAAA+AAAAA
