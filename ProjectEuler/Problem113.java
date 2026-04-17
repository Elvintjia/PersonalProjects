package eulerProject91to120;

import java.math.BigInteger;

public class Problem113 {
	public static boolean isBouncy(BigInteger toCheck) {
		String toCheckString = toCheck + "";
		boolean ascend = false;
		boolean descend = false;
		for (int i = 0; i < toCheckString.length() - 1; i++) {
			if (toCheckString.charAt(i) < toCheckString.charAt(i + 1)) {
				ascend = true;
			} else if (toCheckString.charAt(i) > toCheckString.charAt(i + 1)) {
				descend = true;
			}
			if (ascend && descend) {
				return true;
			}
		}
		return false;
	}
	
	public static BigInteger nonBouncyNumbers(int limit) {
		if (limit <= 0) {
			return BigInteger.ZERO;
		}
		BigInteger toReturn = BigInteger.ZERO;
		for (BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.TEN) < 0; i = i.add(BigInteger.ONE)) {
			toReturn = toReturn.add(iter(limit, i));
		}
		return toReturn;
	}
	
	public static BigInteger iter(int limit, BigInteger num) {
		System.out.println(num);
		if (isBouncy(num)) {
			return BigInteger.ZERO;
		}
		if (limit == (num + "").length()) {
			return BigInteger.ONE;
		}
		BigInteger toReturn = BigInteger.ONE;
		for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.TEN) < 0; i = i.add(BigInteger.ONE)) {
			toReturn = toReturn.add(iter(limit, num.multiply(BigInteger.TEN).add(i)));
		}
		return toReturn;
	}
	
	public static BigInteger nonBouncyNumbersTwo(int limit) {
		BigInteger toReturn = increasing(limit).add(decreasing(limit));
		toReturn = toReturn.subtract((new BigInteger("" + limit)).multiply(new BigInteger("9")));
		return toReturn;
	}
	
	public static BigInteger decreasing(int limit) {
		/* Array[x][y]
		 * x = First number
		 * y = length
		 * */
		BigInteger[][] array = new BigInteger[9][limit];
		for (int i = 0; i < array.length; i++) {
			array[i][0] = BigInteger.ONE;
		}
		for (int i = 1; i < limit; i++) {
			array[0][i] = array[0][i - 1].add(BigInteger.ONE);
			for (int j = 1; j < 9; j++) {
				array[j][i] = array[j - 1][i].add(array[j][i - 1]);
			}
		}
		BigInteger toReturn = BigInteger.ZERO;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				toReturn = toReturn.add(array[i][j]);
			}
		}
		return toReturn;
	}
	
	public static BigInteger increasing(int limit) {
		/* Array[x][y]
		 * x = First number
		 * y = length
		 * */
		BigInteger[][] array = new BigInteger[9][limit];
		for (int i = 0; i < array.length; i++) {
			array[i][0] = BigInteger.ONE;
			
		}
		for (int i = 1; i < limit; i++) {
			array[0][i] = BigInteger.ONE;
			for (int j = 1; j < array.length; j++) {
				array[j][i] = array[j - 1][i].add(array[j][i - 1]);
			}
		}
		BigInteger toReturn = BigInteger.ZERO;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < limit; j++) {
				toReturn = toReturn.add(array[i][j]);
			}
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + nonBouncyNumbersTwo(100));
	}
	
	/* Remark: This problem really took me a long time. I needed ages to understand the solution offered in the internet,
	 * and I'm not even sure I understood it right. I might have just made another form of the same solution. Who can
	 * tell?
	 * Problem solved
	 * 12486th person to have solved this problem
	 * Difficulty rating: 30%
	 * Runtime: Less than 1 second
	 * */
}
