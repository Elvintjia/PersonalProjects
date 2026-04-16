package eulerProject61to90;

import java.math.BigInteger;

public class Problem63 {
	public static BigInteger expt(BigInteger a, long b) {
		if (b == 1) {
			return a;
		} else {
			return a.multiply(expt(a, b - 1));
		}
	}
	
	public static void main(String[] args) {
		long count = 0;
		for (int i = 1; i <= 1000; i++) {
			BigInteger base = BigInteger.ONE;
			while (true) {
				String exponented = "" + expt(base, i);
				if (exponented.length() == i) {
					count++;
				} else if (exponented.length() > i) {
					break;
				}
				base = base.add(BigInteger.ONE);
			}
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/*
	 * Problem solved
	 * 47214th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
