package eulerProject1To30;

public class Problem30 {
	public static long powerOfFive(int x) {
		return x * x * x * x * x;
	}
	
	public static long sumOfFifthPowersOfTheirDigits(long input) {
		long sum = 0;
		String inputToString = input + "";
		for (int i = 0; i < inputToString.length(); i++) {
			sum += powerOfFive(Integer.valueOf("" + inputToString.charAt(i)));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		long sum = 0;
		for (long i = 2; i <= 354294; i++) {
			long sumOfDigitPowers = sumOfFifthPowersOfTheirDigits(i);
			if (i == sumOfDigitPowers) {
				sum += i;
			}
		}
		System.out.println("Ausgabe: " + sum);
		
		/*
		 * Problem solved
		 * 118402nd person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
