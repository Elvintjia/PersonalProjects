package eulerProject1To30;

public class Problem26 {
	public static String recurringCycleLength(int divisor) {
		int dividend = 10;
		String quotient = "";
		for (; dividend < divisor; dividend *= 10) {}
		for (int i = 1; i <= 10000 ;i++) {
			if (dividend % divisor == 0) {
				return divisor + " " + 0;
			}
			quotient += dividend / divisor;
			dividend = dividend % divisor;
			if (i % 2 == 0) {
				if (quotient.substring(0, i / 2).contentEquals(quotient.substring(i / 2))) {
					return divisor + " " + (quotient.length() / 2);
				}
			}
			dividend *= 10;
		}
		return divisor + " " + 0;
	}
	
	public static void main(String[] args) {
		String longestRecurringCycleLength = "0 0";
		for (int i = 1; i < 1000; i++) {
			String comparison = recurringCycleLength(i);
			if (Integer.valueOf(longestRecurringCycleLength.substring(longestRecurringCycleLength.indexOf(' ') + 1)) <
					Integer.valueOf(comparison.substring(comparison.indexOf(' ') + 1))) {
				longestRecurringCycleLength = comparison;
			}
		}
		System.out.println("Ausgabe: " +
		longestRecurringCycleLength.substring(0, longestRecurringCycleLength.indexOf(' ')));
		
		/*
		 * Problem solved
		 * 91242nd person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
