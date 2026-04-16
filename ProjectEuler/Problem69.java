package eulerProject61to90;

public class Problem69 {
	public static boolean isPrime(long input) {
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static long totientFunction(long input) {
		long count = 0;
		String taken = " ";
		for (int i = 2; i < input; i++) {
			if (input % i == 0 && isPrime(i)) {
				taken += i + " ";
				count++;
				for (int j = i; j < input; j += i) {
					if (!taken.contains(" " + j + " ")) {
						taken += j + " ";
						count++;
					}
				}
			}
		}
		return input - count - 1;
	}
	
	public static long primeFactors(long input) {
		long count = 0;
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 2 && isPrime(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static long totientFunctionTwo(long input) {
		long count = 0;
		for (int i = 2; i * 2 <= input; i++) {
			if (input % i == 0 && isPrime(i)) {
				count++;
			}
		}
		long[] array = new long[(int) count];
		count = 2;
		for (int i = 0; i < array.length; i++) {
			while (!(isPrime(count) && input % count == 0)) {
				count++;
			}
			array[i] = count;
			count++;
		}
		/*
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		*/
		long sum = 0;
		for (int i = 1; i <= array.length; i++) {
			count = iterative(input, array, i, 1);
			// System.out.println(count);
			if (i % 2 == 1) {
				sum += count;
			} else {
				sum -= count;
			}
		}
		return input - sum - 1;
	}
	
	public static long iterative(long input, long[] array, long count, long y) {
		if (array.length < count) {
			return 0;
		} else if (array.length == count) {
			for (int i = 0; i < array.length; i++) {
				y *= array[i];
			}
			return (input - 1) / y;
		} else if (count == 1) {
			long sum = 0;
			for (int i = 0; i < array.length; i++) {
				sum += ((input - 1) / (y * array[i]));
			}
			return sum;
		} else {
			long sum = 0;
			for (int i = 0; i < array.length; i++) {
				sum += iterative(input, shortenArray(array, i), count - 1, y * array[i]);
			}
			return sum;
		}
	}
	
	public static long[] shortenArray(long[] array, long index) {
		long[] toReturn = new long[array.length - (int) index - 1];
		for (int i = 0; i < array.length; i++) {
			if (i > index) {
				toReturn[i - (int) index - 1] = array[i]; 
			}
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		long biggest = 0;
		double value = 0;
		for (int i = 2; i <= 1000000; i++) {
			System.out.println(i);
			double temp = (double) i / totientFunctionTwo(i);
			if (temp > value) {
				value = temp;
				biggest = i;
			}
		}
		System.out.println("Ausgabe: " + biggest);
	}
	
	/* Remark: Actually took more than an hour to compile, but fuck it.
	 * Problem solved
	 * 38599th person to have solved this problem
	 * Difficulty rating: 10%
	 * */
}
