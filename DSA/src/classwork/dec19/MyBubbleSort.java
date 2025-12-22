package classwork.dec19;

import java.util.Scanner;

public class MyBubbleSort {

	static void bubbleSort(int[] arr) {

		int temp;
		int count = 0, swap = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			boolean sorted = false;

			for (int j = 0; j < arr.length - i - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swap++;
				}else {
					sorted = true;
				}

			}
			count++;

			if (sorted)
				break;

		}
		System.out.println("Iteration: " + count);
		System.out.println("Swap: " + swap);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		System.out.println("Enter 10 array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		bubbleSort(arr);

		for (int num : arr) {
			System.out.print("\t" + num);
		}

	}

}
