package eulerProject91to120;

import java.math.BigInteger;

public class Problem100 {
	public static BigInteger arrangedProbability(BigInteger x) {
		BigInteger eight = new BigInteger("8");
		BigInteger squared = x.multiply(x).multiply(eight).subtract(x.multiply(eight)).add(BigInteger.ONE).sqrt();
		BigInteger fraction = BigInteger.ONE.subtract(x.multiply(BigInteger.TWO)).add(squared).divide(BigInteger.TWO);
		return x.add(fraction);
	}
	
	public static boolean arrangedProbability2(BigInteger x) {
		BigInteger eight = new BigInteger("8");
		BigInteger toSquare = x.multiply(x).multiply(eight).subtract(x.multiply(eight)).add(BigInteger.ONE);
		BigInteger squared = toSquare.sqrt();
		return squared.multiply(squared).equals(toSquare);
	}
	
	public static void main(String[] args) {
		BigInteger top = new BigInteger("1000000000000");
		BigInteger bottom = new BigInteger("15");
		while (!bottom.add(BigInteger.ONE).equals(top)) {
			BigInteger difference = top.subtract(bottom);
			difference = difference.divide(BigInteger.TWO);
			BigInteger x = bottom.add(difference);
			// System.out.println(x);
			BigInteger temp = arrangedProbability(x);
			if (temp.compareTo(new BigInteger("1000000000000")) >= 1) {
				top = x;
			} else {
				bottom = x;
			}
		}
		BigInteger prev = new BigInteger("3");
		BigInteger next = new BigInteger("15");
		BigInteger added = BigInteger.ZERO;
		while (next.compareTo(bottom) < 0) {
			// System.out.println(next);
			BigInteger temp = next.multiply(new BigInteger("1000")).divide(prev);
			temp = temp.multiply(next).divide(new BigInteger("1000"));
			temp = temp.add(added);
			while (!arrangedProbability2(temp)) {
				temp = temp.add(BigInteger.ONE);
				added = added.add(BigInteger.ONE);
			}
			prev = next;
			next = temp;
		}
		// Checkpoint: 709 784 061 000
		// Checkpoint 2: 709 842 926 000
		// Checkpoint 3: 710 148 696 000
		// Calc: 7.87723942
		// Checkpoint 4: 788 135 510 000
		// Checkpoint 5: 788606466000
		// Checkpoint 6: 796785642000
		System.out.println("Ausgabe: " + next);
	}
	
	/* Remark: So, a mistake in my calculation could have made me spend so much long on this damn problem. Thankfully, I
	 * found a solution that reduced the runtime by a considerable amount.
	 * Problem solved
	 * 18651st person to have solved this problem
	 * Difficulty rating: 30%
	 * Runtime: 2 minutes 36 seconds
	 * */
}
