package eulerProject31To60;

public class Problem60 {
	static boolean finish = false;
	
	public static boolean isPrime(long input) {
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrimePairSet(long[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (i != j && !(isPrime(Long.valueOf(input[i] + "" + input[j])))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void narrowDown(long[] array, int counter, long[] result) {
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			long[] temp = {result[counter], array[i]};
			if (isPrimePairSet(temp)) {
				index++;
			}
		}
		if (index == 0 || finish) {
			return;
		}
		long[] array2 = new long[index];
		index = 0;
		for (int i = 0; i < array.length; i++) {
			long[] temp = {result[counter], array[i]};
			if (isPrimePairSet(temp)) {
				array2[index] = array[i];
				index++;
			}
		}
		if (counter == 3 && array2.length == 1) {
			result[4] = array2[0];
			long sum = 0;
			for (int i = 0; i < result.length; i++) {
				sum += result[i];
			}
			System.out.println("Ausgabe: " + sum);
			finish = true;
			return;
		}
		for (int i = 0; i < array2.length; i++) {
			result[counter + 1] = array2[i];
			narrowDown(array2, counter + 1, result);
		}
	}
	
	public static void main(String[] args) {
		long[] primes = new long[2000];
		int index = 0;
		int checked = 2;
		while (primes[primes.length - 1] == 0) {
			checked++;
			if (checked % 5 == 0) {
				continue;
			}
			if (isPrime(checked)) {
				primes[index] = checked;
				index++;
			}
		}
		for (int i = 0; i < primes.length; i++) {
			long[] result = {primes[i], 0, 0, 0, 0};
			narrowDown(primes, 0, result);
			if (finish) {
				break;
			}
		}
	}
	
	/*
	 * Problem solved
	 * 30083rd person to have solved this problem
	 * Difficulty rating: 20%
	 * */
}
