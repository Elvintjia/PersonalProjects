package eulerProject91to120;

public class Problem109 {
	public static int darts(int input) {
		int toReturn = 0;
		if (checkoutPossible(input)) {
			
			toReturn++;
		}
		for (int i = 1; i <= 21; i++) {
			if (i == 21) {
				i = 25;
			}
			for (int j = 1; (j <= 3 && i <= 20) || (i == 25 && j <= 2); j++) {
				if (checkoutPossible(input - i * j)) {
					toReturn++;
				}
			}
		}
		for (int i = 1; i <= 21; i++) {
			if (i == 21) {
				i = 25;
			}
			for (int j = 1; (j <= 3 && i <= 20) || (i == 25 && j <= 2); j++) {
				for (int k = j; (k <= 3 && i <= 20) || (i == 25 && k <= 2); k++) {
					if (checkoutPossible(input - i * (j + k))) {
						toReturn++;
					}
				}
			}
		}
		for (int i = 1; i <= 21; i++) {
			if (i == 21) {
				i = 25;
			}
			for (int j = 1; (j <= 3 && i <= 20) || (j <= 2 && i == 25); j++) {
				for (int k = i + 1; k <= 21; k++) {
					if (k == 21) {
						k = 25;
					}
					for (int l = 1; (l <= 3 && k <= 20) || (k == 25 && l <= 2); l++) {
						if (checkoutPossible(input - (i * j) - (k * l))) {
							toReturn++;
						}
					}
				}
			}
		}
		return toReturn;
	}
	
	public static boolean checkoutPossible(int input) {
		return (input > 0 && input <= 40 && input % 2 == 0) || input == 50;
	}
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 100; i++) {
			sum += darts(i);
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/*
	 * Problem solved
	 * 9298th person to have solved this problem
	 * Difficulty rating: 45%
	 * Runtime: 1 second
	 * */
}
