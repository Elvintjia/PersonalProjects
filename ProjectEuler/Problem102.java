package eulerProject91to120;

import java.io.*;

public class Problem102 {
	public static boolean triangleContainment(int[] a, int[] b, int[] c) {
		double area = ((double) (b[1] - c[1]) * (a[0] - c[0]) + (c[0] - b[0]) * (a[1] - c[1]));
		double vecA = ((double) (b[1] - c[1]) * (- c[0]) + (c[0] - b[0]) * (- c[1])) / area;
		double vecB = ((double) (c[1] - a[1]) * (- c[0]) + (a[0] - c[0]) * (- c[1])) / area;
		double vecC = 1 - vecA - vecB;
		return (vecA >= 0 && vecB >= 0 && vecC >= 0);
	}
	
	public static void main(String[] args) {
		int count = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("0102_triangles.txt")))) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				int[] temp = new int[2];
				int[] temp2 = new int[2];
				int[] temp3 = new int[2];
				temp[0] = Integer.valueOf(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(',') + 1);
				temp[1] = Integer.valueOf(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(',') + 1);
				temp2[0] = Integer.valueOf(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(',') + 1);
				temp2[1] = Integer.valueOf(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(',') + 1);
				temp3[0] = Integer.valueOf(line.substring(0, line.indexOf(',')));
				line = line.substring(line.indexOf(',') + 1);
				temp3[1] = Integer.valueOf(line);
				if (triangleContainment(temp, temp2, temp3)) {
					count++;
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/* Remark: I basically copied the algorithm that's specifically made to solve this problem, but the algorithm itself
	 * wasn't written because this problem exists, so I consider what I do fair play.
	 * Problem solved
	 * 24380th person to have solved this problem
	 * Difficulty rating: 15%
	 * Runtime: 1 second
	 * */
}
