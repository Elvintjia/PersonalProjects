package eulerProject61to90;

public class Problem74 {
	public static long factorial(long input) {
		long sum = 1;
		for (int i = 1; i <= input; i++) {
			sum *= i;
		}
		return sum;
	}
	
	public static long factorialLoop(long input) {
		String taken = " ";
		long count = 1;
		taken += input + " ";
		while (true) {
			long temp = 0;
			String inputString = input + "";
			for (int i = 0; i < inputString.length(); i++) {
				temp += factorial(Long.valueOf(inputString.charAt(i) + ""));
			}
			if (taken.contains(" " + temp + " ")) {
				return count;
			}
			count++;
			taken += temp + " ";
			input = temp;
		}
	}
	
	public static void main(String[] args) {
		long count = 0;
		for (int i = 1; i < 1e6; i++) {
			// System.out.println(i);
			if (factorialLoop(i) == 60) {
				count++;
			}
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/*
	 * Problem solved
	 * 29609th person to have solved this problem
	 * Difficulty rating: 15%
	 * */
}
