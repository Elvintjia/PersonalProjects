package eulerProject61to90;

public class Problem79Take2 {
	public static boolean validityCheck(long passcode, long reply) {
		String passcodeString = passcode + "";
		String replyString = reply + "";
		for (int i = 0; i < replyString.length(); i++) {
			String checkedChar = replyString.charAt(i) + "";
			if (!passcodeString.contains(checkedChar)) {
				return false;
			}
			passcodeString = passcodeString.substring(passcodeString.indexOf(checkedChar) + 1);
		}
		return true;
	}
	
	public static void main(String[] args) {
		long[] array = {319, 680, 180, 690, 129, 620, 762, 689, 762, 318, 368, 710, 720, 710, 629, 168, 160, 689, 716, 731,
				736, 729, 316, 729, 729, 710, 769, 290, 719, 680, 318, 389, 162, 289, 162, 718, 729, 319, 790, 680, 890,
				362, 319, 760, 316, 729, 380, 319, 728, 716};
		long n = 0;
		while (true) {
			boolean codeFound = true;
			for (int i = 0; i < array.length; i++) {
				if (!validityCheck(n, array[i])) {
					codeFound = false;
					break;
				}
			}
			if (codeFound) {
				break;
			}
			n++;
		}
		System.out.println("Ausgabe: " + n);
	}
}
