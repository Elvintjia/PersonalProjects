package eulerProject91to120;

import java.math.BigInteger;

public class Problem100Test {
	public static void main(String[] args) {
		int index = 0;
		BigInteger i = new BigInteger("655869061");
		for (; index < 1000; i = i.add(BigInteger.ONE)) {
			if (Problem100.arrangedProbability2(i)) {
				System.out.println(i);
				index++;
				i = i.multiply(new BigInteger("5828").divide(new BigInteger("1000")));
			}
		}
	}
}
