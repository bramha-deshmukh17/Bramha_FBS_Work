package classwork.dec22;

import java.util.Scanner;

public class InsertionSort {

	static void insertionSort(int[] arr) {
		int num, j;
		for (int i = 1; i < arr.length; i++) {
			num = arr[i];
			j = i - 1;
			while (j >= 0) {
				if (arr[j] > num) {
					arr[j + 1] = arr[j];
					j--;
				} else
					break;
			}

			arr[j + 1] = num;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		System.out.println("Enter 10 array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		insertionSort(arr);

		for (int num : arr) {
			System.out.print("\t" + num);
		}
		sc.close();

	}

}
