package eulerProject91to120;

import java.math.BigInteger;

public class Problem104 {
	public static boolean isPandigital(String line) {
		if (line.contains("0")) {
			return false;
		}
		for (int i = 0; i < line.length(); i++) {
			for (int j = i + 1; j < line.length(); j++) {
				if (line.charAt(i) == line.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean pandigitalFibonacciEnds(BigInteger fibonacci) {
		String fibonacciString = "" + fibonacci;
		if (fibonacciString.length() < 10) {
			return false;
		}
		return (isPandigital(fibonacciString.substring(0, 9)) &&
				isPandigital(fibonacciString.substring(fibonacciString.length() - 9)));
	}
	
	public static void main(String[] args) {
		BigInteger prev = BigInteger.ONE;
		BigInteger prevPrev = BigInteger.ONE;
		BigInteger fibonacci = prev.add(prevPrev);
		int counter = 3;
		for (; !pandigitalFibonacciEnds(fibonacci); counter++) {
			// System.out.println(counter);
			prevPrev = prev;
			prev = fibonacci;
			fibonacci = prev.add(prevPrev);
		}
		// System.out.println(fibonacci);
		System.out.println("Ausgabe: " + counter);
	}
	
	/* Remark: I intended to make a more efficient program and then went to do research, but then got distracted and did
	 * other things. Meanwhile, the program kept running until it found the right answer. Oh well.
	 * Problem solved
	 * 18075th person to have solved this problem
	 * Difficulty rating: 25%
	 * Runtime: 38 minutes 26 seconds
	 * */
}
