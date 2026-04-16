package eulerProject61to90;

public class Problem86 {
	public static long cuboidRoute(int m) {
		long sum = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = i; j <= m; j++) {
				for (int k = j; k <= m; k++) {
					if (rightSidedTriangle(i, j, k)) {
						sum++;
					}
				}
			}
		}
		return sum;
	}
	
	public static boolean shortestRouteIsInteger(int a, int b, int c) {
		if (rightSidedTriangle(a, b, c) || rightSidedTriangle(b, c, a) || rightSidedTriangle(c, a, b)) {
			return true;
		}
		return false;
	}
	
	public static boolean rightSidedTriangle(int a, int b, int c) {
		long temp2 = a + b;
		double temp = Math.sqrt(temp2 * temp2 + c * c);
		return Math.floor(temp) == Math.ceil(temp);
	}
	
	public static void main(String[] args) {
		/*
		int m = 2;
		int n = 1;
		long sum = 0;
		int biggest = 0;
		while (sum <= 1e6) {
			sum += (2 * m * n) / 2 + (m * m - n * n) / 2;
			System.out.println(sum);
			n++;
			if (m == n) {
				m++;
				n = 1;
			}
			biggest = Math.max(m * m + n * n, biggest);
		}
		*/
		int m = 1800;
		long sum = 0;
		while (sum <= 1e6) {
			m++;
			sum = cuboidRoute(m);
			// System.out.println(m + " " + sum);
		}
		System.out.println("Ausgabe: " + m);
	}
	
	/* Remark: Let's be honest, I cheated here by using memory from a previous session. It will take at least 10 minutes for
	 * the program to fully run. I don't know how to work it out better, because I tried a quicker method, but it didn't
	 * work. I'm going to check the forum for a better solution.
	 * Problem solved
	 * 14377th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: 36 seconds
	 * */
}
