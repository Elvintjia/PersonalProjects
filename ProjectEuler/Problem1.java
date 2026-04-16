package eulerProject1To30;

public class Problem1 {
	public static void main(String[] args) {
		int Summe = 0;
		for (int i = 1; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				Summe += i;
			}
		}
		System.out.println("Ausgabe: " + Summe);
		
		/*
		 * Problem solved
		 * 1015243rd person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
