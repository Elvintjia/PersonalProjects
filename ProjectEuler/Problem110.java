package eulerProject91to120;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem110 {
	public static boolean isPrime(BigInteger input) {
		for (BigInteger i = BigInteger.TWO; i.multiply(i).compareTo(input) <= 0; i = i.add(BigInteger.ONE)) {
			if (input.mod(i).equals(BigInteger.ZERO)) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<BigInteger> factors(BigInteger input) {
		ArrayList<BigInteger> toReturn = new ArrayList<>();
		for (BigInteger i = BigInteger.TWO; input.compareTo(BigInteger.ONE) > 0; i = i.add(BigInteger.ONE)) {
			// System.out.println(i);
			if (!isPrime(i)) {
				continue;
			} else if (input.mod(i).equals(BigInteger.ZERO)) {
				toReturn.add(i);
				input = input.divide(i);
				i = i.subtract(BigInteger.ONE);
			}
		}
 		return toReturn;
	}
	
	public static int diophantineReciprocals(BigInteger input) {
		if (isPrime(input)) {
			return 2;
		}
		ArrayList<BigInteger> factorsResult = factors(input.multiply(input));
		// System.out.println(factorsResult);
		ArrayList<BigInteger> toReturn = new ArrayList<>();
		for (int i = 1; i <= factorsResult.size(); i++) {
			iter(toReturn, factorsResult, 0, i, BigInteger.ONE, input);
		}
		System.out.println(toReturn);
		return toReturn.size() + 1;
	}
	
	public static void iter(ArrayList<BigInteger> result, ArrayList<BigInteger> factorResult, int index, int leftToTake,
			BigInteger current, BigInteger limit) {
		// System.out.println("check");
		if (leftToTake == 0) {
			// System.out.println("Check 2 " + current);
			if (current.compareTo(limit) <= 0 && (!result.contains(current))) {
				// System.out.println("Check 3 " + current);
				result.add(current);
			}
		} else if (index + leftToTake == factorResult.size()) {
			for (; index < factorResult.size(); index++) {
				current = current.multiply(factorResult.get(index));
			}
			if (current.compareTo(limit) <= 0 && (!result.contains(current))) {
				// System.out.println("Check 3 " + current);
				result.add(current);
			}
		} else if (index + leftToTake < factorResult.size()) {
			for (int i = index; i < factorResult.size(); i++) {
				iter(result, factorResult, i + 1, leftToTake - 1, current.multiply(factorResult.get(i)), limit);
			}
		}
	}
	
	public static int diophantineReciprocalsTwo(BigInteger input) {
		if (isPrime(input)) {
			return 2;
		}
		ArrayList<BigInteger> factoring = factors(input.multiply(input));
		int toReturn = 1;
		while (!factoring.isEmpty()) {
			BigInteger temp = factoring.getFirst();
			int count = 1;
			while (factoring.getFirst().compareTo(temp) == 0) {
				count++;
				factoring.removeFirst();
				if (factoring.isEmpty()) {
					break;
				}
			}
			toReturn *= count;
		}
		return (toReturn + 1) / 2;
	}
	
	public static int solution(int[] input) {
		int toReturn = 1;
		for (int i = 0; i < input.length; i++) {
			toReturn *= (input[i] + 1);
		}
		return toReturn;
	}
	
	public static BigInteger number(int[] input) {
		BigInteger[] array = {BigInteger.TWO, new BigInteger("3"), new BigInteger("5"), new BigInteger("7"),
				new BigInteger("11"), new BigInteger("13"), new BigInteger("17"), new BigInteger("19"),
				new BigInteger("23"), new BigInteger("29"), new BigInteger("31"), new BigInteger("37"),
				new BigInteger("41"), new BigInteger("43"), new BigInteger("47")};
		BigInteger toReturn = BigInteger.ONE;
		for (int i = 0; i < array.length; i++) {
			toReturn = toReturn.multiply(array[i].pow(input[i]));
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		BigInteger smallest = new BigInteger("614889782588491410");
		int smallestSolution = 7174454;
		/* Upper bound: 614889782588491410
		 * Upper bound solution: 7174454
		 * */
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j <= i; j++) {
				for (int k = 0; k <= j; k++) {
					for (int l = 0; l <= k; l++) {
						for (int m = 0; m <= l; m++) {
							for (int n = 0; n <= m; n++) {
								for (int o = 0; o <= n; o++) {
									for (int p = 0; p <= o; p++) {
										for (int q = 0; q <= p; q++) {
											for (int r = 0; r <= q; r++) {
												for (int s = 0; s <= r; s++) {
													for (int t = 0; t <= s; t++) {
														for (int u = 0; u <= t; u++) {
															for (int v = 0; v <= u; v++) {
																for (int w = 0; w <= v; w++) {
																	int[] temp = {i, j, k, l, m, n, o, p, q, r, s, t, u,
																			v, w};
																	BigInteger temp2 = number(temp);
																	int temp3 = diophantineReciprocalsTwo(temp2);
																	if (temp2.compareTo(smallest) < 0 &&
																			temp3 < smallestSolution && temp3 > 4000000) {
																		smallest = temp2;
																		smallestSolution = temp3;
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Ausgabe: " + smallest);
	}
	
	/* Remark: A very hard problem that took me forever to solve, plus quite a lot of research. To make it short, it was
	 * very painful.
	 * Problem solved
	 * 9298th person to have solved this problem
	 * Difficulty rating: 40%
	 * Runtime: 2 minutes, 33 seconds
	 * */
}
