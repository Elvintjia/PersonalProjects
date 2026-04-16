package eulerProject1To30;

public class Problem3 {
	public static void main(String[] args) {
		double Num = 600851475143.0;
		double Max = 0;
		for (double i = 1; i * i <= Num; i++) {
			if (Num % i == 0) {
				boolean check = true;
				for (double j = 2; j * j < i; j++) {
					if (i % j == 0) {
						check = false;
					}
				}
				if (check) {
					Max = i;
				}
			}
		}
		System.out.println("Ausgabe: " + Max);
		
		/*
		 * Problem solved
		 * 582678th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
