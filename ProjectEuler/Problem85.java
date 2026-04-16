package eulerProject61to90;

public class Problem85 {
	public static long countingRectangles(long a, long b) {
		long toReturn = 0;
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				toReturn += (a - i + 1) * (b - j + 1);
			}
		}
		return toReturn;
	}
	
	public static long closestTo2Mil(long a, long b) {
		if (Math.abs(a - 2000000) < Math.abs(b - 2000000)) {
			return a;
		} else {
			return b;
		}
	}
	
	public static void main(String[] args) {
		long closest = 0;
		long[] saved = new long[2];
		long i = 1;
		while (true) {
			// System.out.println(i);
			long temp = countingRectangles(i, 1);
			closest = closestTo2Mil(closest, temp);
			if (temp == closest) {
				saved[0] = i;
				saved[1] = 1;
			}
			if (temp > 2000000) {
				break;
			}
			long j = 2;
			while (temp < 2000000) {
				temp = countingRectangles(i, j);
				closest = closestTo2Mil(closest, temp);
				if (closest == temp) {
					saved[0] = i;
					saved[1] = j;
				}
				j++;
			}
			closest = closestTo2Mil(closest, temp);
			if (closest == temp) {
				saved[0] = i;
				saved[1] = j;
			}
			i++;
		}
		System.out.println("Ausgabe: " + (saved[0] * saved[1]));
	}
	
	/*
	 * Problem solved
	 * 27368th person to have solved this problem
	 * Difficulty rating: 15%
	 * Runtime: Less than 1 second
	 * */
}
