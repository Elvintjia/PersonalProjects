package eulerProject91to120;

public class Problem91 {
	public static boolean isRightTriangle(int[] firstPoint, int[] secondPoint) {
		int[] sides = triangleSides(firstPoint, secondPoint);
		int biggest = 0;
		int biggestIndex = 0;
		for (int i = 0; i < sides.length; i++) {
			// System.out.println(sides[i]);
			if (sides[i] > biggest) {
				biggest = sides[i];
				biggestIndex = i;
			}
		}
		int sum = 0;
		for (int i = 0; i < sides.length; i++) {
			if (i != biggestIndex) {
				sum += sides[i];
			}
		}
		// System.out.println(biggest);
		// System.out.println(sum);
		return (sum == biggest);
	}
	
	public static int[] triangleSides(int[] firstPoint, int[] secondPoint) {
		int[] toReturn = new int[3]; 
		toReturn[0] = distanceToCoordinateZero(firstPoint);
		toReturn[1] = distanceToCoordinateZero(secondPoint);
		int a = firstPoint[0] - secondPoint[0];
		int b = firstPoint[1] - secondPoint[1];
		toReturn[2] = a * a + b * b;
		return toReturn;
	}
	
	public static int distanceToCoordinateZero(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
	
	public static void main(String[] args) {
		int n = 50;
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k <= n; k++) {
					for (int l = 0; l <= n; l++) {
						if (((i == 0) && (j == 0)) || ((k == 0) && (l == 0)) || ((i == k) && (l <= j) || (k < i))) {
							continue;
						}
						int[] a = {i, j};
						int[] b = {k, l};
						if (isRightTriangle(a, b)) {
							// System.out.println(i + " " + j + " " + k + " " + l);
							sum++;
						}
					}
				}
			}
		}
		System.out.println("Ausgabe: " + sum);
	}
	
	/*
	 * Problem solved
	 * 17419th person to have solved this problem
	 * Difficulty rating: 25%
	 * Runtime: 2 seconds
	 * */
}
