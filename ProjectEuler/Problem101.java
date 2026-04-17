package eulerProject91to120;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem101 {
	public static BigInteger optimumPolynomial(BigInteger x) {
		BigInteger toReturn = BigInteger.ONE;
		for (int i = 0; i < 10; i++) {
			BigInteger temp = x.pow(i + 1);
			if (i % 2 == 0) {
				toReturn = toReturn.subtract(temp);
			} else {
				toReturn = toReturn.add(temp);
			}
		}
		return toReturn;
	}
	
	public static BigInteger optimumPolynomial2(ArrayList<BigInteger> array) {
		ArrayList<ArrayList<BigInteger>> polynomials = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			ArrayList<BigInteger> temp = new ArrayList<>();
			for (int j = 0; j < array.size(); j++) {
				BigInteger temp2 = new BigInteger((i + 1) + "");
				temp2 = temp2.pow(j);
				temp.addFirst(temp2);
			}
			polynomials.add(temp);
		}
		// System.out.println(polynomials);
		ArrayList<BigInteger> results = new ArrayList<>();
		optimumPolynomial3(polynomials, array, results);
		// System.out.println(results);
		BigInteger toReturn = BigInteger.ZERO;
		BigInteger n = new BigInteger((array.size() + 1) + "");
		for (int i = results.size() - 1; i >= 0; i--) {
			toReturn = toReturn.add(n.pow(i).multiply(results.removeFirst()));
		}
		return toReturn;
	}
	
	public static void optimumPolynomial3(ArrayList<ArrayList<BigInteger>> polynomials, ArrayList<BigInteger> array,
			ArrayList<BigInteger> results) {
		// System.out.println(polynomials);
		if (polynomials.size() == 1) {
			results.add(array.get(0).divide(polynomials.get(0).get(0)));
		} else {
			ArrayList<ArrayList<BigInteger>> nextPolynomials = new ArrayList<>();
			ArrayList<BigInteger> nextArray = new ArrayList<>();
			for (int i = 0; i < polynomials.size() - 1; i++) {
				ArrayList<BigInteger> temp = new ArrayList<>();
				for (int j = 0; j < polynomials.size() - 1; j++) {
					temp.add(polynomials.get(i).get(j).subtract(polynomials.get(i + 1).get(j)));
				}
				nextPolynomials.add(temp);
				nextArray.add(array.get(i).subtract(array.get(i + 1)));
			}
			optimumPolynomial3(nextPolynomials, nextArray, results);
			BigInteger divisor = BigInteger.ZERO;
			for (int i = 0; i < polynomials.size() - 1; i++) {
				divisor = divisor.add(polynomials.getFirst().get(i).multiply(results.get(i)));
			}
			BigInteger divisor2 = array.get(0).subtract(divisor);
			results.add(divisor2.divide(polynomials.getFirst().getLast()));
		}
	}
	
	public static void main(String[] args) {
		ArrayList<BigInteger> array = new ArrayList<>();
		BigInteger result = BigInteger.ZERO;
		for (BigInteger x = BigInteger.ONE; x.compareTo(new BigInteger("10")) <= 0; x = x.add(BigInteger.ONE)) {
			array.add(optimumPolynomial(x));
			result = result.add(optimumPolynomial2(array));
		}
		System.out.println("Ausgabe: " + result);
		/* FIT
		 * 1
		 * 1 365
		 * 130 813
		 * */
	}
	
	/* Remark: I thought about doing this by hand, but it would have been long and complicated, then I realized there's a
	 * pattern I could use to build a proper program, so I did as necessary, and got a working program.
	 * Problem solved
	 * 13257th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: Less than 1 second
	 * */
}
