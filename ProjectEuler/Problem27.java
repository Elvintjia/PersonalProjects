package eulerProject1To30;

public class Problem27 {
	public static void main(String[] args) {
		long[] primeNumbers = new long[2000];
		primeNumbers[0] = 2;
		long checkPrime;
		for (int i = 1; i < primeNumbers.length ; i++) {
			checkPrime = primeNumbers[i - 1] + 1;
			while (true) {
				boolean isPrime = true;
				for (int j = 0; primeNumbers[j] * primeNumbers[j] <= checkPrime; j++) {
					if (checkPrime % primeNumbers[j] == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					break;
				} else {
					checkPrime++;
				}
			}
			primeNumbers[i] = checkPrime;
		}
		String primeNumbersString = " ";
		for (int i = 0; i < 2000; i++) {
			primeNumbersString += primeNumbers[i] + " ";
		}
		long[] ergebnis = {-1000, -1001, 0};
		for (int a = -999; a <= 999; a++) {
			for (int b = -1000; b <= 1000; b++) {
				for (int n = 0; ;n++) {
					if (!(primeNumbersString.contains(" " + ((n * n) + (n * a) + b) + " "))) {
						if (n > ergebnis[2]) {
							ergebnis[0] = a;
							ergebnis[1] = b;
							ergebnis[2] = n;
						}
						break;
					}
				}
			}
		}
		System.out.println("Ausgabe: " + (ergebnis[0] * ergebnis[1]));
		
		/*
		 * Problem solved
		 * 94700th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
