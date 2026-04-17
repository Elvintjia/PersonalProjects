package eulerProject91to120;

import java.io.*;

public class Problem99 {
	public static double largestExponential(String line) {
		int index = line.indexOf(',');
		double log = Math.log(Long.valueOf(line.substring(0, index)));
		long integer = Integer.valueOf(line.substring(index + 1));
		// System.out.println(log);
		// System.out.println(integer);
		return log * integer;
	}
	
	public static void main(String[] args) {
		int biggestLine = 0;
		double biggest = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("0099_base_exp.txt")))) {
			String line = br.readLine();
			for (int i = 1; line != null; i++) {
				double temp = largestExponential(line);
				if (temp > biggest) {
					biggest = temp;
					biggestLine = i;
				}
				line = br.readLine();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		// 6919869.733217769
		System.out.println("Ausgabe: " + biggestLine);
	}
	
	/*
	 * Problem solved
	 * 33949th person to have solved this problem
	 * Difficulty rating: 10%
	 * Runtime: Less than 1 second
	 * */
}
