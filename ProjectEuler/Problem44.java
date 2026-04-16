package eulerProject31To60;

public class Problem44 {
	public static long pentagonalNumber(long n) {
		return n * (3 * n - 1) / 2;
	}
	
	public static boolean isPentagonal(long checked, long[] array) {
		for (int i = 0; i < array.length; i++) {
			if (checked == array[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static long absolute(long a) {
		if (a > 0) {
			return a;
		} else {
			return -a;
		}
	}
	
	public static long sumAndDifferencePentagonal(long a, long b, long[] array) {
		if (isPentagonal(a + b, array) && isPentagonal(absolute(a - b), array)) {
			// System.out.println(a + "; " + b);
			return absolute(a - b);
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		long[] array = new long[5000];
		for (int i = 0; i < array.length; i++) {
			array[i] = pentagonalNumber(i + 1);
		}
		long minimum = 999999999999l;
		for (int i = 0; i < array.length; i++) {
			// System.out.println(array[i]);
			for (int j = i + 1; j < array.length; j++) {
				long temp = sumAndDifferencePentagonal(array[i], array[j], array);
				// System.out.println(temp);
				if (temp != 0 && temp < minimum) {
					minimum = temp;
				}
			}
		}
		System.out.println("Ausgabe: " + minimum);
	}
	
	/*
	 * Problem solved
	 * 64109th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
