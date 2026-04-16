package eulerProject61to90;

public class Problem62 {
	long num = 0;
	Problem62 next;
	
	public Problem62(long num) {
		this.num = num;
	}
	
	public static long cube(long input) {
		return input * input * input;
	}
	public static boolean permutation(long a, long b) {
		String stringA = "" + a;
		String stringB = "" + b;
		if (stringA.length() != stringB.length()) {
			return false;
		}
		boolean[] array = new boolean[stringA.length()];
		for (int i = 0; i < stringA.length(); i++) {
			for (int j = 0; j < stringB.length(); j++) {
				if (stringA.charAt(i) == stringB.charAt(j) && !array[j]) {
					array[j] = true;
					break;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (!array[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem62 start = new Problem62(cube(11));
		boolean finished = false;
		for (long i = 12; !finished; i++) {
			long count = 0;
			long cubed = cube(i);
			Problem62 checked = start;
			while (true) {
				if (permutation(cubed, checked.num)) {
					count++;
				}
				if (checked.next == null) {
					break;
				} else {
					checked = checked.next;
				}
			}
			if (count == 4) {
				Problem62 current = start;
				while (!finished) {
					if (permutation(current.num, cubed)) {
						System.out.println("Ausgabe: " + current.num);
						finished = true;
					}
					current = current.next;
				}
			} else {
				checked.next = new Problem62(cubed);
			}
		}
	}
	
	/*
	 * Problem solved
	 * 34995th person to have solved this problem
	 * Difficulty rating: 15%
	 * */
}
