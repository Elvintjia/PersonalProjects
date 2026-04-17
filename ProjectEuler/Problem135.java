package eulerProject121to150;

public class Problem135 {
	public static int sameDifferences(int n) {
		int[] map = new int[n];
		for (int i = 1; i < n; i++) {
			for (int j = i / 4 + 1; j < i; j++) {
				int temp = i * (4 * j - i);
				if (temp >= n) {
					break;
				} else {
					map[temp]++;
				}
			}
		}
		int toReturn = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[i] == 10) {
				toReturn++;
			}
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + sameDifferences(1000000));
		// sameDifference(100) with value == 2 is 8
	}
	
	/* Remark: I thought my solution was efficient, but then I found out it took time and the result isn't accurate. I
	 * then tried an algorithm by a random person in the internet. The result? Fast and accurate. I sometimes wonder
	 * how people even figure out the solution to these problems.
	 * Problem solved
	 * 7430th person to have solved this problem
	 * Problem level: 13
	 * Runtime: Less than 1 second
	 * */
}
