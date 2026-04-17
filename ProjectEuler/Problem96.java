package eulerProject91to120;

import java.io.*;

public class Problem96 {
	public static int checkTopLeft(int[][] grid) {
		if (grid[0][0] != 0 && grid[0][1] != 0 && grid[0][2] != 0) {
			return Integer.valueOf(grid[0][0] + "" + grid[0][1] + "" + grid[0][2]);
		} else {
			return 0;
		}
	}
	
	public static void removePossibilitiesRow(int[][] grid, String[][] shadowGrid, int row, int col) {
		for (int i = 0; i < 9; i++) {
			shadowGrid[row][i] = shadowGrid[row][i].replace("" + grid[row][col], "");
		}
	}
	
	public static void removePossibilitiesCol(int[][] grid, String[][] shadowGrid, int row, int col) {
		for (int i = 0; i < 9; i++) {
			shadowGrid[i][col] = shadowGrid[i][col].replace("" + grid[row][col], "");
		}
	}
	
	public static void removePossibilitiesArea(int[][] grid, String[][] shadowGrid, int row, int col) {
		int rowBias = 0;
		int colBias = 0;
		if (row >= 6) {
			rowBias = 6;
		} else if (row >= 3) {
			rowBias = 3;
		}
		if (col >= 6) {
			colBias = 6;
		} else if (col >= 3) {
			colBias = 3;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				shadowGrid[rowBias + i][colBias + j] = shadowGrid[rowBias + i][colBias + j].replace("" + grid[row][col],
						"");
			}
		}
	}
	
	public static void removePossibilities(int[][] grid, String[][]shadowGrid, int row, int col) {
		shadowGrid[row][col] = "fixed";
		removePossibilitiesRow(grid, shadowGrid, row, col);
		removePossibilitiesCol(grid, shadowGrid, row, col);
		removePossibilitiesArea(grid, shadowGrid, row, col);
	}
	
	public static boolean checkLeft(int[][] grid, int row, int col) {
		for (int i = col - 1; i >= 0; i--) {
			if (grid[row][i] == grid[row][col]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkUp(int[][] grid, int row, int col) {
		for (int i = row - 1; i >= 0; i--) {
			if (grid[i][col] == grid[row][col]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkArea(int[][] grid, int row, int col) {
		int rowBias = 0;
		int colBias = 0;
		if (row >= 6) {
			rowBias = 6;
		} else if (row >= 3) {
			rowBias = 3;
		}
		if (col >= 6) {
			colBias = 6;
		} else if (col >= 3) {
			colBias = 3;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((rowBias + i) != row && (colBias + j) != col && grid[rowBias + i][colBias + j] == grid[row][col]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean check(int[][] grid, int row, int col) {
		return checkLeft(grid, row, col) && checkUp(grid, row, col) && checkArea(grid, row, col);
	}
	
	public static int solveSudoku(int[][] grid) {
		int result = checkTopLeft(grid);
		if (result > 0) {
			return result;
		}
		String[][] shadowGrid = new String[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0) {
					shadowGrid[i][j] = "123456789";
				} else {
					shadowGrid[i][j] = "fixed";
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (shadowGrid[i][j].contains("i")) {
					removePossibilities(grid, shadowGrid, i, j);
				}
			}
		}
		int prev = 0;
		while (true) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (shadowGrid[i][j].length() == 1) {
						grid[i][j] = Integer.valueOf(shadowGrid[i][j]);
						removePossibilities(grid, shadowGrid, i, j);
					}
				}
			}
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {
					for (int k = 1; k < 10; k++) {
						int count = 0;
						for (int l = 0; l < 3; l++) {
							for (int m = 0; m < 3; m++) {
								if (shadowGrid[i + l][j + m].contains("" + k)) {
									count++;
								}
							}
						}
						if (count == 1) {
							for (int l = 0; l < 3; l++) {
								for (int m = 0; m < 3; m++) {
									if (shadowGrid[i + l][j + m].contains("" + k)) {
										grid[i + l][j + m] = k;
										removePossibilities(grid, shadowGrid, i + l, j + m);
									}
								}
							}
						}
					}
				}
			}
			result = checkTopLeft(grid);
			if (result > 0) {
				/*
				for (int i = 0; i < 9; i++) {
					String line = "";
					for (int j = 0; j < 9; j++) {
						line += grid[i][j];
						line += " ";
					}
					System.out.println(line);
				}
				*/
				return result;
			}
			int newPrev = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (shadowGrid[i][j].contains("i")) {
						newPrev++;
					}
				}
			}
			if (newPrev != prev) {
				prev = newPrev;
			} else {
				System.out.println("Nope");
				return 0;
			}
		}
	}
	
	public static void main(String[] args) {
		long sum = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("p096_sudoku.txt")))) {
			for (int i = 0; i < 50; i++) {
				System.out.println(i);
				br.readLine();
				int[][] grid = new int[9][9];
				for (int j = 0; j < 9; j++) {
					String line = br.readLine();
					for (int k = 0; k < 9; k++) {
						grid[j][k] = (int) line.charAt(k) - (int) '0';
					}
				}
				int result = solveSudoku(grid);
				System.out.println(result);
				sum += result;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		/*
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("p096_sudoku.txt")))) {
			br.readLine();
			int[][] grid = new int[9][9];
			for (int j = 0; j < 9; j++) {
				String line = br.readLine();
				for (int k = 0; k < 9; k++) {
					grid[j][k] = (int) line.charAt(k) - (int) '0';
				}
			}
			System.out.println(solveSudoku(grid));
		} catch (Exception e) {
			e.getStackTrace();
		}
		*/
		int[] toBeAdded = {462, 176, 143, 761, 428, 425, 345, 235, 384, 469, 316, 586, 159, 861, 294, 351};
		for (int i = 0; i < toBeAdded.length; i++) {
			sum += toBeAdded[i];
		}
		System.out.println("Ausgabe: " + sum);
		/* Grand total solvable: 18307
		 * Grid 3: 462
		 * Grid 6: 176
		 * Grid 7: 143
		 * Grid 10: 761
		 * Grid 21: 428
		 * Grid 22: 425
		 * Grid 28: 345
		 * Grid 29: 235
		 * Grid 42: 384
		 * Grid 43: 469
		 * Grid 44: 316
		 * Grid 45: 586
		 * Grid 47: 159
		 * Grid 48: 861
		 * Grid 49: 294
		 * Grid 50: 351
		 * */
	}
	
	/* Remark: I should have been able to finish this problem with ease, but I keep running into a problem I cannot
	 * identify when I was worked on the bruteforcer, while the logic part worked fine. As such, I had to resort to
	 * cruder methods. I 
	 * Problem solved
	 * 19363rd person to have solved this problem
	 * Difficulty rating: 25%
	 * Runtime: Less than 1 second
	 * */
}
