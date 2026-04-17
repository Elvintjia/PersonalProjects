package eulerProject91to120;

import java.util.ArrayList;

public class Problem92 {
	public static void iterate(int[] array, ArrayList<Integer> arrayTwo, int num) {
		if (array[num - 1] > 0) {
			for (int i = 0; i < arrayTwo.size(); i++) {
				int index = arrayTwo.get(i);
				if (index < array.length) {
					array[index - 1] = array[num - 1];
				}
			}
		} else {
			arrayTwo.add(num);
			int sum = 0;
			for (; num > 0; num /= 10) {
				int digit = num % 10;
				sum += (digit * digit);
			}
			iterate(array, arrayTwo, sum);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[10000000];
		array[88] = 89;
		array[0] = 1;
		for (int i = 0; i < array.length; i++) {
			/*
			if (i % 1000 == 0) {
				System.out.println(i);
			}
			*/
			if (array[i] == 0) {
				ArrayList<Integer> arrayTwo = new ArrayList<Integer>();
				iterate(array, arrayTwo, i + 1);
			}
		}
		int sum = 0;
		for (int i = 0; i < 9999999; i++) {
			if (array[i] == 89) {
				sum++;
			}
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/*
	 * Problem solved
	 * 45378th person to have solved this problem
	 * Difficulty rating: 5%
	 * Runtime: Less than 1 second
	 * */
}
