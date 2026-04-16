package eulerProject1To30;

public class Problem23 {
	public static boolean isAbundantNumber(int input) {
		int divisorSum = 0;
		for (int i = 1; i < input; i++) {
			if (input % i == 0) {
				divisorSum += i;
			}
		}
		if (divisorSum > input) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int[] abundantNumbers = new int[28123];
		int index = 0;
		for (int i = 1; i <= 28123; i++) {
			if (isAbundantNumber(i)) {
				abundantNumbers[index] = i;
				index++;
			}
		}
		int grosste = 0;
		for (int i = 0; abundantNumbers[i] != 0; i++) {
			grosste = abundantNumbers[i];
		}
		long sum = 0;
		for (int i = 1; i <= 28123; i++) {
			boolean isSumOfTwoAbundantNumbers = false;
			for (int j = 0; abundantNumbers[j] != 0; j++) {
				if (abundantNumbers[j] >= i || abundantNumbers[j] + grosste < i) {
					continue;
				} else if (abundantNumbers[j] + grosste == i) {
					break;
				}
				for (int k = 0; abundantNumbers[k] != 0; k++) {
					if (abundantNumbers[j] + abundantNumbers[k] == i) {
						isSumOfTwoAbundantNumbers = true;
					} else if (abundantNumbers[j] + abundantNumbers[k] > i) {
						break;
					}
				}
			}
			if (!isSumOfTwoAbundantNumbers) {
				sum += i;
				/*
				System.out.println(i);
				*/
			}
		}
		/*
		for (int i = 0; i <= 10; i++) {
			System.out.println(abundantNumbers[i]);
		}
		*/
		System.out.println("Ausgabe: " + sum);
		
		/*
		 * Problem solved
		 * 112768th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
