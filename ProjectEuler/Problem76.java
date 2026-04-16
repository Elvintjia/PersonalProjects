package eulerProject61to90;

public class Problem76 {
	public static long countingSummation(long input, long biggest) {
		if (input == 0) {
			return 1;
		} else if (input < 0) {
			return 0;
		} else {
			long sum = 0;
			for (int i = 1; i <= biggest; i++) {
				// System.out.println(i);
				sum += countingSummation(input - i, i);
			}
			return sum;
		}
	}
	
	public static void main(String[] args) {
		long input = 100;
		System.out.println("Ausgabe: " + countingSummation(input, input - 1));
	}
	
	/*
	 * Problem solved
	 * 31531st person to have solved this problem
	 * Difficulty rating: 10%
	 * */
}
