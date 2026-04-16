package eulerProject61to90;

public class Problem61 {
	static boolean finished = false;
	static long minimumHeptagonal = 0;
	static long maximumHeptagonal = 0;
	static long minimumHexagonal = 0;
	static long maximumHexagonal = 0;
	static long maximumPentagonal = 0;
	static long minimumPentagonal = 0;
	static long maximumSquare = 0;
	static long minimumSquare = 0;
	static long maximumTriangle = 0;
	static long minimumTriangle = 0;
	
	public static long octagonalNumber(long input) {
		return input * (3 * input - 2);
	}
	
	public static long heptagonalNumber(long input) {
		return input * (5 * input - 3) / 2;
	}
	
	public static long hexagonalNumber(long input) {
		return input * (2 * input - 1);
	}
	
	public static long pentagonalNumber(long input) {
		return input * (3 * input - 1) / 2;
	}
	
	public static long squareNumber(long input) {
		return input * input;
	}
	
	public static long triangleNumber(long input) {
		return input * (input + 1) / 2;
	}
	
	public static void iteration(long[] result, int recent) {
		if (finished) {
			return;
		}
		long tail = result[recent] % 100;
		boolean check = true;
		if (tail != result[5] / 100) {
			check = false;
		}
		for (int i = 0; i < result.length && check; i++) {
			if (result[i] == 0) {
				check = false;
				break;
			}
		}
		if (check) {
			long sum = 0;
			for (int i = 0; i < result.length; i++) {
				sum += result[i];
			}
			System.out.println("Ausgabe: " + sum);
			finished = true;
			return;
		}
		if (result[0] == 0) {
			for (long i = minimumTriangle; i <= maximumTriangle && !finished; i++) {
				long next = triangleNumber(i);
				long head = next / 100;
				if (tail == head && next % 100 >= 10) {
					long[] resultClone = result.clone();
					resultClone[0] = next;
					iteration(resultClone, 0);
				} else if (tail < head) {
					break;
				}
			}
		}
		if (result[1] == 0) {
			for (long i = minimumSquare; i <= maximumSquare && !finished; i++) {
				long next = squareNumber(i);
				long head = next / 100;
				if (tail == head && next % 100 >= 10) {
					long[] resultClone = result.clone();
					resultClone[1] = next;
					iteration(resultClone, 1);
				} else if (tail < head) {
					break;
				}
			}
		}
		if (result[2] == 0) {
			for (long i = minimumPentagonal; i <= maximumPentagonal && !finished; i++) {
				long next = pentagonalNumber(i);
				long head = next / 100;
				if (tail == head && next % 100 >= 10) {
					long[] resultClone = result.clone();
					resultClone[2] = next;
					iteration(resultClone, 2);
				} else if (tail < head) {
					break;
				}
			}
		}
		if (result[3] == 0) {
			for (long i = minimumHexagonal; i <= maximumHexagonal && !finished; i++) {
				long next = hexagonalNumber(i);
				long head = next / 100;
				if (tail == head && next % 100 >= 10) {
					long[] resultClone = result.clone();
					resultClone[3] = next;
					iteration(resultClone, 3);
				} else if (tail < head) {
					break;
				}
			}
		}
		if (result[4] == 0) {
			for (long i = minimumHeptagonal; i <= maximumHeptagonal && !finished; i++) {
				long next = heptagonalNumber(i);
				long head = next / 100;
				if (tail == head && next % 100 >= 10) {
					long[] resultClone = result.clone();
					resultClone[4] = next;
					iteration(resultClone, 4);
				} else if (tail < head) {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		long n = 5;
		while (heptagonalNumber(n) <= 1000) {
			n++;
		}
		minimumHeptagonal = n;
		while (heptagonalNumber(n) < 10000) {
			n++;
		}
		maximumHeptagonal = n - 1;
		n = 5;
		while (hexagonalNumber(n) <= 1000) {
			n++;
		}
		minimumHexagonal = n;
		while (hexagonalNumber(n) < 10000) {
			n++;
		}
		maximumHexagonal = n - 1;
		n = 5;
		while (pentagonalNumber(n) <= 1000) {
			n++;
		}
		minimumPentagonal = n;
		while (pentagonalNumber(n) < 10000) {
			n++;
		}
		maximumPentagonal = n - 1;
		n = 5;
		while (squareNumber(n) <= 1000) {
			n++;
		}
		minimumSquare = n;
		while (squareNumber(n) < 10000) {
			n++;
		}
		maximumSquare = n - 1;
		n = 5;
		while (triangleNumber(n) <= 1000) {
			n++;
		}
		minimumTriangle = n;
		while (triangleNumber(n) < 10000) {
			n++;
		}
		maximumTriangle = n - 1;
		for (int i = 5; !finished; i++) {
			long octagon = octagonalNumber(i);
			if (octagon <= 1000) {
				continue;
			}
			long[] result = {0, 0, 0, 0, 0, octagon};
			iteration(result, 5);
		}
	}
	
	/*
	 * Problem solved
	 * 28443rd person to have solved this problem
	 * Difficulty rating: 20%
	 * */
}
