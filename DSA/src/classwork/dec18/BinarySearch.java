package classwork.dec18;

import java.util.Scanner;

public class BinarySearch {

	static int binarySearch(int[] arr, int num) {

		int start = 0, end = arr.length - 1, mid;
		while (start <= end) {
			mid = (start + end) / 2;

			if (arr[mid] == num)
				return mid;
			else if (arr[mid] > num)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		System.out.println("Enter 10 array elements in ascending order only:");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.print("Enter number to search: ");
		int num = sc.nextInt();

		int res = BinarySearch.binarySearch(arr, num);
		if (res != -1)
			System.out.println("Found at index: " + res);
		else
			System.out.println("Not found");
	}

}
