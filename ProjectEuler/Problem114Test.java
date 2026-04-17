package eulerProject91to120;

import java.math.BigInteger;

public class Problem114Test {
	public static BigInteger countingBlockCombinations(int length) {
		return fibonacci(length + 2).divide(BigInteger.TWO);
	}
	
	public static BigInteger fibonacci(int sequence) {
		int num = 2;
		BigInteger first = BigInteger.ONE;
		BigInteger second = BigInteger.ONE;
		while (num < sequence) {
			BigInteger third = first.add(second);
			first = second;
			second = third;
			num++;
		}
		return second;
	}
	
	public static long countingBlocksCombinationTwo(int minLength, int length) {
		long[] array = new long[length + 1];
		for (int i = 0; i <= minLength; i++) {
			array[i] = 1;
			if (i == minLength) {
				array[i]++;
			}
		}
		for (int i = minLength + 1; i <= length; i++) {
			int sum = 0;
			for (int j = minLength + 1; j <= i; j++) {
				sum += array[i - j];
			}
			sum += array[i - 1];
			sum++;
			array[i] = sum;
		}
		/*
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + " " + array[i]);
		}
		*/
		return array[length];
	}
	
	public static void main(String[] args) {
		System.out.println(countingBlocksCombinationTwo(10, 56));
	}
}
