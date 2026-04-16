package eulerProject31To60;

public class Problem51 {
	public static boolean isPrime(long input) {
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean check(String input) {
		int x = 0;
		for (int i = 0; i <= 9; i++) {
			if (isPrime(Long.valueOf(input.replace('*', (char) (i + '0'))))) {
				x++;
			}
		}
		return (x == 8);
	}
	
	public static String base11(long input) {
		char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*'};
		if (input < 11) {
			return "" + array[(int) input];
		} else {
			return base11(input / 11) + array[(int) (input % 11)];
		}
	}
	
	public static void main(String[] args) {
		String toBeChecked = "";
		for (long token = 1; true; token++) {
			toBeChecked = base11(token);
			if (!toBeChecked.contains("*")) {
				continue;
			} if (check(toBeChecked)) {
				 break;
			 }
		}
		for (long i = 0; i <= 9; i++) {
			String result = toBeChecked.replace("*", "" + i);
			if (isPrime(Long.valueOf(result))) {
				toBeChecked = result;
				break;
			}
		}
		System.out.println("Ausgabe: " + toBeChecked);
	}
	
	/*
	 * Problem solved
	 * 37974th person to have solved this problem
	 * Difficulty rating: 15%
	 * */
}
