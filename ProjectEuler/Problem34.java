package eulerProject31To60;

public class Problem34 {
	public static long factorial(long eingabe) {
		if (eingabe == 0) {
			return 1;
		} else {
			return eingabe * factorial(eingabe - 1);
		}
	}
	
	public static long check(long eingabe) {
		long total = 0;
		for (long i = 1; i <= eingabe; i *= 10) {
			total += factorial((eingabe / i) % 10);
		}
		if (total == eingabe) {
			return total;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		long total = 0;
		for (long i = 10; i <= 999999; i++) {
			total += check(i);
		}
		System.out.println("Ausgabe: " + total);
	}
	
	/*
	 * Problem solved
	 * 101941st person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
