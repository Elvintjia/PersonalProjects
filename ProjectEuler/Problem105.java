package eulerProject91to120;

import java.util.ArrayList;
import java.io.*;

public class Problem105 {
	@SuppressWarnings("unchecked")
	public static boolean specialSubsetSums(ArrayList<Integer> array) {
		boolean toReturn = true;
		for (int i = 1; i <= (array.size() / 2); i++) {
			// System.out.println("check4");
			ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
			if (!firstGroup(arrayCopy, new ArrayList<Integer>(), i, 0)) {
				toReturn = false;
				break;
			}
		}
		return toReturn;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean firstGroup(ArrayList<Integer> array, ArrayList<Integer> groupOne, int leftToRemove, int index) {
		if (leftToRemove + index > array.size()) {
			return true;
		} else if (leftToRemove == 0) {
			// System.out.println(array + " " + groupOne);
			for (int i = 1; i <= array.size(); i++) {
				// System.out.println(i);
				if (!secondGroup(array, groupOne, new ArrayList<Integer>(), i, 0)) {
					// System.out.println("check2");
					return false;
				}
			}
			// System.out.println("check3");
			return true;
		} else {
			for (int i = index; i < array.size(); i++) {
				ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
				ArrayList<Integer> groupOneCopy = (ArrayList<Integer>) groupOne.clone();
				groupOneCopy.add(arrayCopy.remove(i));
				if (!firstGroup(arrayCopy, groupOneCopy, leftToRemove - 1, i)) {
					return false;
				}
			}
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static boolean secondGroup(ArrayList<Integer> array, ArrayList<Integer> groupOne, ArrayList<Integer> groupTwo,
			int leftToRemove, int index) {
		// System.out.println(groupOne);
		if (leftToRemove + index > array.size()) {
			return true;
		} else if (leftToRemove == 0) {
			// System.out.println(groupOne + " " + groupTwo);
			return specialSubsetSums2(groupOne, groupTwo);
		} else {
			for (int i = index; i < array.size(); i++) {
				ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
				ArrayList<Integer> groupTwoCopy = (ArrayList<Integer>) groupTwo.clone();
				groupTwoCopy.add(arrayCopy.remove(i));
				// System.out.println(groupOne);
				if (!secondGroup(arrayCopy, groupOne, groupTwoCopy, leftToRemove - 1, i)) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static boolean specialSubsetSums2(ArrayList<Integer> firstGroup, ArrayList<Integer> secondGroup) {
		long sumOne = arraySum(firstGroup);
		long sumTwo = arraySum(secondGroup);
		// System.out.println(sumOne + " " +  firstGroup);
		// System.out.println(sumTwo + " " + secondGroup);
		return ((sumOne > sumTwo && firstGroup.size() > secondGroup.size()) || (sumOne < sumTwo && firstGroup.size() <
				secondGroup.size()) || (sumOne != sumTwo && firstGroup.size() == secondGroup.size()));
	}
	
	public static long arraySum(ArrayList<Integer> array) {
		long sum = 0;
		for (int i = 0; i < array.size(); i++) {
			sum += array.get(i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		long totalSum = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("0105_sets.txt")))) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				ArrayList<Integer> array = new ArrayList<>();
				for (; line.contains(","); line = line.substring(line.indexOf(',') + 1)) {
					array.add(Integer.valueOf(line.substring(0, line.indexOf(','))));
				}
				array.add(Integer.valueOf(line));
				if (specialSubsetSums(array)) {
					// System.out.println(array);
					totalSum += arraySum(array);
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println("Ausgabe: " + totalSum);
	}
	
	/*
	 * Problem solved
	 * 9226th person to have solved this problem
	 * Difficulty rating: 45%
	 * Runtime: 2 seconds
	 * */
}
