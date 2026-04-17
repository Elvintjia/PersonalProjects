package eulerProject91to120;

import java.util.ArrayList;

public class Problem106 {
	public static int specialSubsetSumsMetaTesting(ArrayList<Integer> array) {
		int sum = 0;
		for (int i = 2; i * 2 <= array.size(); i++) {
			sum += firstGroup(array, new ArrayList<Integer>(), i, 0);
		}
		return sum;
	}
	
	@SuppressWarnings("unchecked")
	public static int firstGroup(ArrayList<Integer> array, ArrayList<Integer> groupOne, int leftToRemove, int index) {
		if (array.size() < leftToRemove + index) {
			return 0;
		} else if (leftToRemove == 0) {
			int nextIndex = 0;
			while (groupOne.getFirst() > array.get(nextIndex)) {
				nextIndex++;
				if (nextIndex == array.size()) {
					return 0;
				}
			}
			return secondGroup(array, groupOne, new ArrayList<Integer>(), groupOne.size(), nextIndex);
		} else {
			int sum = 0;
			for (int i = index; i < array.size(); i++) {
				ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
				ArrayList<Integer> groupOneCopy = (ArrayList<Integer>) groupOne.clone();
				groupOneCopy.add(arrayCopy.remove(i));
				sum += firstGroup(arrayCopy, groupOneCopy, leftToRemove - 1, i);
			}
			return sum;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static int secondGroup(ArrayList<Integer> array, ArrayList<Integer> groupOne, ArrayList<Integer> groupTwo,
			int leftToRemove, int index) {
		if (array.size() < leftToRemove + index) {
			return 0;
		} else if (leftToRemove == 0) {
			return (needEqualityTesting(groupOne, groupTwo) ? 1 : 0);
		} else {
			int sum = 0;
			for (int i = index; i < array.size(); i++) {
				ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
				ArrayList<Integer> groupTwoCopy = (ArrayList<Integer>) groupTwo.clone();
				groupTwoCopy.add(arrayCopy.remove(i));
				sum += secondGroup(arrayCopy, groupOne, groupTwoCopy, leftToRemove - 1, i);
			}
			return sum;
		}
	}
	
	public static boolean needEqualityTesting(ArrayList<Integer> a, ArrayList<Integer> b) {
		// System.out.println(a + " " + b);
		boolean aBiggerThanB = false;
		boolean bBiggerThanA = false;
		for (int i = 0; i < a.size(); i++) {
			if (!bBiggerThanA && a.get(i) < b.get(i)) {
				bBiggerThanA = true;
			} else if (!aBiggerThanB && a.get(i) > b.get(i)) {
				aBiggerThanB = true;
			}
			if (aBiggerThanB && bBiggerThanA) {
				// System.out.println(true);
				return true;
			}
		}
		// System.out.println(false);
		return false;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			a.add(i);
		}
		System.out.println("Ausgabe: " + specialSubsetSumsMetaTesting(a));
	}
	
	/* Remark: For a problem marked at 50% difficulty, this problem is rather easy to solve and doesn't require complicated
	 * thinking or algorithm.
	 * Problem solved
	 * 7389th person to have solved this problem
	 * Difficulty rating: 50%
	 * Runtime: Less than 1 second
	 * */
}
