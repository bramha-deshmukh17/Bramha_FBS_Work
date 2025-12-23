package classwork.dec22;

import java.util.Scanner;

public class SumofPair {

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter array size: ");
//		int size = sc.nextInt();
//		int[] arr = new int[size];
//
//		System.out.print("Enter array elements: ");
//		for (int i = 0; i < size; i++) {
//			arr[i] = sc.nextInt();
//		}
//
//		System.out.println("Enter num");
//		int num = sc.nextInt();

		int size = 6, num = 6;

		int[] arr = { 1, 4, 3,  2, 10, -4 };

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {

				if (arr[i] + arr[j] == num) {
					System.out.println(arr[i] + ", " + arr[j]);
				}
			}
		}

//		sc.close();

	}

}
