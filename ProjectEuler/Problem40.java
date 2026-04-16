package eulerProject31To60;

public class Problem40 {
	public static long longLength(long eingabe) {
		return (eingabe + "").length();
	}
	public static long narrowCount(long eingabe) {
		if (eingabe <= 9) {
			return eingabe;
		}
		long currentDigit = 10;
		long currentDigitCount = 9;
		while (currentDigitCount < eingabe) {
			currentDigitCount += currentDigit * 9 * longLength(currentDigit);
			currentDigit *= 10;
		}
		return narrowCountFurtherTwo(eingabe, currentDigit / 10, currentDigitCount / (9 * longLength(currentDigit / 10)));
	}
	
	public static long narrowCountFurther(long eingabe, long currentDigit, long currentDigitCount) {
		// System.out.println(eingabe + "; " + currentDigit + "; " + currentDigitCount);
		if (eingabe > currentDigitCount) {
			return narrowCountFurther(eingabe, currentDigit + 1, currentDigitCount + longLength(currentDigit));
		} else if (eingabe == currentDigitCount) {
			return Long.valueOf("" + (currentDigit + "").charAt(0));
		} else {
			return Long.valueOf("" + ((currentDigit - 1) +
					"").charAt((int) (longLength(currentDigit) - (currentDigitCount - eingabe))));
		}
	}
	
	public static long narrowCountFurtherTwo(long eingabe, long currentDigit, long currentDigitCount) {
		long neededLength = eingabe - currentDigitCount;
		if (neededLength == 0) {
			return Long.valueOf("" + ("" + currentDigit).charAt(0));
		}
		String sequence = "";
		while (neededLength + 1 > sequence.length()) {
			sequence += currentDigit;
			currentDigit++;
		}
		return Long.valueOf("" + sequence.charAt((int) neededLength));
	}
	
	public static void main(String[] args) {
		long ergebnis = 1;
		long digit = 1;
		String number = "";
		while (number.length() <= 1e6 + 1) {
			number += digit;
			digit++;
		}
		for (int i = 1; i <= 1e6 + 1; i *= 10) {
			ergebnis *= Long.valueOf("" + number.charAt(i - 1));
		}
		System.out.println("Ausgabe: " + ergebnis);
	}
	
	/* Remark: I spent way too long trying to solve this, even though the solution isn't that hard. I want to make my code
	 * efficient, even though it's not necessary to do so.
	 * Problem solved
	 * 86706th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
