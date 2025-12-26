package classwork.dec24;

import java.util.Scanner;

public class MergeSort {


    static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            combine(arr, start, mid, end);
        }
    }

    static void combine(int[] arr, int start, int mid, int end) {
        int i = start;  
        int j = mid + 1;
        int k = 0;   
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // copy any remaining elements
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= end)
            temp[k++] = arr[j++];

        // copy back to original array
        for(int p = 0; p < temp.length; p++) {
            arr[start++] = temp[p];
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		System.out.println("Enter 10 array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		mergeSort(arr, 0, arr.length - 1);

		for (int num : arr) {
			System.out.print("\t" + num);
		}
		sc.close();
    }
}
