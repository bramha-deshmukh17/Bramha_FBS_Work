package classwork.dec19;

import java.util.Scanner;

public class MySelectionSort {
	static void selectionSort(int[] arr) {

		int min = arr[0], minIndex = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			min = arr[i];
			minIndex = i;
			
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}

			arr[minIndex] = arr[i];
			arr[i] = min;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		System.out.println("Enter 10 array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		selectionSort(arr);

		for (int num : arr) {
			System.out.print("\t" + num);
		}
		sc.close();

	}

}
