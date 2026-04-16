package eulerProject1To30;

public class Problem9 {
	public static void main(String[] args) {
		boolean check = true;
		for (int i = 1; i <= 998 && check; i++) {
			for (int j = 1; j <= 998 && check; j++) {
				for (int k = 1; k <= 998 && check; k++) {
					if (i + j + k == 1000 && i * i + j * j == k * k) {
						System.out.println("Ausgabe: " + (i * j * k));
						check = false;
					}
				}
			}
		}
		
		/*
		 * Problem solved
		 * 378820th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
