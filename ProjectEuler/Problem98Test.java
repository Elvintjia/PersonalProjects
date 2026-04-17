package eulerProject91to120;

import java.util.ArrayList;

public class Problem98Test {
	public static void main(String[] args) {
		String[] temp = {"RACE", "CARE"};
		ArrayList<Long> temp2 = new ArrayList<>();
		temp2.add(1089l);
		temp2.add(1369l);
		temp2.add(9216l);
		temp2.add(9409l);
		System.out.println(Problem98.anagramicSquares(temp2, temp));
	}
}
