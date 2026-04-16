package eulerProject31To60;

public class Problem37 {
	public static boolean isPrime(long eingabe) {
		if (eingabe == 1) {
			return false;
		}
		for (int i = 2; i * i <= eingabe; i++) {
			if (eingabe % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static long check(long eingabe) {
		if (!(isPrime(eingabe))) {
			return 0;
		}
		long left = eingabe;
		long right = eingabe;
		while (left >= 10) {
			left = left(left);
			right = right(right);
			if (!(isPrime(left)) || !(isPrime(right))) {
				return 0;
			}
		}
		return eingabe;
	}
	
	public static long left(long eingabe) {
		return eingabe / 10;
	}
	
	public static long right(long eingabe) {
		long i = 1;
		for (; i <= eingabe; i *= 10) {
			
		}
		i /= 10;
		eingabe = eingabe % i;
		return eingabe;
	}
	
	public static void main(String[] args) {
		int count = 0;
		long sum = 0;
		for (long i = 10; count <= 10; i++) {
			long checked = check(i);
			if (checked > 0) {
				System.out.println(checked);
				sum += checked;
				count++;
			}
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/*
	 * Problem solved
	 * 79990th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
