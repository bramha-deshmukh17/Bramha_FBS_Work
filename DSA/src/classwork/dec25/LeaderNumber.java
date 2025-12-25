package classwork.dec25;

public class LeaderNumber {

	public static void main(String[] args) {
		int[] arr = { 10, 9, 45, 5, 9, 77, 21, 45, 10, 66 };
		int leaderIndex = -1, length = arr.length;
		boolean flag;

		for (int i = 0; i < length; i++) {
			flag = true;
			for (int j = i + 1; j < length; j++) {
				if (arr[j] > arr[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {

				leaderIndex = i;
				break;
			}

		}

		if (leaderIndex != -1) {
			for (int i = leaderIndex; i < length; i++)
				System.out.print(" " + arr[i]);
		} else
			System.out.println("No leader element found");
	}

}
