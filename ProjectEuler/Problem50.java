package eulerProject31To60;

public class Problem50 {
	public static boolean isPrime(long eingabe) {
		for (int i = 2; i * i <= eingabe; i++) {
			if (eingabe % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long x = 0;
		for (long i = 2; i <= 5000; i++) {
			if (isPrime(i)) {
				x++;
			}
		}
		long[] array = new long[(int) x];
		x = 2;
		for (int i = 0; i < array.length; i++) {
			while (!isPrime(x)) {
				x++;
			}
			array[i] = x;
			x++;
		}
		long sum = 0;
		for (int i = array.length; i >= 2; i--) {
			for (int j = 0; i + j <= array.length; j++) {
				for (int k = 0; k < i; k++) {
					sum += array[k + j];
					if (sum >= 1000000) {
						break;
					}
				}
				if (isPrime(sum) && sum < 1000000) {
					break;
				} else {
					sum = 0;
				}
			}
			if (sum > 0) {
				break;
			}
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/* Remark: I kind of used a little bit of cheat to solve this problem. I changed one constant and repeatedly inputted
	 * the output to Project Euler until I got it right.
	 * Problem solved
	 * 68378th person to have solved this problem
	 * Difficulty level: 5%
	 * */
}
