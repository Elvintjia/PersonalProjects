package eulerProject31To60;

import java.math.BigInteger;

public class Problem55 {
	public static boolean isPalindrome(String input) {
		while (input.length() > 1) {
			if (input.charAt(0) != input.charAt(input.length() - 1)) {
				return false;
			}
			input = input.substring(1, input.length() - 1);
		}
		return true;
	}
	
	public static String reverseString(String input) {
		if (input.length() == 1) {
			return input;
		} else {
			return reverseString(input.substring(1)) + input.charAt(0);
		}
	}
	
	public static boolean isLychrel(BigInteger num, int iteration) {
		BigInteger add = num.add(new BigInteger(reverseString(num + "")));
		if (isPalindrome("" + add)) {
			System.out.println(num);
			return false;
		} else if (iteration < 50) {
			return isLychrel(add, iteration + 1);
		}
		return true;
	}
	
	public static void main(String[] args) {
		long count = 0;
		for (BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.valueOf(10000)) < 0; i = i.add(BigInteger.ONE)) {
			if (isLychrel(i, 0)) {
				count++;
			}
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/*
	 * Problem solved
	 * 58588th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
