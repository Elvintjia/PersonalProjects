package eulerProject1To30;

public class Problem5 {
	public static void main(String[] args) {
		boolean correct = true;
		for (int i = 20; correct; i++) {
			for (int j = 1; j <= 20; j++) {
				if (i % j != 0) {
					break;
				}
				if (j == 20) {
					correct = false;
				}
			}
			if (!correct) {
				System.out.println("Ausgabe: " + i);
			}
		}
		
		/*
		 * Problem solved
		 * 517618th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
