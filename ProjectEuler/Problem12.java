package eulerProject1To30;

public class Problem12 {
	public static int divisor(long Zahl) {
		int Summe = 0;
		for (int i = 1; i <= Zahl / 2; i++) {
			if (Zahl % i == 0) {
				Summe++;
			}
		}
		return Summe;
	}
	
	public static void main(String[] args) {
		long Ausgabe = 0;
		for (long i = 1; true; i++) {
			Ausgabe += i;
			if (Ausgabe < 500) {
				continue;
			}
			/*
			if (i % 100 != 0) {
				continue;
			}
			*/
			if (divisor(Ausgabe) > 500) {
				/*
				Ausgabe -= i;
				while (divisor(Ausgabe) <= 500) {
					i--;
					Ausgabe -= i;
				}
				*/
				System.out.println("Ausgabe: " + Ausgabe);
				break;
			}
		}
		
		/* Comment: This code is very inefficient, but I don't see how else I could do this.
		 * Problem solved
		 * 236395th person to have solved this problem
		 * Difficulty ratingL 5%
		 * */
	}
}
