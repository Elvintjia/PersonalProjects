package eulerProject121to150;

public class Problem136 {
	public static int singletonDifference(int n) {
		int[] map = new int[n];
		for (int i = 1; i < n; i++) {
			for (int j = i / 4 + 1; j < i; j++) {
				int temp = i * (4 * j - i);
				if (temp >= n) {
					break;
				} else if (temp > 0) {
					map[temp]++;
				}
			}
		}
		int toReturn = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[i] == 1) {
				toReturn++;
			}
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + singletonDifference(50000000));
	}
	
	/*
	 * Problem solved
	 * 6640th person to have solved this problem
	 * Difficulty level: 14
	 * Runtime: 2 seconds
	 * */
}
