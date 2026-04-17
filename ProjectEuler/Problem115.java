package eulerProject91to120;

import java.util.ArrayList;

public class Problem115 {
	public static int countingBlocksCombination(int minLength, int fillCount) {
		ArrayList<String> start = new ArrayList<>();
		String temp = "";
		for (int i = 0; i < minLength; i++) {
			temp += "1";
		}
		start.add(temp);
		temp = "";
		for (int i = 0; i < minLength; i++) {
			temp += "0";
		}
		start.add(temp);
		System.out.println(start);
		ArrayList<String> end = new ArrayList<>();
		int count = 0;
		int currentLength = 3;
		while (count < fillCount) {
			count = 0;
			while (!start.isEmpty()) {
				temp = start.removeFirst();
				if (temp.length() == currentLength) {
					count++;
					if (temp.charAt(0) == '1') {
						String temp2 = "1" + temp;
						if (!end.contains(temp2)) {
							end.add(temp2);
						}
						temp2 = "0" + temp;
						if (!end.contains(temp2)) {
							end.add(temp2);
						}
					} else {
						String temp2 = "111" + temp;
						if (!end.contains(temp2)) {
							end.add(temp2);
						}
						temp2 = "0" + temp;
						if (!end.contains(temp2)) {
							end.add(temp2);
						}
					}
					if (temp.charAt(temp.length() - 1) == '1') {
						String temp2 = temp + "1";
						if (!end.contains(temp2)) {
							end.add(temp2);
						}
						temp2 = temp + "0";
						if (!end.contains(temp2)) {
							end.add(temp2);
						}
					} else {
						String temp2 = temp + "111";
						if (!end.contains(temp2)) {
							end.add(temp2);
						}
						temp2 = temp + "0";
						if (!end.contains(temp2)) {
							end.add(temp2);
						}
					}
				} else {
					if (!end.contains(temp)) {
						end.add(temp);
					}
				}
			}
			start = end;
			end = new ArrayList<>();
			currentLength++;
		}
		System.out.println(start);
		return currentLength - 1;
	}
	
	public static long countingBlocksCombinationTwo(int minLength, long nLength) {
		ArrayList<Long> array = new ArrayList<>();
		for (int i = 0; i <= minLength; i++) {
			if (i == minLength) {
				array.add(2l);
			} else {
				array.add(1l);
			}
		}
		/*
		long[] array = new long[length + 1];
		for (int i = 0; i <= minLength; i++) {
			array[i] = 1;
			if (i == minLength) {
				array[i]++;
			}
		}
		*/
		int i = minLength + 1;
		for (; array.getLast() < nLength; i++) {
			long sum = 0;
			for (int j = minLength + 1; j <= i; j++) {
				sum += array.get(i - j);
			}
			sum += array.get(i - 1);
			sum++;
			array.add(sum);
		}
		/*
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + " " + array[i]);
		}
		*/
		return i - 1;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + countingBlocksCombinationTwo(50, 1000000l));
	}
	
	/*
	 * Problem solved
	 * 11250th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: Less than 1 second
	 * */
}
