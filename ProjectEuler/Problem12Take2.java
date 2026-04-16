package eulerProject1To30;

public class Problem12Take2 {
	public static int checkDivisor(long num) {
		long numDupe = num;
		int counter = 0;
		for (int i = 2; num != 1; i++) {
			if (counter == 500) {
				return 501;
			} else {
				while (num % i == 0) {
					num /= i;
					counter++;
				}
			}
		}
		if (counter > 7) {
			counter = 0;
			for (int i = 1; i <= numDupe / 2; i++) {
				if (numDupe % i == 0) {
					counter++;
				}
				/* if (numDupe / 16 < i && counter <= 63) {
					return 0;
				} else */ if (numDupe / 4 < i && counter <= 480) {
					return 0; 
				}
			}
			System.out.println(numDupe);
			System.out.println(counter);
			return counter + 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		long sum = 0;
		for (long i = 1; true; i++) {
			sum += i;
			/* if (sum < 500) {
				continue;
			} */
			if (checkDivisor(sum) > 500) {
				System.out.println("Ausgabe: " + sum);
				break;
			}
			
		}
	}
}
