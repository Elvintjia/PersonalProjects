package eulerProject1To30;

import java.math.BigInteger;

public class Problem6 {
	public static void main(String[] args) {
		BigInteger SummeQuadrat = BigInteger.valueOf(0);
		BigInteger QuadratSumme = BigInteger.valueOf(0);
		for (int i = 1; i <= 100; i++) {
			SummeQuadrat = SummeQuadrat.add(BigInteger.valueOf(i));
		}
		SummeQuadrat = SummeQuadrat.multiply(SummeQuadrat);
		for (int i = 1; i <= 100; i++) {
			QuadratSumme = QuadratSumme.add(BigInteger.valueOf(i * i));
		}
		System.out.println("Ausgabe: " + (SummeQuadrat.subtract(QuadratSumme)));
		
		/*
		 * Problem solved
		 * 521174th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
