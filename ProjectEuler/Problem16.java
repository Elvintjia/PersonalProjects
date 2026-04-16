package eulerProject1To30;

import java.math.BigInteger;

public class Problem16 {
	public static void main(String[] args) {
		BigInteger summe = BigInteger.ONE;
		for (int i = 1; i <= 1000; i++) {
			summe = summe.multiply(BigInteger.TWO);
		}
		String verarbeitung = "" + summe;
		summe = BigInteger.ZERO;
		for (int i = 0; i <= verarbeitung.length() - 1; i++) {
			summe = summe.add(new BigInteger("" + verarbeitung.charAt(i)));
		}
		System.out.println("Ausgabe: " + summe);
		
		/*
		 * Problem solved
		 * 244341st person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
