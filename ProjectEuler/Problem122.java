package eulerProject121to150;

import java.util.ArrayList;

public class Problem122 {
	ArrayList<Integer> array = new ArrayList<>();
	int exponentiation = 0;
	
	public Problem122() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static long efficientExponentiation(int n) {
		ArrayList<ArrayList<Integer>> saved = new ArrayList<>();
		int[] minimumExponentiation = new int[n];
		minimumExponentiation[1] = 1;
		saved.add(new ArrayList<Integer>());
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(1);
		temp.add(2);
		saved.add(temp);
		for (int i = 3; i <= n; i++) {
			int smallest = -1;
			int index = 0;
			for (int j = 1; j < i - 1; j++) {
				for (int k = 0; k < saved.get(j).size(); k++) {
					if (j + 1 + saved.get(j).get(k) == i) {
						if (smallest == -1 || smallest > minimumExponentiation[j] + 1) {
							smallest = minimumExponentiation[j] + 1;
							index = j;
						}
						break;
					}
				}
			}
			temp = (ArrayList<Integer>) saved.get(index).clone();
			temp.add(i);
			saved.add(temp);
			minimumExponentiation[i - 1] = smallest;
		}
		int sum = 0;
		for (int i = 0; i < minimumExponentiation.length; i++) {
			sum += minimumExponentiation[i];
			// System.out.println(i + " " + minimumExponentiation[i]);
		}
		// System.out.println(saved);
		return sum;
	}
	
	public static long efficientExponentiationTwo(int n) {
		long toReturn = 0;
		ArrayList<Integer> starter = new ArrayList<>();
		starter.add(1);
		for (int i = 2; i <= n; i++) {
			System.out.println(i);
			toReturn += iter(i, starter, 1, 0);
		}
		return toReturn;
	}
	
	@SuppressWarnings("unchecked")
	public static long iter(int n, ArrayList<Integer> array, int current, int exponentiation) {
		// System.out.println(n + " " + array + " " + current + " " + exponentiation);
		if (current > n) {
			return 9999;
		} else if (n == current) {
			return exponentiation;
		} else {
			long smallest = 9999;
			for (int i = 0; i < array.size(); i++) {
				ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
				int temp2 = array.get(i) + current;
				arrayCopy.add(temp2);
				long temp = iter(n, arrayCopy, temp2, exponentiation + 1);
				if (temp < smallest) {
					smallest = temp;
				}
			}
			return smallest;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static long efficientExponentiationThree(int n) {
		Problem122[] array = new Problem122[n];
		Problem122 starter = new Problem122();
		starter.array.add(1);
		array[0] = starter;
		// int counter = 3;
		int count = 0;
		while (true) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					continue;
				}
				if (array[i].exponentiation == count) {
					for (int j = 0; j < array[i].array.size(); j++) {
						int result = i + array[i].array.get(j);
						if (result + 1 > array.length) {
							break;
						}
						if (array[result] == null) {
							Problem122 temp = new Problem122();
							temp.array = (ArrayList<Integer>) array[i].array.clone();
							temp.array.add(result + 1);
							temp.exponentiation = array[i].exponentiation + 1;
							array[result] = temp;
						}
					}
				}
			}
			boolean breakLoop = true;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					breakLoop = false;
					break;
				}
			}
			// System.out.println();
			if (breakLoop) {
				break;
			}
			count++;
		}
		long sum = 0;
		/*
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].array + " " + array[i].exponentiation);
		}
		*/
		for (int i = 0; i < array.length; i++) {
			sum += array[i].exponentiation;
		}
		// System.out.println(array[14].exponentiation);
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + efficientExponentiationThree(200));
	}
	
	/* Remark: The answer isn't actually 1584. It's 1582, and I have no clue why. I developed 2 different methods to
	 * solve this problem, and both methods yielded the same result. It's unclear to me why the two methods I developed
	 * both had 2 more than the actual answer. I need to do online research. It's a first that I have to do online
	 * research after I solved the problem, as opposed to before I solved the problem.
	 * Problem solved
	 * 8955th person to have solved this problem
	 * Difficulty rating: 40%
	 * Runtime: Less than 1 second
	 * */
}
