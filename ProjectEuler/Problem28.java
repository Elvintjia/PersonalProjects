package eulerProject1To30;

public class Problem28 {
	public static void main(String[] args) {
		long[] array = new long[2001];
		array[0] = 1;
		for (int i = 1; i <= 500; i++) {
			int j = (i - 1) * 4;
			for (int k = 1;k <= 4; k++) {
				array[j + k] = array[j + k - 1] + (i * 2);
			}
		}
		long sum = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			sum += array[i];
		}
		System.out.println("Ausgabe: " + sum);
		
		/*
		 * Problem solved
		 * 115925th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
