package eulerProject91to120;

public class Problem116 {
	public static long redGreenOrBlueTiles(int length) {
		long sum = red(length);
		sum += green(length);
		sum += blue(length);
		return sum;
	}
	
	public static long red(int length) {
		long[] array = new long[length + 1];
		array[0] = 1;
		array[1] = 1;
		array[2] = 2;
		for (int i = 3; i <= length; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[length] - 1;
	}
	
	public static long green(int length) {
		long[] array = new long[length + 1];
		for (int i = 0; i <= 3; i++) {
			array[i] = 1;
			if (i == 3) {
				array[i]++;
			}
		}
		for (int i = 4; i <= length; i++) {
			array[i] = array[i - 1] + array[i - 3];
		}
		return array[length] - 1;
	}
	
	public static long blue(int length) {
		long[] array = new long[length + 1];
		for (int i = 0; i <= 4; i++) {
			array[i] = 1;
			if (i == 4) {
				array[i]++;
			}
		}
		for (int i = 5; i <= length; i++) {
			array[i] = array[i - 1] + array[i - 4];
		}
		return array[length] - 1;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + redGreenOrBlueTiles(50));
	}
	
	/*
	 * Problem solved
	 * 13656th person to have solved this problem
	 * Difficulty rating: 30%
	 * Runtime: Less than 1 second
	 * */
}
