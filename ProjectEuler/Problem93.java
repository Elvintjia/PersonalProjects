package eulerProject91to120;

import java.util.*;

public class Problem93 {
	public static int start(int[] numbers) {
		ArrayList<Double> numbering = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			numbering.add((double) numbers[i]);
		}
		ArrayList<Integer> results = new ArrayList<>();
		iterative(numbering, results);
		int toReturn = 1;
		while (results.contains(toReturn)) {
			toReturn++;
		}
		return toReturn - 1;
	}
	
	@SuppressWarnings("unchecked")
	public static void iterative(ArrayList<Double> numbers, ArrayList<Integer> results) {
		if (numbers.size() > 1) {
			for (int i = 0; i < numbers.size(); i++) {
				for (int j = i + 1; j < numbers.size(); j++) {
					ArrayList<Double> cloned = (ArrayList<Double>) numbers.clone();
					double second = cloned.remove(j);
					double first = cloned.remove(i);
					for (int k = 0; k < 6; k++) {
						ArrayList<Double> cloned2 = (ArrayList<Double>) cloned.clone();
						double temp = 0;
						if (k == 0) {
							temp = first + second;
						} else if (k == 1) {
							temp = first - second;
						} else if (k == 2) {
							temp = second - first;
						} else if (k == 3) {
							temp = first * second;
						} else if (k == 4) {
							temp = first / second;
						} else if (k == 5) {
							temp = second / first;
						}
						if (temp != 0) cloned2.add(temp); 
						iterative(cloned2, results);
					}
				}
			}
		} else if (numbers.size() == 1) {
			double temp = numbers.getFirst();
			if (temp > 0 && Math.floor(temp) == Math.ceil(temp)) {
				results.add((int) temp);
			}
		}
	}
	
	public static void main(String[] args) {
		int biggest = 0;
		String num = "";
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 1; k <= 9; k++) {
					for (int l = 1; l <= 9; l++) {
						int[] temp = {i, j, k, l};
						int temp2 = start(temp);
						if (temp2 > biggest) {
							biggest = temp2;
							num = "" + i + j + k + l;
						}
					}
				}
			}
		}
		System.out.println("Ausgabe: " + num);
	}
	
	/* Remark: Oh my goodness. I spent far more time than I have ever hoped for. I was stuck in this problem for weeks,
	 * trying to figure out how to do this problem. I tried some complicated solutions, but none worked well. When I
	 * decided to use double instead of fractions, I suddenly finished the problem pretty easily, with less complication
	 * than fractions. Fuck me.
	 * Problem solved
	 * 13514th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: 2 seconds
	 * */
}
