package eulerProject91to120;

import java.math.BigInteger;

public class Problem94 {
	public static BigInteger[] check(BigInteger lowestH, BigInteger oneSide, boolean moreLength) {
		BigInteger twoSides = oneSide;
		if (moreLength) {
			twoSides = twoSides.add(BigInteger.ONE);
		} else {
			twoSides = twoSides.subtract(BigInteger.ONE);
		}
		BigInteger perimeter = oneSide.add(twoSides).add(twoSides);
		oneSide = oneSide.divide(BigInteger.TWO);
		BigInteger hQuadrat = twoSides.multiply(twoSides).subtract(oneSide.multiply(oneSide));
		BigInteger i = lowestH.multiply(lowestH);
		for (; i.compareTo(hQuadrat) < 0; lowestH = lowestH.add(BigInteger.ONE)) {
			i = lowestH.multiply(lowestH);
		}
		BigInteger[] toReturn = new BigInteger[3];
		if (i.compareTo(hQuadrat) == 0) {
			toReturn[0] = BigInteger.ONE;
			toReturn[1] = perimeter;
		} else {
			toReturn[0] = BigInteger.ZERO;
		}
		toReturn[2] = lowestH;
		return toReturn;
	}
	
	public static boolean stop(BigInteger oneSide, boolean moreLength) {
		oneSide = oneSide.multiply(new BigInteger("3"));
		if (moreLength) {
			oneSide = oneSide.add(BigInteger.TWO);
		} else {
			oneSide = oneSide.subtract(BigInteger.TWO);
		}
		return (oneSide.compareTo(new BigInteger("1000000000")) > 0);
	}
	
	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		boolean moreLength = false;
		BigInteger lowestH = BigInteger.TWO;
		for (BigInteger i = new BigInteger("4"); !stop(i, moreLength); i = i.add(BigInteger.TWO)) {
			/*
			if (i.remainder(new BigInteger("1000")).equals(BigInteger.ZERO)) {
				System.out.println(i);
			}
			*/
			BigInteger[] temp = check(lowestH, i, moreLength);
			if (temp[0].equals(BigInteger.ONE)) {
				sum = sum.add(temp[1]);
				moreLength = !moreLength;
			}
			lowestH = temp[2];
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/* Remark: This problem took me way longer than I hoped it would. I tried doing multiple ways to do it, even giving up
	 * and looking at the internet for solutions, but didn't understand the solution and had to work out my own. I think
	 * my mistake was trying to use square root with big numbers. It's not very accurate. It's much better to just use
	 * multiplication, even if they are very big or complicated.
	 * Problem solved
	 * 14286th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: 1 minute 20 seconds
	 * */
}
