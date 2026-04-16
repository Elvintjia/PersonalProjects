package eulerProject1To30;

public class Problem17 {
	public static long checkNumbers(int number) {
		if (number < 10) {
			return oneDigit(number);
		} else if (number < 100) {
			return twoDigits(number);
		} else if (number < 1000) {
			return threeDigits(number);
		}
		return 11;
	}
	
	public static long oneDigit(int num) {
		if (num <= 2 || num == 6) {
			return 3;
		} else if (num == 4 || num == 5 || num == 9) {
			return 4;
		}
		return 5;
	}
	
	public static long twoDigits(int num) {
		if (num < 20) {
			if (num == 10) {
				return 3;
			} else if (num == 11 || num == 12) {
				return 6;
			} else if (num == 15 || num == 16) {
				return 7;
			} else if (num == 17) {
				return 9;
			} else {
				return 8;
			}
		} else {
			int lastDigit = num % 10;
			long returning = 0;
			if (num >= 80 || num < 40) {
				returning =  6;
			} else if (num / 10 == 7) {
				returning = 7;
			} else {
				returning = 5;
			}
			if (lastDigit > 0) {
				return returning + oneDigit(lastDigit);
			} else {
				return returning;
			}
		}
	}
	
	public static long threeDigits(int num) {
		int lastTwoDigits = num % 100;
		return oneDigit(num / 100) + 7 + (lastTwoDigits > 0 ? 3 + (lastTwoDigits < 10 ? oneDigit(lastTwoDigits) : twoDigits(lastTwoDigits)) : 0);
	}
	
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += checkNumbers(i);
		}
		System.out.println("Ausgabe: " + sum);
		
		/*
		 * Problem solved
		 * 162617th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
