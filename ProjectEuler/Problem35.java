package eulerProject31To60;

public class Problem35 {
	public static boolean isPrime(long eingabe) {
		for (long i = 2; i * i <= eingabe; i++) {
			if (eingabe % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static long check(long eingabe) {
		String stringEingabe = "" + eingabe;
		if (eingabe < 10) {
			if (isPrime(eingabe)) {
				return eingabe;
			} else {
				return 0;
			}
		}
		for (int i = 0; i < stringEingabe.length(); i++) {
			stringEingabe = stringEingabe.substring(1) + stringEingabe.charAt(0);
			if (!(isPrime(Long.valueOf(stringEingabe)))) {
				return 0;
			}
		}
		return eingabe;
	}
	
	public static void main(String[] args) {
		int count = 0;
		for (int i = 2; i < 1e6; i++) {
			if (check(i) > 0) {
				count++;
			}
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/*
	 * Problem solved
	 * 91830th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
