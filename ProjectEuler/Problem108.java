package eulerProject91to120;

import java.util.ArrayList;

public class Problem108 {
	public static boolean isPrime(long n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean commonDenominatorBiggerThanOne(int a, int b) {
		for (int i = 2; i <= a && i <= b; i++) {
			if (a % i == 0 && b % i == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static int diophantineReciprocals(int n) {
		if (isPrime(n)) {
			return 0;
		}
		ArrayList<Integer> checked = new ArrayList<>();
		int limit = n * n;
		int toReturn = 1;
		for (int i = 3; limit == 0 || i < limit; i++) {
			for (int j = 1; j < i / 2 + (i % 2); j++) {
				if (i * n % j == 0 && i * n % (i - j) == 0) {
					// System.out.println(i + " " + j);
					int temp = i * n / j;
					if (!checked.contains(temp)) {
						checked.add(temp);
						toReturn++;
					}
					/*
					if (limit == 0) {
						limit = i * 2;
					}
					*/
				}
			}
		}
		return toReturn;
	}
	
	public static int diophantineReciprocalsTwo(long n) {
		if (isPrime(n)) {
			return 2;
		}
		int toReturn = 0;
		for (long i = 1; i * 2 < n * n; i++) {
			if (n % i == 0) {
				toReturn++;
				// System.out.println(i);
			}
		}
		return toReturn;
	}
	
	public static ArrayList<Integer> factors(long n) {
		ArrayList<Integer> toReturn = new ArrayList<>();
		int i = 2;
		while (n > 1) {
			if (n % i == 0) {
				toReturn.add(i);
				n = n / i;
			} else {
				i++;
			}
		}
		return toReturn;
	}
	
	public static int diophantineReciprocalsThree(long n) {
		if (isPrime(n)) {
			return 2;
		}
		ArrayList<Integer> saved = new ArrayList<>();
		ArrayList<Integer> factors = factors(n);
		int j = factors.size();
		for (int i = 0; i < j; i++) {
			factors.add(factors.get(i));
		}
		// System.out.println(factors);
		for (int i = 1; i <= factors.size(); i++) {
			iter(factors, saved, i, 1, 0, n);
		}
		System.out.println(saved);
		return saved.size() + 1;
	}
	
	public static void iter(ArrayList<Integer> factors, ArrayList<Integer> saved, int leftToTake, int current, int index,
			long limit) {
		if (leftToTake == 0) {
			if (!saved.contains(current) && current <= limit) {
				saved.add(current);
			}
		} else if (leftToTake + index == factors.size()) {
			for (; index < factors.size(); index++) {
				current *= factors.get(index);
			}
			if (!saved.contains(current) && current <= limit) {
				saved.add(current);
			}
		} else if (leftToTake + index < factors.size()) {
			for (int i = index; i < factors.size(); i++) {
				iter(factors, saved, leftToTake - 1, current * factors.get(i), i + 1, limit);
			}
		}
	}
	
	public static void main(String[] args) {
		int i = 3;
		while (diophantineReciprocalsThree(i) <= 1000) {
			i++;
			System.out.println(i);
		}
		// Checkpoint: 23339
		// Checkpoint 2 (Primeless): 3136187
		// Checkpoint 3 (Primeless): 30522139
		// Checkpoint 4 (Revised): 3887
		// Checkpoint 5 (Revised): 9053
		// Checkpoint 6 (Revised): 36950
		System.out.println("Ausgabe: " + i);
	}
	
	/* Remark: This was much harder than the problem with 50% difficulty rating. It took me research and time to figure it
	 * out and the runtime is also horrible.
	 * Problem solved
	 * 14285th person to have solved this problem
	 * Difficulty rating: 30%
	 * Runtime: 55 minutes 55 seconds
	 * */
}
