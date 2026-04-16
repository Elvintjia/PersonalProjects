package eulerProject31To60;

import java.math.BigInteger;

public class Problem57 {
	public static BigInteger[] squareRootOfTwo(long expansion, BigInteger[] input) {
		while (expansion > 1) {
			input[0] = input[0].add(input[1].multiply(BigInteger.TWO));
			BigInteger temp = input[0];
			input[0] = input[1];
			input[1] = temp;
			expansion--;
		}
		input[0] = input[0].add(input[1]);
		return input;
	}
	
	public static void main(String[] args) {
		long count = 0;
		for (int i = 1; i <= 1000; i++) {
			BigInteger[] temp = new BigInteger[2];
			temp[0] = BigInteger.ONE;
			temp[1] = BigInteger.TWO;
			temp = squareRootOfTwo(i, temp);
			if ((temp[0] + "").length() > (temp[1] + "").length()) {
				count++;
			}
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/*
	 * Problem solved
	 * 45740th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
