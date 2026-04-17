package eulerProject121to150;

public class Problem128 {
	public static boolean isPrime(long input) {
		if (input <= 1) {
			return false;
		}
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean threePrimes(long[] array) {
		int primes = 0;
		for (int i = 0; i < array.length; i++) {
			if (isPrime(array[i])) {
				primes++;
			}
		}
		return primes == 3;
	}
	
	public static long hexagonalTileDifferences(int n) {
		n -= 2;
		long current = 8;
		long next = 20;
		long prev = 2;
		long counter = 2;
		long ringStart = 8;
		long ringEnd = 19;
		long tileToCorner = 1;
		while (n > 0) {
			if (current == ringStart) {
				long[] array = new long[5];
				array[0] = ringEnd - current;
				array[1] = next - current;
				array[2] = array[1] + 1;
				array[3] = next + (counter + 1) * 6 - 1 - current;
				array[4] = current - prev;
				/*
				String temp = "";
				for (int i = 0; i < array.length; i++) {
					temp += array[i] + " ";
				}
				System.out.println(temp);
				*/
				if (threePrimes(array)) {
					n--;
					// System.out.println(current + " " + n);
					if (n == 0) {
						return current;
					}
				}
				current++;
				next++;
			} else if (current == ringEnd) {
				long[] array = new long[5];
				array[0] = current - ringStart;
				array[1] = next - current;
				array[2] = array[1] + 1;
				array[3] = current - prev;
				array[4] = current - (prev - (counter - 1) * 6 + 1);
				/*
				String temp = "";
				for (int i = 0; i < array.length; i++) {
					temp += array[i] + " ";
				}
				System.out.println(temp);
				*/
				if (threePrimes(array)) {
					n--;
					// System.out.println(current + " " + n);
					if (n == 0) {
						return current;
					}
				}
				current++;
				counter++;
				next += 2;
				prev++;
				ringStart = current;
				ringEnd = current + (counter * 6) - 1;
				tileToCorner = counter - 1;
			} else if (tileToCorner > 0) {
				long[] array = new long[4];
				array[0] = next - current;
				array[1] = array[0] + 1;
				array[2] = current - prev;
				array[3] = array[2] + 1;
				if (threePrimes(array)) {
					n--;
					// System.out.println(current + " " + n);
					if (n == 0) {
						return current;
					}
				}
				current++;
				next++;
				prev++;
				tileToCorner--;
			} else {
				long[] array = new long[4];
				array[0] = next - current;
				array[1] = array[0] + 1;
				array[2] = array[1] + 1;
				array[3] = current - prev;
				if (threePrimes(array)) {
					n--;
					// System.out.println(current + " " + n);
					if (n == 0) {
						return current;
					}
				}
				current++;
				next += 2;
				tileToCorner = counter - 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + hexagonalTileDifferences(2000));
	}
	
	/* Remark: This problem took a lot of runtime. I can probably optimize the damn thing, but I'm not going to bother.
	 * I left my laptop running and put it to sleep multiple times while the program works, so I don't know the exact
	 * runtime for the program.
	 * Problem solved
	 * 5832nd person to have solved this problem
	 * Problem level: 16
	 * */
}
