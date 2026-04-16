package eulerProject61to90;

import java.math.BigInteger;

public class Problem66 {
	long num;
	Problem66 prev;
	
	public Problem66(long num) {
		this.num = num;
	}
	
	public static BigInteger diophantineEquation(long D) {
		BigInteger bigIntegerD = new BigInteger("" + D);
		BigInteger y = BigInteger.ONE;
		while (true) {
			BigInteger Dy2 = (y.pow(2)).multiply(bigIntegerD);
			BigInteger x = (Dy2.sqrt()).add(BigInteger.ONE);
			if (((x.pow(2)).subtract(Dy2)).compareTo(BigInteger.ONE) == 0) {
				return x;
			} else if (y.compareTo(new BigInteger("100000000")) > 0) {
				System.out.println(D);
				return BigInteger.ZERO;
			}
			y = y.add(BigInteger.ONE);
		}
	}
	
	public static BigInteger continuedFractions(long n) {
		 long divider = 1;
		 long divisor = 1;
		 long maxi = (long) (Math.sqrt(n));
		 long constant = maxi;
		 Problem66 topOfTheStack = new Problem66(constant);
		 long stack = 0;
		 // System.out.println(constant);
		 while (true) {
			 divider = (n - (constant * constant)) * divider;
			 if (divider == divisor) {
				 // System.out.println(constant + maxi);
				 Problem66 temp2 = new Problem66(constant + maxi);
				 temp2.prev = topOfTheStack;
				 topOfTheStack = temp2;
				 stack++;
				 break;
			 }
			 long temp = greatestCommonDivider(divisor, divider);
			 divisor /= temp;
			 divider /= temp;
			 long count = 0;
			 for (; constant >= - maxi; count++) {
				 constant -= (divisor * divider);
			 }
			 count--;
			 constant += (divisor * divider);
			 constant = Math.abs(constant);
			 Problem66 temp2 = new Problem66(count);
			 // System.out.println(count);
			 temp2.prev = topOfTheStack;
			 topOfTheStack = temp2;
			 long temp3 = divider;
			 divider = divisor;
			 divisor = temp3;
			 stack++;
		 }
		 // System.out.println("\n" + stack);
		 if (stack == 1) {
			 
		 } else if (stack % 2 == 1) {
			 long len = stack * 2 - 1;
			 constant = len - stack - 1;
			 constant = stack - constant;
			 Problem66 temp = topOfTheStack;
			 for (;constant > 0; constant--) {
				 temp = temp.prev;
			 }
			 Problem66 topOfSecondStack = new Problem66(temp.num);
			 Problem66 temp2 = topOfSecondStack;
			 temp = temp.prev;
			 while (temp.prev != null) {
				 temp2.prev = new Problem66(temp.num);
				 temp2 = temp2.prev;
				 temp = temp.prev;
			 }
			 temp2.prev = topOfTheStack;
			 topOfTheStack = topOfSecondStack;
		 } else {
			 topOfTheStack = topOfTheStack.prev;
		 }
		 BigInteger[] fraction = {BigInteger.ONE, (BigInteger.ONE).multiply(new BigInteger("" + topOfTheStack.num))};
		 // System.out.println(fraction[0] + " " + fraction[1]);
		 while (topOfTheStack.prev != null) {
			 // System.out.println(fraction[0] + " " + fraction[1]);
			 topOfTheStack = topOfTheStack.prev;
			 fraction[0] = fraction[0].add((new BigInteger("" + topOfTheStack.num)).multiply(fraction[1]));
			 BigInteger temp = fraction[0];
			 fraction[0] = fraction[1];
			 fraction[1] = temp;
		 }
		 return fraction[1];
	}
	
	public static long greatestCommonDivider(long a, long b) {
		long toReturn = Math.min(a, b);
		while (true) {
			if (a % toReturn == 0 && b % toReturn == 0) {
				return toReturn;
			}
			toReturn--;
		}
	}
	
	public static void main(String[] args) {
		BigInteger biggest = BigInteger.ZERO;
		long x = 0;
		for (long i = 1; i <= 1000; i++) {
			double squareRoot = Math.sqrt(i);
			if (Math.ceil(squareRoot) != Math.floor(squareRoot)) {
				BigInteger temp = continuedFractions(i);
				if (temp.compareTo(biggest) == 1) {
					biggest = temp;
					x = i;
				}
			}
		}
		System.out.println("Ausgabe: " + x);
	}
	
	/* Remark: This problem took forever for me to solve, not least because of the complicated method to solve it. I even
	 * had to look up some math stuff in Google to find the algorithm. But at least it's over now. I will admit I
	 * misunderstood what the question asked for, which probably contributed to the time I needed to solve this problem.
	 * Problem solved
	 * 22103rd person to have solved this problem
	 * Difficulty rating: 25%
	 * */
}
