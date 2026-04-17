package eulerProject91to120;

import java.math.BigInteger;

public class Problem117 {
	public static BigInteger redGreenAndBlueTiles(int length) {
		BigInteger[] array = new BigInteger[length + 1];
		array[0] = BigInteger.ONE;
		array[1] = BigInteger.ONE;
		array[2] = BigInteger.TWO;
		array[3] = new BigInteger("4");
		array[4] = new BigInteger("8");
		for (int i = 5; i <= length; i++) {
			array[i] = BigInteger.ZERO;
			for (int j = 1; j < 5; j++) {
				array[i] = array[i].add(array[i - j]);
			}
		}
		/*
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + " " + array[i]);
		}
		*/
		return array[length];
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + redGreenAndBlueTiles(50));
	}
	
	/*
	 * Problem solved
	 * 12608th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: 1 second
	 * */
}
