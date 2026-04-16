package eulerProject1To30;

public class Problem2 {
	public static void main(String[] args) {
		double Previous = 1;
		double Current = 1;
		double Summe = 0;
		for (double i = 2; i <= 4000000; i += Previous) {
			Previous = Current;
			if (i % 2 == 0) {
				Summe += i;
			}
			Current = i;
		}
		System.out.println("Ausgabe: " + Summe);
		
		/*
		 * Problem solved
		 * 808930th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
