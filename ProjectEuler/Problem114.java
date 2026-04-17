package eulerProject91to120;

import java.util.ArrayList;
import java.math.BigInteger;

public class Problem114 {
	public static int countingBlockCombinations(int length) {
		return iter(length, true);
	}
	
	public static int iter(int length, boolean start) {
		if (!start) {
			length--;
		}
		if (length < 3) {
			return 1;
		}
		int toReturn = 0;
		for (int i = length; i > 0; i++) {
			toReturn += iter(length - i, false);
		}
		return toReturn;
	}
	
	public static int countingBlockCombinationsTwo(int length) {
		
		return 0;
	}
	
	// @SuppressWarnings("unchecked")
	public static int blocksToInsert(int remainingLength, ArrayList<Integer> blocks, int length) {
		if (remainingLength < 3) {
			return combinatorics(blocks, length);
		}
		int toReturn = 0;
		for (int i = remainingLength; i >= 3; i--) {
			// ArrayList<Integer> blocksCopy = (ArrayList<Integer>) blocks.clone();
			
		}
		return toReturn;
	}
	
	@SuppressWarnings("unchecked")
	public static int combinatorics(ArrayList<Integer> blocks, int length) {
		if (blocks.isEmpty()) {
			return 1;
		}
		int toReturn = 0;
		for (int i = 0; i < blocks.size(); i++) {
			ArrayList<Integer> blocksCopy = (ArrayList<Integer>) blocks.clone();
			int toRemove = blocksCopy.remove(i);
			if (length >= toRemove) {
				toReturn += combinatorics(blocksCopy, length - toRemove - 1);
			}
		}
		toReturn += combinatorics(blocks, length - 1);
		return toReturn;
	}
	
	public static BigInteger countingBlockCombinationsThree(int length) {
		boolean[] row = new boolean[length];
		return iter(row, 0, 0, false);
	}
	
	public static BigInteger iter(boolean[] row, int redBlockToPutIn, int index, boolean prev) {
		if (index == row.length && redBlockToPutIn == 0) {
			return BigInteger.ONE;
		} else if (index == row.length && redBlockToPutIn > 0) {
			return BigInteger.ZERO;
		} else if (redBlockToPutIn > 0) {
			row[index] = true;
			return iter(row, redBlockToPutIn - 1, index + 1, true);
		} else if (prev && redBlockToPutIn == 0) {
			BigInteger toReturn = BigInteger.ZERO;
			boolean[] rowCopy = row.clone();
			rowCopy[index] = true;
			toReturn = toReturn.add(iter(rowCopy, 0, index + 1, true));
			toReturn = toReturn.add(iter(row, 0, index + 1, false));
			return toReturn;
		} else {
			BigInteger toReturn = BigInteger.ZERO;
			boolean[] rowCopy = row.clone();
			rowCopy[index] = true;
			toReturn = toReturn.add(iter(rowCopy, 2, index + 1, true));
			toReturn = toReturn.add(iter(row, 0, index + 1, false));
			return toReturn;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + countingBlockCombinationsThree(50));
	}
	
	/* Remark: I was going for a methodical and advanced approach, but then decided upon a bruteforce method instead. It
	 * worked okay, though it took a decent amount of time.
	 * Problem solved
	 * 12299th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: 17 minutes 38 seconds
	 * */
}
