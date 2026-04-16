package eulerProject1To30;

public class Problem21 {
	public static long sumOfProperDivisors(long input) {
		long sum = 0;
		for (int i = 1; i < input; i++) {
			if (input % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		String usedNumbers = " ";
		long sum = 0;
		for (long i = 1; i <= 10000; i++) {
			if (usedNumbers.contains(" " + i + " ")) {
				continue;
			}
			long secondNumber = sumOfProperDivisors(i);
			if (secondNumber != i && !(usedNumbers.contains(" " + secondNumber + " "))) {
				long sumOfProperDivisorsOfI = sumOfProperDivisors(secondNumber);
				if (i == sumOfProperDivisorsOfI) {
					sum += i + secondNumber;
					usedNumbers += i + " " + secondNumber + " ";
				}
			}
		}
		System.out.println("Ausgabe: " + sum);
		
		/*
		 * Problem solved
		 * 157042nd person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
