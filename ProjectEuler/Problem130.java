package eulerProject121to150;

public class Problem130 {
	public static int repunitDivisible(int n) {
		if (n % 2 == 0 || n % 5 == 0) {
			return 0;
		}
		int toReturn = 1;
		int remainder = 1;
		while (remainder > 0) {
			if (remainder >= n) {
				remainder -= n;
			} else {
				remainder = remainder * 10 + 1;
				toReturn++;
			}
		}
		return toReturn;
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int compositesWithPrimeRepunitProperty(int n) {
		int toReturn = 0;
		int current = 3;
		while (n > 0) {
			while (current % 5 == 0 || isPrime(current)) {
				current += 2;
			}
			int repunit = repunitDivisible(current);
			if ((current - 1) % repunit == 0) {
				toReturn += current;
				n--;
			}
			current += 2;
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + compositesWithPrimeRepunitProperty(25));
	}
	
	/*
	 * Problem solved
	 * 6809th person to have solved this problem
	 * Problem level: 14
	 * Runtime: 1 second
	 * */
}
