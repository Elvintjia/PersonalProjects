package eulerProject31To60;

public class Problem49 {
	public static boolean isPrime(long input) {
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean permutation(long a, long b) {
		String stringA = a + "";
		String stringB = b + "";
		if (stringA.length() != stringB.length()) {
			return false;
		}
		boolean[] arrayA = new boolean[stringA.length()];
		boolean[] arrayB = new boolean[stringB.length()];
		for (int i = 0; i < stringA.length(); i++) {
			for (int j = 0; j < stringB.length(); j++) {
				if (stringA.charAt(i) == stringB.codePointAt(j) && !(arrayA[i]) && !(arrayB[j])) {
					arrayA[i] = true;
					arrayB[j] = true;
					break;
				}
			}
		}
		for(int i = 0; i < arrayA.length; i++) {
			if (!arrayA[i] || !arrayB[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long num = 1000;
		long increase = 1;
		boolean sequenceFound = false;
		while (!sequenceFound) {
			if (num == 1487) {
				num++;
				continue;
			}
			for (; num + (increase * 2) <= 9999; increase++) {
				long num2 = num + increase;
				long num3 = num2 + increase;
				if (isPrime(num) && isPrime(num2) && isPrime (num3) && permutation(num, num2) && permutation(num, num3)) {
					sequenceFound = true;
					break;
				}
			}
			if (!sequenceFound) {
				increase = 1;
				num++;
			}
		}
		System.out.println("Ausgabe: " + num + (num + increase) + (num + (2 * increase)));
	}
	
	/*
	 * Problem solved
	 * 63359th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
