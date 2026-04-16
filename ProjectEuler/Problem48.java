package eulerProject31To60;

public class Problem48 {
	public static long lastTenDigits(long input) {
		if (input >= 1e10) {
			input = input % 10000000000l;
		}
		return input;
	}
	
	public static long expt(long a, long b) {
		if (b == 0) {
			return 1;
		} else {
			return lastTenDigits(a * lastTenDigits(expt(a, b - 1)));
		}
	}
	
	public static void main(String[] args) {
		long result = 0;
		for (long i = 1; i <= 1000; i++) {
			result = lastTenDigits(result + expt(i, i));
		}
		System.out.println("Ausgabe: " + result);
	}
	
	/*
	 * Problem solved
	 * 120539th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
