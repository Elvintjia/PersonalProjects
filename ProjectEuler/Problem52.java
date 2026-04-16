package eulerProject31To60;

public class Problem52 {
	public static boolean compare(long a, long b) {
		String stringA = "" + a;
		String stringB = "" + b;
		if (stringA.length() != stringB.length()) {
			return false;
		}
		boolean[] array = new boolean[stringB.length()];
		for (int i = 0; i < stringA.length(); i++) {
			for (int j = 0; j < stringA.length(); j++) {
				if (stringA.charAt(i) == stringB.charAt(j)) {
					array[j] = true;
					break;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (!array[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long x = 1;
		for (; true; x++) {
			boolean answerFound = true;
			for (int j = 2; j <= 6; j++) {
				if (!compare(x, x * j)) {
					answerFound = false;
					break;
				}
			}
			if (answerFound) {
				break;
			}
		}
		System.out.println("Ausgabe: " + x);
	}
	
	/*
	 * Problem solved
	 * 70918th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
