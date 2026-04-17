package eulerProject91to120;

public class Problem97 {
	public static void main(String[] args) {
		long x = 28433;
		for (int i = 1 ; i <= 7830457; i++) {
			x *= 2;
			x = x % 10000000000l;
		}
		x++;
		System.out.println("Ausgabe " + x);
	}
	
	/*
	 * Problem solved
	 * 47128th person to have solved this problem
	 * Difficulty rating: 5%
	 * Runtime: 1 second
	 * */
}
