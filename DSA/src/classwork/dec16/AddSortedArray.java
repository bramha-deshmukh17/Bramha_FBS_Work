package classwork.dec16;

import java.util.Scanner;

public class AddSortedArray {

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("Enter size of array: ");
//		int size1 = sc.nextInt();
//		int[] arr1 = new int[size1];
//
//		System.out.print("\nEnter size of array 2: ");
//		int size2 = sc.nextInt();
//		int[] arr2 = new int[size2];
//
//		System.out.println("Enter array 1 elements in sorted way: ");
//		for (int i = 0; i < size1; i++) {
//			arr1[i] = sc.nextInt();
//
//		}
//
//		System.out.println("Enter array 2 elements in sorted way: ");
//		for (int i = 0; i < size2; i++) {
//			arr2[i] = sc.nextInt();
//		}
		int[] arr2 = { 1, 2, 4, 7, 9 };
		int[] arr1 = { 2, 4, 6 };
		int size1 = 3, size2 = 5;

		for (int x : arr1)
			System.out.print(x);
		System.out.println();
		for (int x : arr2)
			System.out.print(x);
		System.out.println();

		int size3 = size1 + size2;
		int[] arr3 = new int[size3];

		if (size1 > size2) {
			int index1 = 0, index2 = 0;
			for (int i = 0; i < size3; i++) {
				//if both are equal copy from both and increase the index of both array 1 and 2
				if (arr2[index2] == arr1[index1]) {
					arr3[i++] = arr2[index2];
					arr3[i] = arr1[index1];
					index1++;
					index2++;
					continue;
				}
				//here if the index value is less from the arr2 then copy to arr3 and increment index2 by 1
				//else from arr1 and increase index1 by 1
				if (arr2[index2] < arr1[index1]) {
					arr3[i] = arr2[index2];
					index2++;
				} else {
					arr3[i] = arr1[index1];
					index1++;
				}
				if (index2 == size2)
					break;
			}
			for (int i = index1 + index2; i < size3; i++) {
				arr3[i] = arr1[index1];
				index1++;
			}
		} else {
			int index1 = 0, index2 = 0;
			for (int i = 0; i < size3; i++) {
				if (arr1[index1] < arr2[index2]) {
					arr3[i] = arr1[index1];
					index1++;
				} else {
					arr3[i] = arr2[index2];
					index2++;
				}
				if (index1 == size1)
					break;
			}
			for (int i = index1 + index2; i < size3; i++) {
				arr3[i] = arr2[index2];
				index2++;
			}
		}

		System.out.println();
		for (int i = 0; i < size3; i++) {
			System.out.print(arr3[i]);
		}

	}

}

/*
 * package classwork.dec16;

public class AddSortedArray {
    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 6 };                // size1 = 3
        int[] arr2 = { 1, 2, 4, 7, 9 };         // size2 = 5
        int size1 = arr1.length, size2 = arr2.length;

        // print inputs (same order as your variables)
        for (int x : arr1) System.out.print(x);
        System.out.println();
        for (int x : arr2) System.out.print(x);
        System.out.println();

        int[] arr3 = new int[size1 + size2];
        int i = 0, j = 0, k = 0;

        // merge while both arrays have elements
        while (i < size1 && j < size2) {
            if (arr1[i] <= arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        // copy any remaining elements
        while (i < size1) arr3[k++] = arr1[i++];
        while (j < size2) arr3[k++] = arr2[j++];

        // print merged array
        for (int x : arr3) System.out.print(x);
        System.out.println();
    }
}

 * */
