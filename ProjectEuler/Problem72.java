package eulerProject61to90;

import java.math.BigInteger;

public class Problem72 {
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
		for (int i = 2; i * 2 <= input; i++) {
			if (input % i == 0 && isPrime(i)) {
				array[(int) count] = i;
				count++;
			}
		}
		// System.out.println(array[0]);
		long sum = 0;
		for (int i = 0; i < array.length; i++) {
			long temp = totientIterative(input, array, (i + 1), 1);
			if ((i + 1) % 2 == 0) {
				temp *= -1;
			}
			sum += temp;
		}
		return input - 1 - sum;
	}
	
	public static long totientIterative(long input, long[] array, long count, long y) {
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
				sum += (input - 1) / (array[i] * y);
			}
			return sum;
		} else {
			long sum = 0;
			for (int i = 0; i < array.length; i++) {
				sum += totientIterative(input, shortenArray(array, i), count - 1, y * array[i]);
			}
			return sum;
		}
	}
	
	public static long[] shortenArray(long[] array, int index) {
		long[] toReturn = new long[array.length - 1 - index];
		for (int i = 0; i < array.length; i++) {
			if (i > index) {
				toReturn[i - index - 1] = array[i];
			}
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 2; i <= 1000000; i++) {
			// System.out.println(i);
			sum = sum.add(new BigInteger("" + totientFunction(i)));
		}
		/*
		long[] array = {1, 2, 3, 4, 5};
		array = shortenArray(array, 0);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		*/
		System.out.println("Ausgabe: " + sum);
	}
	
	/* Remark: Took about 20 minutes to compile, but I don't feel like finding a more efficient way, so this is what I will
	 * leave it at.
	 * Problem solved
	 * 24944th person to have solved this problem
	 * Difficulty rating: 20%
	 * */
}
