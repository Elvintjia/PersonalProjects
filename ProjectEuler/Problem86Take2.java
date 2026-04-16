package eulerProject61to90;

public class Problem86Take2 {
	public static void main(String[] args) {
		int m = 1;
		long count = 0;
		while (count <= 1e6) {
			m++;
			for (int i = 1; i <= m; i++) {
				for (int j = i; j <= m; j++) {
					int k = i + j;
					double temp = Math.sqrt(k * k + m * m);
					if (Math.ceil(temp) == Math.floor(temp)) {
						count++;
					}
				}
			}
		}
		System.out.println("Ausgabe: " + m);
	}
	
	/* Remark: Oh for fuck's sake. I just made this program based on what I could understand from the forum, and it works
	 * very well, in fact, rather quick too. It's a shame I didn't think of it.
	 **/
}
