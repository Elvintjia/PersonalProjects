package eulerProject1To30;

public class Problem7 {
	public static boolean isPrime(long Zahl) {
		for (int i = 2; i * i <= Zahl; i++) {
			if (Zahl % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long Zahl = (long) 2;
		for (int i = 1; i <= 10001; i++) {
			while (true) {
				if (isPrime(Zahl)) {
					break;
				}
				Zahl++;
			}
			if (i == 10001) {
				System.out.println("Ausgabe: " + Zahl);
			} else {
				Zahl++;
			}
		}
 	}
	
	/*
	 * Problem solved
	 * 445775th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
