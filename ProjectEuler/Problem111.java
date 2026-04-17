package eulerProject91to120;

import java.util.ArrayList;
import java.math.BigInteger;

public class Problem111 {
	public static ArrayList<BigInteger> erasthothenesSieve(int n) {
		BigInteger limit = BigInteger.ONE;
		for (int i = 0; i < n; i++) {
			limit = limit.multiply(BigInteger.TEN);
		}
		// System.out.println(limit);
		ArrayList<BigInteger> toRemove = new ArrayList<>();
		for (BigInteger i = BigInteger.TWO; i.compareTo(limit) < 0; i = i.add(BigInteger.ONE)) {
			toRemove.add(i);
		}
		ArrayList<BigInteger> toReturn = new ArrayList<>();
		while (!toRemove.isEmpty()) {
			BigInteger change = toRemove.getFirst();
			toReturn.add(change);
			for (BigInteger i = change; i.compareTo(limit) < 0; i = i.add(change)) {
				toRemove.remove(i);
			}
		}
		// System.out.println(toReturn);
		limit = limit.divide(BigInteger.TEN);
		// System.out.println(limit);
		while (toReturn.getFirst().compareTo(limit) < 0) {
			toReturn.removeFirst();
		}
		// System.out.println(toReturn);
		return toReturn;
	}
	
	public static int maximum(int digit, int n) {
		boolean[] digits = new boolean[n];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j < i) {
					digits[j] = true;
				} else {
					digits[j] = false;
				}
			}
			boolean done = false;
			while (true) {
				String template = "";
				for (int j = 0; j < n; j++) {
					if (digits[j]) {
						template += "x";
					} else {
						template += digit;
					}
				}
				done = maximumIter(template);
				if (done) {
					break;
				} else if (finishedTwo(digits)) {
					break;
				}
				digits = next(digits);
			}
			if (done) {
				break;
			}
		}
		int toReturn = 0;
		for (int i = 0; i < digits.length; i++) {
			if (!digits[i]) {
				toReturn++;
			}
		}
		return toReturn;
	}
	
	public static boolean[] next(boolean[] toChange) {
		int index = toChange.length - 1;
		int carry = 0;
		while (toChange[index]) {
			carry++;
			toChange[index] = false;
			index--;
		}
		while (!toChange[index]) {
			index--;
		}
		toChange[index] = false;
		index++;
		toChange[index] = true;
		for (int i = 0; i < carry; i++) {
			toChange[index + 1 + i] = true;
		}
		return toChange;
	}
	
	public static boolean finished(boolean[] toCheck, int num) {
		for (int i = toCheck.length - 1; i > toCheck.length - num - 1; i--) {
			if (!toCheck[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean finishedTwo(boolean[] toCheck) {
		int index = toCheck.length - 1;
		while (toCheck[index]) {
			index--;
		}
		index--;
		for (; index >= 0; index--) {
			if (toCheck[index]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean maximumIter(String input) {
		if (input.contains("x")) {
			boolean toReturn = false;
			for (int i = 0; i <= 9; i++) {
				String temp = replacement(i, input);
				toReturn = maximumIter(temp);
				if (toReturn) {
					return true;
				}
			}
		} else {
			if (isValid(input) && isPrime(input)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPrime(String input) {
		BigInteger checked = new BigInteger(input);
		for (BigInteger i = BigInteger.TWO; i.multiply(i).compareTo(checked) <= 0; i = i.add(BigInteger.ONE)) {
			if (checked.mod(i).compareTo(BigInteger.ZERO) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static String replacement(int i, String input) {
		int index = input.indexOf("x");
		if (index == 0) {
			return (i + input.substring(1));
		} else if (index == input.length() - 1) {
			return (input.substring(0, input.length() - 1) + i);
		} else {
			return (input.substring(0, index) + i + input.substring(index + 1));
		}
	}
	
	public static boolean isValid(String input) {
		return input.charAt(0) != '0';
	}
	
	public static BigInteger total(int digit, int n, int m) {
		boolean[] digits = new boolean[n];
		for (int i = 0; i < m; i++) {
			digits[i] = true;
		}
		BigInteger toReturn = BigInteger.ZERO;
		while (true) {
			String template = "";
			for (int i = 0; i < n; i++) {
				if (digits[i]) {
					template += digit;
				} else {
					template += "x";
				}
			}
			toReturn = toReturn.add(totalIter(template));
			if (finishedTwo(digits)) {
				break;
			}
			digits = next(digits);
		}
		return toReturn;
	}
	
	public static BigInteger totalIter(String template) {
		if (template.contains("x")) {
			BigInteger sum = BigInteger.ZERO;
			for (int i = 0; i <= 9; i++) {
				String temp = replacement(i, template);
				sum = sum.add(totalIter(temp));
			}
			return sum;
		} else if (isValid(template) && isPrime(template)) {
			return new BigInteger(template);
		}
		return BigInteger.ZERO;
	}
	
	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i <= 9; i++) {
			// System.out.println(i);
			int temp = maximum(i, 10);
			sum = sum.add(total(i, 10, temp));
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/*
	 * Problem solved
	 * 8371st person to have solved this problem
	 * Difficulty rating: 45%
	 * Runtime: 1 second
	 * */
}
