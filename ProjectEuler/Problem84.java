package eulerProject61to90;

public class Problem84 {
	public static int rollDie() {
		return (int) (Math.random() * 4) + 1;
	}
	
	public static void main(String[] args) {
		int position = 0;
		int doubleDieCounter = 0;
		long[] board = new long[40];
		for (long i = 0; i < 1e7; i++) {
			int a = rollDie();
			int b = rollDie();
			boolean goToJail = false;
			// System.out.println(a + " " + b);
			if (a == b) {
				if (doubleDieCounter == 2) {
					position = 10;
					doubleDieCounter = 0;
					goToJail = true;
				} else {
					doubleDieCounter++;
				}
			} else {
				doubleDieCounter = 0;
			}
			if (!goToJail) {
				position += a + b;
				if (position >= 40) {
					position -= 40;
				}
				if (position == 30) {
					position = 10;
				} else if (position == 2 || position == 17 || position == 33) {
					int rolled = (int) (Math.random() * 16) + 1;
					if (rolled == 1) {
						position = 0;
					} else if (rolled == 2) {
						position = 10;
					}
				} else if (position == 7 || position == 22 || position == 36) {
					int rolled = (int) (Math.random() * 16) + 1;
					if (rolled == 1) {
						position = 0;
					} else if (rolled == 2) {
						position = 10;
					} else if (rolled == 3) {
						position = 11;
					} else if (rolled == 4) {
						position = 24;
					} else if (rolled == 5) {
						position = 39;
					} else if (rolled == 6) {
						position = 5;
					} else if (rolled == 7 || rolled == 8) {
						if (position < 5 || position > 35) {
							position = 5;
						} else if (position < 15 && position > 5) {
							position = 15;
						} else if (position < 25 && position > 15) {
							position = 25;
						} else {
							position = 35;
						}
					} else if (position == 9) {
						if (position < 12 || position > 28) {
							position = 12;
						} else {
							position = 28;
						}
					} else if (position == 10) {
						position -= 3;
					}
				}
			}
			board[position]++;
			// System.out.println(position + "\n");
		}
		int[] biggest = new int[3];
		long[] biggestValues = new long[3];
		for (int i = 0; i < 40; i++) {
			if (board[i] > biggestValues[0]) {
				biggest[2] = biggest[1];
				biggest[1] = biggest[0];
				biggest[0] = i;
				biggestValues[2] = biggestValues[1];
				biggestValues[1] = biggestValues[0];
				biggestValues[0] = board[i];
			} else if (board[i] > biggestValues[1]) {
				biggest[2] = biggest[1];
				biggest[1] = i;
				biggestValues[2] = biggestValues[1];
				biggestValues[1] = board[i];
			} else if (board[i] > biggestValues[2]) {
				biggest[2] = i;
				biggestValues[2] = board[i];
			}
		}
		String output = "";
		for (int i = 0; i < biggest.length; i++) {
			if (biggest[i] < 10) {
				output += 0;
			}
			output += biggest[i];
		}
		/*
		for (int i = 0; i < board.length; i++) {
			System.out.println(i + " " + board[i]);
		}
		*/
		System.out.println("Ausgabe: " + output);
	}
	/* Remark: I couldn't figure out what the proper algorithm to solve this problem is, so I had to look it up in Google
	 * for tips. As it turns out, running a simulation where the player starts at GO is the correct answer. I wrote my
	 * program to simulate a singleplayer game for 10 million dice rolls. Worked well enough. A few bugs I had to solve,
	 * of course.
	 * Problem solved
	 * 14299th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: 1 second
	 * */
}
