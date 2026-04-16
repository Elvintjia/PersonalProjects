package eulerProject1To30;

public class Problem4 {
	public static boolean Palindrome(int Zahl) {
		String str = "" + Zahl;
		int len = str.length();
		for (int i = 0; i <= len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int Grosste = 0;
		for (int i = 100; i <= 999; i++) {
			for (int j = 100; j <= 999; j++) {
				int Ergebnis = i * j;
				if (Palindrome(Ergebnis) && Ergebnis > Grosste) {
					Grosste = Ergebnis;
				}
			}
		}
		System.out.println("Ausgabe: " + Grosste);
		
		/*
		 * Problem solved
		 * 515052nd person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
