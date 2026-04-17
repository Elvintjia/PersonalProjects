package eulerProject121to150;

import java.util.ArrayList;

public class Problem132 {
	public static int repunitDivisibility(int n) {
		if (n % 2 == 0 || n % 5 == 0) {
			return 0;
		}
		int toReturn = 1;
		int remainder = 1;
		while (remainder > 0) {
			if (remainder >= n) {
				remainder -= n;
			} else {
				remainder = remainder * 10 + 1;
				toReturn++;
			}
		}
		return toReturn;
	}
	
	public static ArrayList<Integer> erasthothenesSieve(int n) {
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		array[1] = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				for (int j = i * 2; j < array.length; j += i) {
					array[j] = 0;
				}
			}
		}
		ArrayList<Integer> toReturn = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				toReturn.add(array[i]);
			}
		}
		return toReturn;
	}
	
	public static boolean checkDivisibility(int n, int o) {
		if (o <= 0) {
			return false;
		}
		int count = 0;
		while (o % 2 == 0) {
			count++;
			o /= 2;
		}
		if (count > n) {
			return false;
		}
		count = 0;
		while (o % 5 == 0) {
			count++;
			o /= 5;
		}
		if (count > n) {
			return false;
		} else if (o > 1) {
			return false;
		}
		return true;
	}
	
	public static long largeRepunitFactors(int n, int o) {
		long toReturn = 0;
		ArrayList<Integer> sieve = erasthothenesSieve(1000000);
		while (o > 0) {
			int temp = sieve.removeFirst();
			// System.out.println(temp);
			int temp2 = repunitDivisibility(temp);
			if (checkDivisibility(n, temp2)) {
				toReturn += temp;
				o--;
			}
			// System.out.println(temp);
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + largeRepunitFactors(9, 40));
	}
	
	/*
	 * Problem solved
	 * 7319th person to have solved this problem
	 * Problem level: 10
	 * Runtime: 8 seconds
	 * */
}
