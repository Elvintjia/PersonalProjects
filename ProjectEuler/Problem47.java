package eulerProject31To60;

public class Problem47 {
	public static boolean haveFourDistinctPrimeFactors(long num) {
		long counter = 0;
		for (long i = 2; i <= num; i++) {
			if (num % i == 0) {
				counter++;
				while (num % i == 0) {
					num /= i;
				}
				i = 2;
			}
		}
		return (counter == 4);
	}
	
	public static void main(String[] args) {
		long num = 1000;
		while (true) {
			if (haveFourDistinctPrimeFactors(num) &&
					haveFourDistinctPrimeFactors(num + 1) &&
					haveFourDistinctPrimeFactors(num + 2) &&
					haveFourDistinctPrimeFactors(num + 3)) {
				break;
			}
			num++;
		}
		System.out.println("Ausgabe: " + num);
	}
	
	/*
	 * Problem solved
	 * 63521st person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
