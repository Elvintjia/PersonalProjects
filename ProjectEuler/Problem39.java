package eulerProject31To60;

public class Problem39 {
	public static boolean isTriangle(long one, long two, long three) {
		return one + two > three;
	}
	
	public static boolean isRightAngleTriangle(long one, long two, long three) {
		return (one * one) + (two * two) == three * three;
	}
	
	public static void main(String[] args) {
		long p = 0;
		long solution = 0;
		for (long i = 3; i <= 1000; i++) {
			long temp = 0;
			for (long j = 1; j < i; j++) {
				for (long k = j; k < i; k++) {
					if (isTriangle(j, k, i - j - k) && isRightAngleTriangle(j, k, i - j - k)) {
						temp++;
					}
				}
			}
			if (temp > solution) {
				p = i;
				solution = temp;
			}
		}
		System.out.println("Ausgabe: " + p);
	}
	
	/*
	 * Problem solved
	 * 79477th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
