package eulerProject61to90;

public class Problem77 {
	public static boolean isPrime(long input) {
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static long primeSummations(long input, long biggest) {
		if (input < 0) {
			return 0;
		} else if (input == 0) {
			return 1;
		} else {
			long sum = 0;
			for (int i = 2; i <= biggest; i++) {
				if (isPrime(i)) {
					sum += primeSummations(input - i, i);
				}
			}
			return sum;
		}
	}
	
	public static void main(String[] args) {
		long input = 10;
		while (primeSummations(input, input - 1) <= 5000) {
			input++;
		}
		System.out.println("Ausgabe: " + input);
	}
	
	/* Remark: The problem isn't hard at all, so I don't understand the difficulty rating. I solved it very quickly and with
	 * little complication.
	 * Problem solved
	 * 21529th person to have solved this problem
	 * Difficulty rating: 25%
	 * */
}
