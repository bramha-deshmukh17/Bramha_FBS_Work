package classwork.dec_17;

import java.util.Scanner;

public class MySearch {

	static int lineaSearch(int[] arr, int num) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num)
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		System.out.println("Enter 10 array elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.print("Enter number to search: ");
		int num = sc.nextInt();

		int res = MySearch.lineaSearch(arr, num);
		if (res != -1)
			System.out.println("Found at index: " + res);
		else
			System.out.println("Not found");
	}

}
