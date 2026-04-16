package eulerProject61to90;

public class Problem64 {
	public static boolean oddPeriod(long input) {
		long maxi = (long) (Math.sqrt(input));
		long count = 0;
		long divider = 0;
		long divisor = 1;
		long constant = maxi;
		for (count = 0; true; count++) {
			divider = (input - (constant * constant));
			if (divisor == divider) {
				count++;
				break;
			}
			if (divider % divisor == 0) {
				divider /= divisor;
				divisor = 1;
			}
			while (constant >= - maxi) {
				constant -= divider;
			}
			constant += divider;
			constant = Math.abs(constant);
			divisor = divider;
		};
		return (count % 2 == 1);
	}
	
	public static void main(String[] args) {
		long count = 0;
		for (long i = 1; i <= 10000; i++) {
			double squareRoot = Math.sqrt(i);
			if (Math.ceil(squareRoot) == Math.floor(squareRoot)) {
				continue;
			} else if (oddPeriod(i)) {
				count++;
			}
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/*
	 * Problem solved
	 * 24707th person to have solved this problem
	 * Difficulty rating: 20%
	 * */
}
