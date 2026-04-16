package eulerProject61to90;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem88 {
	static boolean[] array = new boolean[12000];
	static ArrayList<Integer> taken = new ArrayList<Integer>();
	static int count = 1;
	
	public static boolean isPrime(long input) {
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<Integer> factorFinder(int input) {
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		int divider = 2;
		while (divider <= input) {
			if (input % divider == 0) {
				toReturn.add(divider);
				input /= divider;
			} else {
				divider++;
			}
		}
		return toReturn;
	}
	
	@SuppressWarnings("unchecked")
	public static void start(int input) {
		ArrayList<Integer> factors = factorFinder(input);
		for (int i = factors.size() - 1; i > 0; i--) {
			iterator((ArrayList<Integer>) factors.clone(), i, new ArrayList<Integer>(), input, 0, 1);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void iterator(ArrayList<Integer> factors, int numbersToTakeOut, ArrayList<Integer> indexes, int input,
			int sum, int numOfFactors) {
		if (numbersToTakeOut == 0) {
			iteratorTwo(factors, indexes, input, sum, numOfFactors);
			return;
		}
		if (indexes.size() == 0) {
			for (int i = 0; i < factors.size(); i++) {
				ArrayList<Integer> temp = (ArrayList<Integer>) indexes.clone();
				temp.add(i);
				iterator((ArrayList<Integer>) factors.clone(), numbersToTakeOut - 1, (ArrayList<Integer>) temp.clone(),
						input, sum, numOfFactors);
			}
		} else {
			int temp = factors.size() - indexes.getLast() - 1;
			if (temp < numbersToTakeOut) {
				return;
			} else if (temp == numbersToTakeOut) {
				for (int i = indexes.getLast() + 1; i < factors.size(); i++) {
					indexes.add(i);
				}
				iteratorTwo((ArrayList<Integer>) factors.clone(), (ArrayList<Integer>) indexes.clone(), input, sum,
						numOfFactors);
			} else {
				for (int i = indexes.getLast() + 1; i < factors.size(); i++) {
					ArrayList<Integer> temp2 = (ArrayList<Integer>) indexes.clone();
					temp2.add(i);
					iterator((ArrayList<Integer>) factors.clone(), numbersToTakeOut - 1,
							(ArrayList<Integer>) temp2.clone(), input, sum, numOfFactors);
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void iteratorTwo(ArrayList<Integer> factors, ArrayList<Integer> indexes, int input, int sum,
			int numOfFactors) {
		// System.out.println(factors + "\n" + indexes);
		int product = 1;
		for (int i = indexes.size() - 1; i >= 0; i--) {
			int index = indexes.get(i);
			// System.out.println(index);
			product *= factors.remove(index);
		}
		// System.out.println(product);
		sum += product;
		/*
		if (sum == 5) {
			System.out.println("Product: " + product);
		}
		*/
		// System.out.println(sum + "\n");
		if (factors.isEmpty()) {
			// System.out.println(sum + "\n" + numOfFactors + "\n");
			numOfFactors += (input - sum - 1);
			if (numOfFactors < 12000) {
				if (!array[numOfFactors]) {
					array[numOfFactors] = true;
					taken.add(input);
					count++;
				}
			}
		} else {
			for (int i = indexes.size(); i > 0; i--) {
				iterator((ArrayList<Integer>) factors.clone(), i, new ArrayList<Integer>(), input, sum, numOfFactors + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		for (int i = 4; count < 12000; i++) {
			if (!isPrime(i)) {
				// System.out.println(i);
				start(i);
			}
		}
		// start(12);
		// System.out.println(count);
		taken = new ArrayList<Integer>(new HashSet<Integer>(taken));
		// System.out.println(taken);
		for (int i = 0; i < array.length; i++) {
			if (array[i]) {
				System.out.println(i);
			}
		}
		long sum = 0;
		for (int i = 0; i < taken.size(); i++) {
			sum += taken.get(i);
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/* Remark: I spent so much time configuring this damn program, but it turned out to be slow. I purposefully avoided
	 * a more brute-force method to avoid long runtimes, but in the end, it still took a long time.
	 * Problem solved
	 * 11617th person to have solved this problem
	 * Difficulty rating: 40%
	 * Runtime: 1 hour, 39 minutes, 57 seconds
	 * */
}
