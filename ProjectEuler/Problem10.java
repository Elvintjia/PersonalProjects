package eulerProject1To30;

public class Problem10 {
	public static boolean isPrime(long Zahl) {
		for (long i = 2; i * i <= Zahl; i++) {
			if (Zahl % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long Summe = 0;
		for (long i = 2; i < 2000000; i++) {
			if (isPrime(i)) {
				Summe += i;
			}
		}
		System.out.println("Ausgabe: " + Summe);
		
		/*
		 * Problem solved
		 * 347787th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
