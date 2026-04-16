package eulerProject31To60;

public class Problem33 {
	public static int[] simplifyFraction(int[] fraction) {
		int divider = 2;
		for ( ;divider <= fraction[0]; divider++) {
			if (fraction[0] % divider == 0 && fraction[1] % divider == 0) {
				fraction[0] /= divider;
				fraction[1] /= divider;
				divider = 1;
			}
		}
		return fraction;
	}
	
	public static boolean digitCancelling(int[] fraction) {
		String up = "" + fraction[0];
		String down = "" + fraction[1];
		if (up.contains("0") || down.contains("0")) {
			return false;
		}
		boolean changed = false;
		for (int i = 1; i <= 9; i++) {
			String iString = "" + i;
			if (up.contains(iString) && down.contains(iString)) {
				up = up.replace(iString, "");
				if (up.equals("")) {
					up += iString;
				}
				down = down.replace(iString, "");
				if (down.equals("")) {
					down += iString;
				}
				changed = true;
				break;
			}
		}
		int[] newFraction = {Integer.valueOf(up), Integer.valueOf(down)};
		int[] oldSimplifiedFraction = simplifyFraction(fraction);
		int[] newSimplifiedFraction = simplifyFraction(newFraction);
		return (changed && oldSimplifiedFraction[0] == newSimplifiedFraction[0] &&
				oldSimplifiedFraction[1] == newSimplifiedFraction[1]);
	}
	
	public static void main(String[] args) {
		int[][] test = new int[4][2];
		int index = 0;
		for (int i = 10; i <= 99; i++) {
			for (int j = 10; j < i; j++) {
				if (i != j) {
					int[] check = {j, i};
					if (digitCancelling(check)) {
						test[index] = check;
						index++;
						if (index >= 4) {
							i = 100;
							j = 100;
						}
					}
				}
			}
		}
		int[] newFraction = {1, 1};
		for (int i = 0; i < 4; i++) {
			newFraction[0] *= test[i][0];
			newFraction[1] *= test[i][1];
		}
		newFraction = simplifyFraction(newFraction);
		System.out.println("Ausgabe: " + newFraction[1]);
	}
	
	/*
	 * Problem solved
	 * 78028th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
