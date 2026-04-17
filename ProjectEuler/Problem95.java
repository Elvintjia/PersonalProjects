package eulerProject91to120;

import java.util.ArrayList;
import java.util.Collections;

public class Problem95 {
	public static int sumOfProperDivisors(int x) {
		int sum = 1;
		int i = 2;
		for (; i * i <= x; i++) {
			if (x % i == 0) {
				sum += i;
			}
		}
		if (sum == 1) {
			return sum;
		}
		for (; i * 2 <= x; i++) {
			if (x % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static boolean[] markChecked(ArrayList<Integer> toMark, boolean[] alreadyChecked) {
		for (int i: toMark) {
			alreadyChecked[i] = true;
		}
		return alreadyChecked;
	}
	
	public static void main(String[] args) {
		boolean[] alreadyChecked = new boolean[1000001];
		ArrayList<Integer> longestList = new ArrayList<>();
		for (int i = 0; i < alreadyChecked.length; i++) {
			System.out.println(i);
			if (!alreadyChecked[i]) {
				int temp = sumOfProperDivisors(i);
				if (temp == 1) {
					alreadyChecked[i] = true;
				} else {
					ArrayList<Integer> currentList = new ArrayList<>();
					currentList.add(i);
					for (temp = sumOfProperDivisors(temp); ; temp = sumOfProperDivisors(temp)) {
						if (currentList.getFirst() == temp) {
							if (currentList.size() > longestList.size()) {
								longestList = currentList;
							}
							alreadyChecked = markChecked(currentList, alreadyChecked);
							break;
						} else if (temp > 1000000) {
							alreadyChecked = markChecked(currentList, alreadyChecked);
							break;
						} else if (alreadyChecked[temp]) {
							alreadyChecked = markChecked(currentList, alreadyChecked);
							break;
						} else if (currentList.contains(temp)) {
							while (currentList.getFirst() != temp) {
								int temp2 = currentList.removeFirst();
								alreadyChecked[temp2] = true;
							}
							if (currentList.size() > longestList.size()) {
								longestList = currentList;
							}
							alreadyChecked = markChecked(currentList, alreadyChecked);
							break;
						} else {
							currentList.add(temp);
						}
					}
				}
			}
		}
		Collections.sort(longestList);
		System.out.println("Ausgabe: " + longestList.getFirst());
	}
	
	/*
	 * Problem solved
	 * 16400th person to have solved this problem
	 * Difficulty rating: 30%
	 * Runtime: 13 minutes 56 seconds
	 * */
}
