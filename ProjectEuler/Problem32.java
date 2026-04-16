package eulerProject31To60;

public class Problem32 {
	public static long checkPandigital(long multiplier, long multiplicand, long[] liste) {
		long product = multiplier * multiplicand;
		for (int i = 0; i < liste.length; i++) {
			if (product == liste[i]) {
				return 0;
			}
		}
		char[] charList = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int[] occurrenceNumber = new int[9];
		String stringMultiplier = "" + multiplier;
		for (int i = 0; i < stringMultiplier.length(); i++) {
			char character = stringMultiplier.charAt(i);
			for (int j = 0; j < charList.length; j++) {
				if (character == charList[j]) {
					occurrenceNumber[j]++;
					break;
				}
			}
		}
		String stringMultiplicand = "" + multiplicand;
		for (int i = 0; i < stringMultiplicand.length(); i++) {
			char character = stringMultiplicand.charAt(i);
			for (int j = 0; j < charList.length; j++) {
				if (character == charList[j]) {
					occurrenceNumber[j]++;
					break;
				}
			}
		}
		String stringProduct = "" + product;
		for (int i = 0; i < stringProduct.length(); i++) {
			char character = stringProduct.charAt(i);
			for (int j = 0; j < charList.length; j++) {
				if (character == charList[j]) {
					occurrenceNumber[j]++;
					break;
				}
			}
		}
		if (stringMultiplier.contains("0") || stringMultiplicand.contains("0") || stringProduct.contains("0")) {
			return 0;
		}
		for (int i = 0; i < occurrenceNumber.length; i++) {
			if (occurrenceNumber[i] != 1) {
				return 0;
			}
		}
		return product;
	}
	
	public static void main(String[] args) {
		long total = 0;
		long[] already = new long[100];
		int index = 0;
		for (int i = 0; i <= 10000; i++) {
			for (int j = 0; j <= 10000; j++) {
				long ergebnis = checkPandigital(i, j, already);
				if (ergebnis > 0) {
					already[index] = ergebnis;
					index++;
					total += ergebnis;
				}
			}
		}
		System.out.println("Ausgabe: " + total);
	}
	
	/*
	 * Problem solved
	 * 77770th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
