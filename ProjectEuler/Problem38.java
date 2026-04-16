package eulerProject31To60;

public class Problem38 {
	public static boolean isPandigital(String eingabe) {
		if (eingabe.contains("0")) {
			return false;
		}
		char[] liste = new char[9];
		for (int i = 0; i < liste.length; i++) {
			liste[i] = (char) ('1' + i);
		}
		for (int i = 0; i < liste.length; i++) {
			int count = 0;
			for (int j = 0; j < eingabe.length(); j++) {
				if (liste[i] == eingabe.charAt(j)) {
					count++;
				}
			}
			if (count != 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long max = 0;
		for (int i = 1; i < 1e6; i++) {
			String number = "";
			for (int j = 1; number.length() < 9; j++) {
				number += (i * j);
			}
			if (number.length() == 9 && isPandigital(number)) {
				max = Math.max(max, Long.valueOf(number));
			}
		}
		System.out.println("Ausgabe: " + max);
	}
	
	/*
	 * Problem solved
	 * 68691st person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
