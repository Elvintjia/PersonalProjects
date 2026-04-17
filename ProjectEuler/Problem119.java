package eulerProject91to120;

import java.util.ArrayList;
import java.math.BigInteger;

public class Problem119 {
	BigInteger num;
	int exponent;
	
	public Problem119(BigInteger num, int exponent) {
		this.num = num;
		this.exponent = exponent;
	}
	
	public int compareTo(Problem119 toCompare) {
		return num.compareTo(toCompare.num);
	}
	
	public void multiply() {
		num = num.multiply(new BigInteger(exponent + ""));
	}
	
	public static boolean isPrime(int input) {
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger digitPowerSum(int term) {
		ArrayList<BigInteger> found = new ArrayList<>();
		ArrayList<Integer> exponents = new ArrayList<>();
		exponents.add(4);
		exponents.add(3);
		while (found.size() < term) {
			// System.out.println(exponents);
			int index = 0;
			BigInteger smallest = BigInteger.TWO.pow(exponents.get(index));
			for (int i = 0; i < exponents.size(); i++) {
				BigInteger temp = new BigInteger("" + i);
				temp = temp.add(BigInteger.TWO);
				temp = temp.pow(exponents.get(i));
				if (temp.compareTo(smallest) < 0) {
					index = i;
					smallest = temp;
				}
			}
			BigInteger next = new BigInteger("" + exponents.size());
			next = next.add(BigInteger.TWO);
			next = next.pow(2);
			if (next.compareTo(smallest) < 0) {
				if (processing(next, exponents.size())) {
					if (!found.contains(next)) {
						found.add(next);
					}
				}
				exponents.add(3);
			} else {
				if (processing(smallest, index + 2)) {
					if (!found.contains(smallest)) {
						found.add(smallest);
					}
				}
				int temp = exponents.remove(index) + 1;
				exponents.add(index, temp);
			}
		}
		// System.out.println(found);
		return found.get(term - 2);
	}
	
	public static boolean processing(BigInteger toProcess, int initialNum) {
		if (toProcess.compareTo(BigInteger.TEN) < 0) {
			return false;
		}
		String toProcessString = toProcess.toString();
		int sum = 0;
		for (int i = 0; i < toProcessString.length(); i++) {
			sum += Integer.valueOf(toProcessString.charAt(i) + "");
		}
		return (sum == initialNum);
	}
	
	public static boolean processing(Problem119 input) {
		String toProcessString = input.num.toString();
		int sum = 0;
		for (int i = 0; i < toProcessString.length(); i++) {
			sum += Integer.valueOf(toProcessString.charAt(i) + "");
		}
		return (sum == input.exponent);
	}
	
	public static BigInteger digitPowerSumTwo(int term) {
		ArrayList<BigInteger> found = new ArrayList<>();
		ArrayList<Problem119> queue = new ArrayList<>();
		queue.add(new Problem119(new BigInteger("16"), 2));
		queue.add(new Problem119(new BigInteger("27"), 3));
		Problem119 next = new Problem119(new BigInteger("16"), 4);
		while (found.size() < term) {
			Problem119 toReinsert = null;
			if (queue.getFirst().compareTo(next) < 0) {
				if (processing(queue.getFirst())) {
					found.add(queue.getFirst().num);
				}
				toReinsert = queue.removeFirst();
			} else {
				toReinsert = next;
				int temp = toReinsert.exponent + 1;
				next = new Problem119((new BigInteger("" + temp)).pow(2), temp);
				if (processing(toReinsert)) {
					found.add(toReinsert.num);
				}
			}
			toReinsert.multiply();
			boolean alreadyReinserted = false;
			for (int i = 0; i < queue.size(); i++) {
				if (toReinsert.compareTo(queue.get(i)) < 0) {
					queue.add(i, toReinsert);
					alreadyReinserted = true;
					break;
				}
			}
			if (!alreadyReinserted) {
				queue.add(toReinsert);
			}
			// System.out.println(found.size());
		}
		System.out.println(found);
		return found.getLast();
	}
	
	public static BigInteger digitPowerSumThree(int term) {
		BigInteger toCheck = BigInteger.TEN;
		while (term > 0) {
			BigInteger quersumme = BigInteger.ZERO;
			String toCheckString = toCheck.toString();
			for (int i = 0; i < toCheckString.length(); i++) {
				quersumme = quersumme.add(new BigInteger(toCheckString.charAt(i) + ""));
			}
			if (quersumme.compareTo(BigInteger.ONE) == 0) {
				toCheck = toCheck.add(BigInteger.ONE);
				continue;
			} else if (validityCheck(toCheck, quersumme)) {
				term--;
				System.out.println(term);
			}
			toCheck = toCheck.add(BigInteger.ONE);
		}
		return toCheck.subtract(BigInteger.ONE);
	}
	
	public static boolean validityCheck(BigInteger toCheck, BigInteger quersumme) {
		while (toCheck.mod(quersumme).equals(BigInteger.ZERO)) {
			toCheck = toCheck.divide(quersumme);
		}
		return toCheck.equals(BigInteger.ONE);
	}
	
	public static BigInteger digitPowerSumFour(int term) {
		ArrayList<BigInteger> found = new ArrayList<>();
		int[] exponents = new int[17];
		while (found.size() < term) {
			// System.out.println("check");
			for (int i = 0; i < exponents.length; i++) {
				// System.out.println("check2");
				BigInteger temp = new BigInteger((i + 2) + "");
				BigInteger temp2 = temp.pow(exponents[i]);
				// System.out.println(exponents.length);
				while (temp2.toString().length() < (exponents.length - 8) / 9 + 2) {
					// System.out.println("check3");
					if (processing(temp2, i + 2)) {
						found.add(temp2);
					}
					exponents[i]++;
					temp2 = temp.pow(exponents[i]);
				}
			}
			/*
			for (int i = 0; i < exponents.length; i++) {
				System.out.println(i + " " + exponents[i]);
			}
			*/
			int[] next = new int[exponents.length + 9];
			for (int i = 0; i < exponents.length; i++) {
				next[i] = exponents[i];
			}
			exponents = next;
			// break;
		}
		return found.get(term - 1);
	}
	
	public static boolean processingTwo(BigInteger toProcess, int initialSum) {
		if (toProcess.compareTo(BigInteger.TEN) < 0) {
			return false;
		}
		int sum = 0;
		String toProcessString = toProcess.toString();
		for (int i = 0; i < toProcessString.length(); i++) {
			sum += Integer.valueOf(toProcessString.charAt(i) + "");
		}
		return (sum == initialSum);
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + digitPowerSumFour(30));
	}
	/*
	 * Problem solved
	 * 13904th person to have solved this problem
	 * Difficulty rating: 30%
	 * Runtime: Less than 1 second
	 * */
}
