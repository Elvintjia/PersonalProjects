package eulerProject1To30;

public class Problem18 {
	public static long path(String[] triangle) {
		for (int i = 1; i < triangle.length; i++) {
			String replacement = "";
			int index = triangle.length - i - 1;
			while (triangle[index].contains(" ")) {
				int indexFirstSpace = triangle[index].indexOf(' ');
				int firstSpace = triangle[index + 1].indexOf(' ');
				int secondSpace = firstSpace + triangle[index + 1].substring(firstSpace + 1).indexOf(' ') + 1;
				long baseSum = Long.valueOf(triangle[index].substring(0, indexFirstSpace));
				long firstPath = Long.valueOf(triangle[index + 1].substring(0, firstSpace));
				long secondPath = Long.valueOf(triangle[index + 1].substring(firstSpace + 1, secondSpace));
				replacement += (baseSum + Math.max(firstPath, secondPath)) + " ";
				triangle[index + 1] = triangle[index + 1].substring(firstSpace + 1);
				triangle[index] = triangle[index].substring(indexFirstSpace + 1);
			}
			triangle[index] = replacement;
		}
		return Long.parseLong(triangle[0].trim());
	}
	
	public static void main(String[] args) {
		String[] triangle = new String[15];
		triangle[0] = "75 ";
		triangle[1] = "95 64 ";
		triangle[2] = "17 47 82 ";
		triangle[3] = "18 35 87 10 ";
		triangle[4] = "20 04 82 47 65 ";
		triangle[5] = "19 01 23 75 03 34 ";
		triangle[6] = "88 02 77 73 07 63 67 ";
		triangle[7] = "99 65 04 28 06 16 70 92 ";
		triangle[8] = "41 41 26 56 83 40 80 70 33 ";
		triangle[9] = "41 48 72 33 47 32 37 16 94 29 ";
		triangle[10] = "53 71 44 65 25 43 91 52 97 51 14 ";
		triangle[11] = "70 11 33 28 77 73 17 78 39 68 17 57 ";
		triangle[12] = "91 71 52 38 17 14 91 43 58 50 27 29 48 ";
		triangle[13] = "63 66 04 68 89 53 67 30 73 16 69 87 40 31 ";
		triangle[14] = "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 ";
		
		System.out.println("Ausgabe: " + path(triangle));
		
		/*
		 * Problem solved
		 * 155752nd person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
