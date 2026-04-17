package eulerProject91to120;

public class Problem96Test {
	public static void main(String[] args) {
		int[][] grid = new int[9][9];
		grid[1][2] = 5;
		grid[1][3] = 5;
		grid[1][4] = 6;
		System.out.println(Problem96.check(grid, 1, 4));
		System.out.println(Problem96.checkUp(grid, 1, 4));
	}
}
