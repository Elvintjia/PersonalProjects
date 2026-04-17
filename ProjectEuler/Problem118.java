package eulerProject91to120;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem118 {
	public static boolean uniqueNumbers(BigInteger num) {
		String numString = num.toString();
		boolean[] array = new boolean[10];
		for (int i = 0; i < numString.length(); i++) {
			int index = Integer.valueOf("" + numString.charAt(i));
			if (!array[index]) {
				array[index] = true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(BigInteger input) {
		if (input.compareTo(BigInteger.TWO) < 0) {
			return false;
		}
		for (BigInteger i = BigInteger.TWO; i.multiply(i).compareTo(input) <= 0; i = i.add(BigInteger.ONE)) {
			if (input.mod(i).compareTo(BigInteger.ZERO) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(int input) {
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static long pandigitalPrimeSets() {
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			array.add(i);
		}
		return iter(array, "", new ArrayList<>());
	}
	
	@SuppressWarnings("unchecked")
	public static long iter(ArrayList<Integer> array, String toProcess, ArrayList<String> taken) {
		if (array.isEmpty()) {
			return iterTwo(toProcess, -1, taken, new ArrayList<>());
		} else {
			long sum = 0;
			for (int i = 0; i < array.size(); i++) {
				ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
				String temp = toProcess + arrayCopy.remove(i);
				sum += iter(arrayCopy, temp, taken);
			}
			return sum;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static long iterTwo(String toCheck, int index, ArrayList<String> taken, ArrayList<Integer> current) {
		if (toCheck.length() == index + 1) {
			if (isPrime(Integer.valueOf(toCheck))) {
				if (current.size() == 1) {
					return 0;
				}
				current.sort(null);
				if (!taken.contains(current.toString())) {
					// System.out.println(current);
					if (current.toString().equals("[2, 5, 47, 89, 631]")) {
						System.out.println("Test");
					}
					taken.add(current.toString());
					return 1;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} else if (index == -1) {
			long sum = 0;
			for (int i = 0; i < toCheck.length(); i++) {
				sum += iterTwo(toCheck, i, taken, current);
			}
			return sum;
		} else {
			int subInt = Integer.valueOf(toCheck.substring(0, index + 1));
			if (isPrime(subInt)) {
				String newString = toCheck.substring(index + 1);
				current.add(subInt);
				long sum = 0;
				for (int i = 0; i < newString.length(); i++) {
					ArrayList<Integer> currentCopy = (ArrayList<Integer>) current.clone();
					sum += iterTwo(newString, i, taken, currentCopy);
				}
				return sum;
			} else {
				return 0;
			}
		}
	}
	
	public static void erasthothenesSieve() {
		ArrayList<BigInteger> sieve = new ArrayList<>();
		for (BigInteger i = BigInteger.TWO; i.compareTo(new BigInteger("1000000000")) < 0; i = i.add(BigInteger.ONE)) {
			if (isPrime(i) && uniqueNumbers(i)) {
				sieve.add(i);
				System.out.println(i);
			}
		}
		System.out.println(sieve);
	}
	
	public static ArrayList<BigInteger> erasthothenesSieveTwo() {
		ArrayList<BigInteger> toReturn = new ArrayList<>();
		ArrayList<Integer> toTake = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			toTake.add(i);
		}
		iter(toReturn, toTake, "");
		toReturn.sort(null);
		// System.out.println(toReturn.size());
		return toReturn;
	}
	
	public static void iter(ArrayList<BigInteger> toReturn, ArrayList<Integer> toTake, String current) {
		if (!current.isEmpty()) {
			BigInteger toCheck = new BigInteger(current);
			if (isPrime(toCheck)) {
				toReturn.add(toCheck);
			}
		}
		if (toTake.size() > 1) {
			for (int i = 0; i < toTake.size(); i++) {
				@SuppressWarnings("unchecked")
				ArrayList<Integer> toTakeClone = (ArrayList<Integer>) toTake.clone();
				String next = current + toTakeClone.remove(i);
				iter(toReturn, toTakeClone, next);
			}
		}
	}
	
	public static BigInteger pandigitalPrimeSetsTwo() {
		return iterTwo(erasthothenesSieveTwo(), new ArrayList<String>(), 0, 0, new boolean[9]);
	}
	
	@SuppressWarnings("unchecked")
	public static BigInteger iterTwo(ArrayList<BigInteger> array, ArrayList<String> current, int index,
			int totalLength, boolean[] taken) {
		if (totalLength == 9) {
			for (int i = 0; i < taken.length; i++) {
				if (!taken[i]) {
					return BigInteger.ZERO;
				}
			}
			// System.out.println(current);
			return BigInteger.ONE;
		} else if (index == array.size()) {
			return BigInteger.ZERO;
		} else if (totalLength < 9) {
			BigInteger sum = BigInteger.ZERO;
			for (int i = index; i < array.size(); i++) {
				String temp = array.get(i).toString();
				if (totalLength + temp.length() > 9) {
					return sum;
				}
				boolean[] takenClone = taken.clone();
				boolean notApplicable = false;
				for (int j = 0; j < temp.length(); j++) {
					int temp2 = Integer.valueOf(temp.charAt(j) + "");
					if (takenClone[temp2 - 1]) {
						notApplicable = true;
						break;
					} else {
						takenClone[temp2 - 1] = true;
					}
				}
				if (!notApplicable) {
					ArrayList<String> currentClone = (ArrayList<String>) current.clone();
					currentClone.add(temp);
					sum = sum.add(iterTwo(array, currentClone, i + 1, totalLength + temp.length(), takenClone));
				}
			}
			return sum;
		}
		return BigInteger.ZERO;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + pandigitalPrimeSetsTwo());
	}
	
	/*
	 * Problem solved
	 * 8092nd person to have solved this problem
	 * Difficulty rating: 45%
	 * Runtime: 9 seconds
	 * */
}
