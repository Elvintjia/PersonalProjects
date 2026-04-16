package eulerProject61to90;

public class Problem68 {
	static long highest = 0;
	
	public static String set(long[] array, long num) {
		return "" + array[(int) num] + array[(int) num + 5] + array[(num == 4 ? 5 : (int) num + 6)];
	}
	
	public static void insertNumber(long[] array, long input) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == input) {
				return;
			} else if (array[i] == 0) {
				array[i] = input;
				break;
			}
		}
		/*
		String toPrint = "";
		for (int j = 0; j < array.length; j++) {
			toPrint += array[j] + " ";
		}
		System.out.println(toPrint);
		*/
		if (array[9] == 0) {
			for (int i = 1; i <= 10; i++) {
				insertNumber(array.clone(), i);
				/*
				String toPrint = "";
				for (int j = 0; j < array.length; j++) {
					toPrint += array[j] + " ";
				}
				System.out.println(toPrint);
				*/
			}
		} else {
			for (int i = 5; i <= 9; i++) {
				if (array[i] == 10) {
					return;
				}
			}
			long sum = array[0] + array[5] + array[6];
			for (int i = 1; i <= 4; i++) {
				if (i == 4) {
					if (sum != array[4] + array[5] + array[9]) {
						return;
					}
				} else {
					if (sum != array[i] + array[i + 5] + array[i + 6]) {
						return;
					}
				}
			}
			sum = 0;
			for (int i = 0; i <= 4; i++) {
				if (array[(int) sum] > array[i]) {
					sum = i;
				}
			}
			String result = "";
			for (int i = (int) sum; i <= 4; i++) {
				result += set(array, i);
			}
			for (int i = 0; i < sum; i++) {
				result += set(array, i);
			}
			long longResult = Long.valueOf(result);
			if (longResult > highest) {
				highest = longResult;
			}
		}
	}
	
	public static void main(String[] args) {
		long[] array = new long[10];
		for (int i = 1; i <= 10; i++) {
			// System.out.println(i);
			insertNumber(array.clone(), i);
			// i = 10;
		}
		System.out.println("Ausgabe: " + highest);
	}
	
	/* Remark: It turns out I needed to make clones of the arrays instead of simply inserting them. That was why my code had
	 * flaws. It otherwise works well. Efficiently too, if I may add.
	 * Problem solved
	 * 23183rd person to have solved this problem
	 * Difficulty rating: 25%
	 * */
}
