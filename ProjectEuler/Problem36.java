package eulerProject31To60;

import java.math.BigInteger;

public class Problem36 {
	public static boolean isPalindrome(long eingabe) {
		String stringEingabe = "" + eingabe;
		while (stringEingabe.length() > 1) {
			if (!(stringEingabe.charAt(0) == stringEingabe.charAt(stringEingabe.length() - 1))) {
				return false;
			}
			stringEingabe = stringEingabe.substring(1, stringEingabe.length() - 1);
		}
		return true;
	}
	
	public static boolean isPalindrome(BigInteger eingabe) {
		String stringEingabe = "" + eingabe;
		while (stringEingabe.length() > 1) {
			if (!(stringEingabe.charAt(0) == stringEingabe.charAt(stringEingabe.length() - 1))) {
				return false;
			}
			stringEingabe = stringEingabe.substring(1, stringEingabe.length() - 1);
		}
		return true;
	}
	
	public static BigInteger toBinary(long eingabe) {
		long counter = 1;
		while (eingabe >= counter) {
			counter *= 2;
		}
		counter /= 2;
		String returnString = "";
		for (; counter > 0; counter /= 2) {
			if (counter <= eingabe) {
				eingabe -= counter;
				returnString += "1";
			} else {
				returnString += "0";
			}
		}
		return new BigInteger(returnString);
	}
	
	public static void main(String[] args) {
		long sum = 0;
		for (long i = 1; i < 1e6; i++) {
			if (isPalindrome(i) && isPalindrome(toBinary(i))) {
				sum += i;
			}
		}
		System.out.println("Ausgabe: " + sum);
		
		/*
		 * Problem solved
		 * 95979th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
