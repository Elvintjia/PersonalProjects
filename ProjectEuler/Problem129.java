package eulerProject121to150;

import java.math.BigInteger;

public class Problem129 {
	public static long repunitDivisibility(int n) {
		long toReturn = n + 1;
		String base = "1";
		while (base.length() < (toReturn + "").length()) {
			base += "1";
		}
		while (toReturn > 0) {
			System.out.println(toReturn);
			String dividend = base;
			while (toReturn > 0) {
				BigInteger dividendBI = new BigInteger(dividend);
				BigInteger divisor = new BigInteger("" + toReturn);
				if (dividendBI.mod(divisor).compareTo(BigInteger.ZERO) == 0) {
					break;
				} else {
					dividend += "1";
				}
			}
			if (dividend.length() > n) {
				break;
			} else {
				toReturn += 2;
				if (toReturn % 5 == 0) {
					toReturn += 2;
				}
				if (base.length() < (toReturn + "").length()) {
					base += "1";
				}
			}
		}
		return toReturn;
	}
	
	public static int repunitDivisibilityTwo(int n) {
		int toReturn = n + 1;
		while (toReturn > 0) {
			int repunit = 1;
			int remainder = 1;
			while (remainder > 0) {
				if (remainder >= toReturn) {
					remainder -= toReturn;
				} else {
					remainder = remainder * 10 + 1;
					repunit++;
				}
			}
			if (repunit > n) {
				return toReturn;
			} else {
				toReturn += 2;
				if (toReturn % 5 == 0) {
					toReturn += 2;
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + repunitDivisibilityTwo(1000000));
	}
	
	/* Remark: I got the idea for the problem correct, but the implementation I thought of was horribly inefficient. Only
	 * after looking up for a more efficient implementation did I manage to finish this problem quickly.
	 * Problem solved
	 * 7265th person to have solved this problem
	 * Problem level: 15
	 * Runtime: 1 second
	 * */
}
