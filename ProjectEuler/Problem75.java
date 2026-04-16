package eulerProject61to90;

public class Problem75 {
	public static boolean rightAngleTriangle(long input) {
		for (long i = input / 2; i >= input / 3; i--) {
			for (long j = i - 1; j >= input / 3; j--) {
				long temp = input - i - j;
				// System.out.println(i + " " + j + " " + temp);
				if (i * i == temp * temp + j * j) {
					if (!commonDivider(i, j, temp)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean commonDivider(long a, long b, long c) {
		for (int k = 2; k * k <= c; k++) {
			if (a % k == 0 && b % k == 0 && c % k == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		long[] erastothenesSieve = new long[1500000];
		boolean[] array = new boolean[1500000];
		// System.out.println(array[100]);
		long m = 2;
		long n = 1;
		while (true) {
			long sum = 2 * m * (m + n);
			if (sum > erastothenesSieve.length * 10) {
				break;
			} else if (sum <= erastothenesSieve.length) {
				long a = m * m - n * n;
				long b = 2 * m * n;
				long c = m * m + n * n;
				if ((!array[(int) sum - 1]) && !commonDivider(a, b, c)) {
					array[(int) sum - 1] = true;
					for (int i = (int) sum - 1; i < erastothenesSieve.length; i += sum) {
						erastothenesSieve[i]++;
					}
				}
			}
			n++;
			if (m == n) {
				m++;
				n = 1;
			}
		}
		long count = 0;
		for (int i = 0; i < erastothenesSieve.length; i++) {
			if (erastothenesSieve[i] == 1) {
				count++;
			}
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/* Remark: This problem took way more time than I hoped it would. I even had to search in Google to help me look for a
	 * solution, but the result is a program that runs in less than 5 seconds to work. Pretty good, I'd say.
	 * Problem solved
	 * 20253rd person to have solved this problem
	 * Difficulty rating: 25%
	 * */
}
