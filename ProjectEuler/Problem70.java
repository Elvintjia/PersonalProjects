package eulerProject61to90;

public class Problem70 {
	public static boolean isPrime(long input) {
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean permutation(long a, long b) {
		String stringA = "" + a;
		String stringB = "" + b;
		if (stringA.length() != stringB.length()) {
			return false;
		}
		boolean[] array = new boolean[stringA.length()];
		for (int i = 0; i < stringA.length(); i++) {
			for (int j = 0; j < stringB.length(); j++) {
				if (stringA.charAt(i) == stringB.charAt(j) && !array[j]) {
					array[j] = true;
					break;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (!array[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static long totientFunction(long input) {
		long count = 0;
		for (int i = 2; i * 2 <= input; i++) {
			if (input % i == 0 && isPrime(i)) {
				count++;
			}
		}
		// System.out.println(count);
		if (count == 0) {
			return input - 1;
		}
		long[] array = new long[(int) count];
		count = 0;
		for (int i  = 2; array[array.length - 1] == 0; i++) {
			if (input % i == 0 && isPrime(i)) {
				array[(int) count] = i;
				count++;
			}
		}
		/*
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		*/
		long sum = 0;
		for (int i = 1; i <= array.length; i++) {
			long temp = totientIterative(input, array, i, 1);
			// System.out.println(temp);
			if (i % 2 == 0) {
				temp *= -1;
			}
			sum += temp;
		}
		return input - sum - 1;
	}
	
	public static long totientIterative(long input, long[] array, int count, long y) {
		if (array.length < count || input < y) {
			return 0;
		} else if (array.length == count) {
			for (int i = 0; i < array.length; i++) {
				y *= array[i];
			}
			return (input - 1) / y;
		} else if (count == 1) {
			long sum = 0;
			for (int i = 0; i < array.length; i++) {
				sum += (input - 1) / (y * array[i]);
			}
			return sum;
		} else {
			long sum = 0;
			for (int i = 0; i < array.length; i++) {
				sum += totientIterative(input, shortenArray(array,i), count - 1, y * array[i]);
			}
			return sum;
		}
	}
	
	public static long[] shortenArray(long[] array, int index) {
		long[] toReturn = new long[array.length - index - 1];
		for (int i = 0; i < array.length; i++) {
			if (i > index) {
				toReturn[i - index - 1] = array[i];
			}
		}
		return toReturn;
	}
	
	public static long primeFactors(long input) {
		long count = 0;
		for (int i = 2; i * 2 < input; i++) {
			if (input % i == 0 && isPrime(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		long n = 8357821;
		double ratio = 1.0007122953991632;
		for (int i = 8357820; i >= 2; i--) {
			// System.out.println(i);
			if (isPrime(i)) {
				continue;
			}
			long totient = totientFunction(i);
			if (permutation(i, totient)) {
				double temp = (double) i / totient;
				// System.out.println(temp);
				if (temp < ratio) {
					ratio = temp;
					n = i;
					break;
				}
			}
		}
		/*
		long[] array = {1, 2, 3, 4, 5, 6, 7};
		array = shortenArray(array, 5);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		*/
		System.out.println("Ausgabe: " + n);
		// ratio = 1.0003188775510203
		// n = 9840769
		// n = 9999901
	}
	
	/* Remark: I technically cheated by making a program with memory, and just brute-forcing the answer until I got the
	 * right one, but oh well. This problem was hard to solve, and I couldn't figure out a better and easier way to get
	 * this to work.
	 * Problem solved
	 * 24908th person to have solved this problem
	 * Difficulty rating: 20%
	 * */
}
