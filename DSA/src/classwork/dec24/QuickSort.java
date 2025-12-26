package classwork.dec24;

import java.util.Scanner;

public class QuickSort {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		System.out.println("Enter 10 array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		quickSort(arr, 0, arr.length - 1);

		for (int num : arr) {
			System.out.print("\t" + num);
		}
		sc.close();
    }

    static void quickSort(int[] arr, int start, int end) {
        
        if (start >= end) {
            return;
        }
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <= end && arr[i] <= pivot) {
                i++;
            }
            while (j >= start && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[start];
        arr[start] = arr[j];
        arr[j] = temp;
        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    
    }
}
