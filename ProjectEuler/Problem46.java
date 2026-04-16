package eulerProject31To60;

public class Problem46 {
	public static boolean isComposite(long eingabe) {
		for (int i = 2; i * i <= eingabe; i++) {
			if (eingabe % i == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPrime(long eingabe) {
		return !(isComposite(eingabe));
	}
	
	public static void main(String[] args) {
		long num = 15;
		while (true) {
			if (isPrime(num)) {
				num += 2;
				continue;
			}
			boolean conjecture = false;
			for (int i = 1; i * i * 2 <= num; i++) {
				if (isPrime(num - (i * i * 2))) {
					conjecture = true;
					break;
				}
			}
			if (!conjecture) {
				break;
			}
			num += 2;
		}
		System.out.println("Ausgabe: " + num);
	}
	
	/*
	 * Problem solved
	 * 67465th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
