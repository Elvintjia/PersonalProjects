package eulerProject31To60;

public class Problem41 {
	public static boolean isPandigital(long eingabe) {
		String stringEingabe = eingabe + "";
		if (stringEingabe.contains("0")) {
			return false;
		}
		int[] array = new int[stringEingabe.length()];
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
		for (int i = 0; i < stringEingabe.length(); i++) {
			int checkInt = Integer.valueOf("" + stringEingabe.charAt(i));
			if (checkInt > stringEingabe.length()) {
				return false;
			}
			array[checkInt - 1] += 1;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 1) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(long eingabe) {
		for (int i = 2; i * i <= eingabe; i++) {
			if (eingabe % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long ergebnis = 0;
		for (long i = 10000000; i != 0; i--) {
			if (isPrime(i) && isPandigital(i)) {
				ergebnis = i;
				break;
			}
		}
		System.out.println("Ausgabe: " + ergebnis);
	}
	
	/*
	 * Problem solved
	 * 74324th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
