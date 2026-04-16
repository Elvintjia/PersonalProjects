package eulerProject1To30;

public class Problem24 {
	public static void main(String[] args) {
		int counter = 0;
		String ergebnis = "";
		long number = 0;
		
		while (counter < 1000000) {
			number++;
			ergebnis = number + "";
			while (ergebnis.length() < 10) {
				ergebnis = "0" + ergebnis;
			}
			boolean allDigitsPresent = true;
			for (int i = 0; i < 10; i++) {
				if (!ergebnis.contains("" + i)) {
					allDigitsPresent = false;
					break;
				}
			}
			if (allDigitsPresent) {
				counter++;
			}
		}
		System.out.println("Ausgabe: " + ergebnis);
		
		/*
		 * Problem solved
		 * 123529th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
