package eulerProject1To30;

public class Problem14 {
	public static void main(String[] args) {
		long longestChainNumber = 0;
		long longestChainLength = 0;
		for (int i = 1; i < 1000000; i++) {
			long currentNumber = i;
			long currentChainLength = 0;
			while (true) {
				currentChainLength++;
				if (currentNumber == 1) {
					if (longestChainLength < currentChainLength) {
						longestChainLength = currentChainLength;
						longestChainNumber = i;
					}
					break;
				} else if (currentNumber % 2 == 0) {
					currentNumber /= 2;
				} else {
					currentNumber = currentNumber * 3 + 1;
				}
			}
		}
		System.out.println("Ausgabe: " + longestChainNumber);
		
		/*
		 * Problem solved
		 * 242106th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
