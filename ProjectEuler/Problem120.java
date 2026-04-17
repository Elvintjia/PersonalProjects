package eulerProject91to120;

import java.math.BigInteger;

public class Problem120 {
	public static BigInteger squareRemainders(int r, int n) {
		BigInteger first = new BigInteger((r - 1) + "");
		BigInteger second = new BigInteger((r + 1) + "");
		BigInteger modulo = new BigInteger(r + "");
		modulo = modulo.pow(2);
		BigInteger biggest = BigInteger.ZERO;
		for (int i = 1; i <= n; i++) {
			BigInteger temp = first.pow(i).add(second.pow(i));
			BigInteger temp2 = temp.mod(modulo);
			if (biggest.compareTo(temp2) < 1) {
				biggest = temp2;
			}
		}
		return biggest;
	} 
	
	public static BigInteger endResult(int n) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 3; i <= 1000; i++) {
			sum = sum.add(squareRemainders(i, n));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + endResult(3000));
		// 10: 9007628
		// 20: 19008116
		// 50: 48880882
		// 100: 97759422
		// 200: 188507156
		// 500: 332673556
		// 1000: 332944222
		// 2000: 333082500
		// 3000: 333082500
	}
	
	/* Remark: Kind of a scummy method that I used. I kept increasing the search parameters until I don't get any changes
	 * in the end result, then took the end result of that and put it in the website, which is the correct answer. A bit of
	 * meta bruteforce involved, but hey. If it looks stupid but works, it ain't stupid.
	 * Problem solved
	 * 15479th person to have solved this problem
	 * Difficulty rating: 25%
	 * Runtime: 5 minutes, 37 seconds
	 * */
}
