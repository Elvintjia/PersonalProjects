package eulerProject121to150;

import java.math.BigInteger;

public class Problem137 {
	public static long fibonacci(int n) {
		n--;
		long prev1 = 1;
		long prev2 = 1;
		for (; n > 0; n--) {
			long current = prev1 + prev2;
			prev1 = prev2;
			prev2 = current;
		}
		return prev1 * prev2;
	}
	
	public static BigInteger fibonacciGoldenNuggets(int n) {
		return new BigInteger(fibonacci(2 * n) + "");
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + fibonacciGoldenNuggets(15));
	}
	
	/*
	 * Problem solved
	 * 6493rd person to have solved this problem
	 * Problem level: 14
	 * Runtime: Less than 1 second
	 * */
}
