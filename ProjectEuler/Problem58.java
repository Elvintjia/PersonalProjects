package eulerProject31To60;

public class Problem58 {
	public static boolean isPrime(long eingabe) {
		for (int i = 2; i * i <= eingabe; i++) {
			if (eingabe % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long corner = 9;
		long side = 3;
		long primes = 3;
		while ((float) primes / (side * 2 - 1) > 0.1) {
			for (int i = 1; i <= 4; i++) {
				corner += side + 1;
				if (isPrime(corner)) {
					primes++;
				}
			}
			side += 2;
		}
		System.out.println("Ausgabe: " + side);
	}
	
	/*
	 * Problem solved
	 * 44131st person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
