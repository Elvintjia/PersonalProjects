package eulerProject61to90;

import java.math.BigInteger;

public class Problem65 {
	public static void main(String[] args) {
		long[] array = new long[100];
		array[0] = 2;
		for (int i = 0; i < 33; i++) {
			int i3 = i * 3;
			array[i3 + 1] = 1;
			array[i3 + 2] = (i + 1) * 2;
			array[i3 + 3] = 1;
		}
		BigInteger[] fraction = {BigInteger.ONE, new BigInteger("" + array[array.length - 1])};
		for (int i = array.length - 2; i >= 0; i--) {
			fraction[0] = fraction[0].add(fraction[1].multiply(new BigInteger("" + array[i])));
			BigInteger temp = fraction[1];
			fraction[1] = fraction[0];
			fraction[0] = temp;
		}
		String string = "" + fraction[1];
		long sum = 0;
		for (int i = 0; i < string.length(); i++) {
			sum += Long.valueOf("" + string.charAt(i));
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/*
	 * Problem solved
	 * 33030th person to have solved this problem
	 * Difficulty rating: 15%
	 * */
}
