package eulerProject61to90;

public class Problem73 {
	public static boolean commonDivider(long a, long b) {
		long smallest = Math.min(a, b);
		for (int i = 2; i <= smallest; i++) {
			if (a % i == 0 && b % i == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		long count = 0;
		for (int i = 2; i <= 12000; i++) {
			// System.out.println(i);
			for (int j = (i / 3) + 1; j <= i / 2; j++) {
				if (!commonDivider(i, j) && j * 2 != i) {
					// System.out.println(j + " / " + i);
					count++;
				}
			}
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/* Remark: This takes a little over a minute, but it works efficiently enough.
	 * Problem solved
	 * 27689th person to have solved this problem
	 * Difficulty rating: 15%
	 * */
}
