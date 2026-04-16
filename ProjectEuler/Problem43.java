package eulerProject31To60;

public class Problem43 {
	public static boolean isPandigital(long eingabe) {
		String stringEingabe = "" + eingabe;
		long array[] = new long[10];
		for (int i = 0; i < array.length; i++) {
			array[Integer.valueOf("" + stringEingabe.charAt(i))]++;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 1) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean check(long eingabe) {
		String stringEingabe = "" + eingabe;
		long[] array = {2, 3, 5, 7, 11, 13, 17};
		for (int i = 0; i < array.length; i++) {
			if (i != 6) {
				if (Long.valueOf(stringEingabe.substring(i + 1, i + 4)) % array[i] != 0) {
					return false;
				}
			} else {
				if (Long.valueOf(stringEingabe.substring(7)) % array[i] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long sum = 0;
		for (long i = 1000000000; i <= 1e10; i++) {
			if (isPandigital(i)) {
				if (check(i)) {
					sum += i;
				}
			}
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/* Remark: Actually took longer than 1 minute to finish compiling, but it's not so bad.
	 * Problem solved
	 * 65447th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
