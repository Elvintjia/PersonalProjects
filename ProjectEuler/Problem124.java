package eulerProject121to150;

import java.util.ArrayList;

public class Problem124 implements Comparable<Problem124> {
	int rad;
	int n;
	
	public Problem124(int n) {
		this.n = n;
		rad = radicals(primeFactors(n));
	}
	
	public String toString() {
		return (n + " " + rad);
	}
	
	public static ArrayList<Integer> primeFactors(int n) {
		ArrayList<Integer> toReturn = new ArrayList<>();
		int modulo = 2;
		while (n > 1) {
			if (n % modulo == 0) {
				toReturn.add(modulo);
				while (n % modulo == 0) {
					n /= modulo;
				}
			}
			modulo++;
		}
		return toReturn;
	}
	
	public static int radicals(ArrayList<Integer> primeFactorList) {
		int toReturn = 1;
		for (int i = 0; i < primeFactorList.size(); i++) {
			toReturn *= primeFactorList.get(i);
		}
		return toReturn;
	}
	
	@Override
	public int compareTo(Problem124 o) {
		if (this.rad < o.rad) {
			return -1;
		} else if (this.rad > o.rad) {
			return 1;
		} else if (this.n < o.n) {
			return -1;
		} else if (this.n > o.n) {
			return 1;
		} else
		return 0;
	}
	
	public static int orderedRadicals(int index, int limit) {
		ArrayList<Problem124> array = new ArrayList<>();
		for (int i = 1; i <= limit; i++) {
			array.add(new Problem124(i));
		}
		array.sort(null);
		return array.get(index - 1).n;
	}
	
	public static void main(String[] args) {
		/*
		ArrayList<Problem124> array = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			array.add(new Problem124(i));
		}
		array.sort(null);
		*/
		System.out.println("Ausgabe: " + orderedRadicals(10000, 100000));
	}
	
	/*
	 * Problem solved
	 * 15235th person to have solved this problem
	 * Difficulty rating: 25%
	 * Runtime: 2 seconds
	 * */
}
