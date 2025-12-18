package classwork.dec18;

import java.util.HashMap;

public class Frequency {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 3, 4, 6, 8, 5, 4 };
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			} else {
				hm.put(arr[i], 1);
			}
		}

		System.out.println(hm);

	}

}
