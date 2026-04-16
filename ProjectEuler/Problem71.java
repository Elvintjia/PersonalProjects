package eulerProject61to90;

public class Problem71 {
	public static boolean commonDivider(long a, long b) {
		long temp = 0;
		if (a > b) {
			temp = b;
		} else {
			temp = a;
		}
		for (int i = 2; i <= temp; i++) {
			if (a % i == 0 && b % i == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		long[] fraction = {1, 1000000};
		for (int i = 1; i <= 1000000; i++) {
			// System.out.println(i);
			if (i % 7 == 0) {
				continue;
			}
			long[] temp = {i * 3 / 7, i};
			// System.out.println(temp[0] + " / " + temp[1]);
			if (fraction[0] * i < fraction[1] * temp[0] && !commonDivider(temp[0], temp[1])) {
				fraction = temp;
			}
		}
		// System.out.println(fraction[1]);
		System.out.println("Ausgabe: " + fraction[0]);
	}
	
	/* Remark: My program needed about 3 minutes to fully compile, but I think I don't need to make it more efficient.
	 * Problem solved
	 * 32343rd person to have solved this problem
	 * Difficulty rating: 10%
	 * */
}
