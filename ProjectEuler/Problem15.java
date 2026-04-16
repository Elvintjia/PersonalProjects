package eulerProject1To30;

public class Problem15 {
	public static long latticePaths(int i, int j) {
		i++; j++;
		long[][] grid = new long[i][];
		for (int k = 0; k <= i - 1; k++) {
			grid[k] = new long[j];
		}
		for (int k = 0; k <= j - 1; k++) {
			grid[0][k] = 1;
		}
		for (int k = 0; k <= i - 1; k++) {
			grid[k][0] = 1;
		}
		for (int k = 1; k <= i - 1; k++) {
			for (int l = 1 ; l <= j - 1; l++) {
				grid[k][l] = grid[k - 1][l] + grid[k][l - 1];
			}
		}
		return grid[i - 1][j - 1];
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + latticePaths(20, 20));
		
		/* Comment: Solved with a little bit of help from YouTube, needed an efficient algorithm.
		 * Problem solved
		 * 200183rd person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
