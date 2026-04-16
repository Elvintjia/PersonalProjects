package eulerProject1To30;

public class Problem19 {
	public static void main(String[] args) {
		int year = 1901;
		int month = 9;
		int dayInAMonth = 30;
		int day = 1;
		long counter = 0;
		while (year <= 2000) {
			if (day == 1) {
				counter++;
			}
			day += 7;
			if (day > dayInAMonth) {
				day -= dayInAMonth;
				if (month == 1) {
					if (year % 400 == 0) {
						dayInAMonth = 29;
					} else if (year % 100 == 0) {
						dayInAMonth = 28;
					} else if (year % 4 == 0) {
						dayInAMonth = 29;
					} else {
						dayInAMonth = 28;
					}
				} else if (month == 3 || month == 5 || month == 8 || month == 10) {
					dayInAMonth = 30;
				} else {
					dayInAMonth = 31;
				}
				month++;
				if (month > 12) {
					month -= 12;
					year++;
				}
			}
		}
		System.out.println("Ausgabe: " + counter);
		
		/*
		 * Problem solved
		 * 144606th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
