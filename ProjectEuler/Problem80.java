package eulerProject61to90;

import java.math.BigDecimal;
import java.math.MathContext;

public class Problem80 {
	public static void main(String[] args) {
		BigDecimal n = BigDecimal.ONE;
		long sum = 0;
		while (n.compareTo(new BigDecimal(100)) == -1) {
			// System.out.println(n);
			int nInt = n.intValue();
			boolean skip = false;
			for (int i = 1; i * i <= nInt; i++) {
				if (i * i == nInt) {
					n = n.add(BigDecimal.ONE);
					skip = true;
					break;
				}
			}
			if (skip) {
				continue;
			}
			String temp = "" + n.sqrt(new MathContext(110));
			/*
			while (temp.charAt(0) != '.') {
				temp = temp.substring(1);
			}
			temp = temp.substring(1);
			*/
			for (int i = 0; i < 100; i++) {
				if (temp.charAt(0) == '.') {
					temp = temp.substring(1);
				}
				sum += Long.valueOf(temp.charAt(0) + "");
				temp = temp.substring(1);
			}
			n = n.add(BigDecimal.ONE);
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/*
	 * Problem solved
	 * 22125th person to have solved this problem
	 * Difficulty rating: 20%
	 * Runtime: Less than 1 second
	 * */
}
