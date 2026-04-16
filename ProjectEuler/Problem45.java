package eulerProject31To60;

public class Problem45 {
	public static long triangleNumber(long n) {
		return n * (n + 1) / 2;
	}
	
	public static long pentagonalNumber(long n) {
		return n * (3 * n - 1) / 2;
	}
	
	public static long hexagonalNumber(long n) {
		return n * (2 * n - 1);
	}
	
	public static void main(String[] args) {
		long t = 285;
		long p = 165;
		long h = 144;
		long ti = triangleNumber(t);
		long pi = pentagonalNumber(p);
		long hi = hexagonalNumber(h);
		while (ti != pi || pi != hi) {
			if (ti < pi && ti < hi) {
				t++;
				ti = triangleNumber(t);
			} else if (pi < hi) {
				p++;
				pi = pentagonalNumber(p);
			} else {
				h++;
				hi = hexagonalNumber(h);
			}
		}
		System.out.println("Ausgabe: " + ti);
	}
	
	/*
	 * Problem solved
	 * 76950th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
