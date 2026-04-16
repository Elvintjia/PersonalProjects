package eulerProject31To60;

public class Problem31 {
	public static long calc(long remain, int biggest) {
		return coinSums(remain - biggest, biggest);
	}
	
	public static long coinSums(long remain, int biggest) {
		if (remain == 0) {
			return 1;
		} else if (remain < 0) {
			return 0;
		} else {
			if (biggest == 200) {
				return calc(remain, biggest) + calc(remain, 100) + calc(remain, 50) + calc(remain, 20)
				+ calc(remain, 10) + calc(remain, 5) + calc(remain, 2) + calc(remain, 1);
			} else if (biggest == 100) {
				return calc(remain, biggest) + calc(remain, 50) + calc(remain, 20) + calc(remain, 10)
				+ calc(remain, 5) + calc(remain, 2) + calc(remain, 1);
			} else if (biggest == 50) {
				return calc(remain, biggest) + calc(remain, 20) + calc(remain, 10) + calc(remain, 5)
				+ calc(remain, 2) + calc(remain, 1);
			} else if (biggest == 20) {
				return calc(remain, biggest) + calc(remain, 10) + calc(remain, 5) + calc(remain, 2)
				+ calc(remain, 1);
			} else if (biggest == 10) {
				return calc(remain, biggest) + calc(remain, 5) + calc(remain, 2) + calc(remain, 1);
			} else if (biggest == 5) {
				return calc(remain, biggest) + calc(remain, 2) + calc(remain, 1);
			} else if (biggest == 2) {
				return calc(remain, biggest) + calc(remain, 1);
			} else {
				return calc(remain, biggest);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + coinSums(200, 200));
	}
	
	/*
	 * Problem solved
	 * 92398th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
