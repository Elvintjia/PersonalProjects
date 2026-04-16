package eulerProject61to90;

import java.util.ArrayList;

public class Problem90 {
	ArrayList<Integer> cubeOne;
	ArrayList<Integer> cubeTwo;
	Problem90 next;
	Problem90 prev;
	
	public Problem90(ArrayList<Integer> cubeOne, ArrayList<Integer> cubeTwo) {
		this.cubeOne = cubeOne;
		this.cubeTwo = cubeTwo;
	}
	
	public static boolean canFormSquare(ArrayList<Integer> a, ArrayList<Integer> b, int c, int d) {
		return ((a.contains(c) && b.contains(d)) || (a.contains(d) && b.contains(c)));
	}
	
	public static boolean check(ArrayList<Integer> a, ArrayList<Integer> b) {
		int[] arrayOne = {0, 0, 0, 1, 2, 3, 4, 6, 8};
		int[] arrayTwo = {1, 4, 9, 6, 5, 6, 9, 4, 1};
		for (int i = 0; i < arrayOne.length; i++) {
			if (!canFormSquare(a, b, arrayOne[i], arrayTwo[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean distinctCubes(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a.size() != b.size()) {
			return false;
		}
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) != b.get(i)) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Integer> sixOrNine(ArrayList<Integer> a) {
		boolean containsSix = a.contains(6);
		boolean containsNine = a.contains(9);
		ArrayList<Integer> b = (ArrayList<Integer>) a.clone();
		if (containsSix && (!containsNine)) {
			b.add(9);
		} else if ((!containsSix) && containsNine) {
			b.add(6);
			b.sort(null);
		}
		return b;
	}
	
	public static boolean biggerThan(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a.size() > b.size()) {
			return true;
		}
		for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
			if (a.get(i) > b.get(i)) {
				return true;
			} else if (a.get(i) < b.get(i)) {
				return false;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Problem90 start = null;
		long count = 0;
		for (int i = 0 ; i <= 9; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(i);
			for (int j = i + 1; j <= 9; j++) {
				ArrayList<Integer> temp2 = (ArrayList<Integer>) temp.clone();
				temp2.add(j);
				for (int k = j + 1; k <= 9; k++) {
					ArrayList<Integer> temp3 = (ArrayList<Integer>) temp2.clone();
					temp3.add(k);
					for (int l = k + 1; l <= 9; l++) {
						ArrayList<Integer> temp4 = (ArrayList<Integer>) temp3.clone();
						temp4.add(l);
						for (int m = l + 1; m <= 9; m++) {
							ArrayList<Integer> temp5 = (ArrayList<Integer>) temp4.clone();
							temp5.add(m);
							for (int n = m + 1; n <= 9; n++) {
								ArrayList<Integer> temp6 = (ArrayList<Integer>) temp5.clone();
								temp6.add(n);
								for (int o = 0; o <= 9; o++) {
									ArrayList<Integer> temp7 = new ArrayList<Integer>();
									temp7.add(o);
									for (int p = o + 1; p <= 9; p++) {
										ArrayList<Integer> temp8 = (ArrayList<Integer>) temp7.clone();
										temp8.add(p);
										for (int q = p + 1; q <= 9; q++) {
											ArrayList<Integer> temp9 = (ArrayList<Integer>) temp8.clone();
											temp9.add(q);
											for (int r = q + 1; r <= 9; r++) {
												ArrayList<Integer> temp10 = (ArrayList<Integer>) temp9.clone();
												temp10.add(r);
												for (int s = r + 1; s <= 9; s++) {
													ArrayList<Integer> temp11 = (ArrayList<Integer>) temp10.clone();
													temp11.add(s);
													for (int t = s + 1; t <= 9; t++) {
														ArrayList<Integer> temp12 = (ArrayList<Integer>) temp11.clone();
														temp12.add(t);
														if (distinctCubes(temp6, temp12)) {
															if (check(sixOrNine(temp6), sixOrNine(temp12))) {
																ArrayList<Integer> bigger = temp6;
																ArrayList<Integer> smaller = temp12;
																if (!biggerThan(bigger, smaller)) {
																	bigger = temp12;
																	smaller = temp6;
																}
																Problem90 toBeAdded = new Problem90(smaller, bigger);
																if (start == null) {
																	start = toBeAdded;
																	count++;
																} else {
																	Problem90 current = start;
																	while (true) {
																		boolean firstCubeSame =
																				!distinctCubes(toBeAdded.cubeOne,
																						current.cubeOne);
																		if (firstCubeSame &&
																				(!distinctCubes(toBeAdded.cubeTwo,
																						current.cubeTwo))) {
																			break;
																		} else {
																			boolean biggerThanCurrent = false;
																			if (firstCubeSame) {
																				biggerThanCurrent =
																						biggerThan(toBeAdded.cubeTwo,
																								current.cubeTwo); 
																			} else {
																				biggerThanCurrent =
																						biggerThan(toBeAdded.cubeOne,
																								current.cubeOne);
																			}
																			if (biggerThanCurrent) {
																				if (current.next == null) {
																					current.next = toBeAdded;
																					count++;
																					break;
																				} else {
																					current = current.next;
																				}
																			} else {
																				Problem90 tempObject =
																				new Problem90(smaller, bigger);
																				tempObject.next = current;
																				tempObject.prev = current.prev;
																				current.prev = tempObject;
																				(tempObject.prev).next = tempObject;
																				count++;
																				break;
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		/*
		Problem90 currently = start;
		for (int i = 0; i < 10; i++) {
			System.out.println(currently.cubeOne + " " + currently.cubeTwo);
			currently = currently.next;
		}
		*/
		System.out.println("Ausgabe: " + count);
	}
	
	/* Remark: This took a long time to code, but it was finished with little difficulty once I nailed the code right. It
	 * helps that this problem isn't one that takes too long to solve with brute force, so there's that too.
	 * Problem solved
	 * 12921st person to have solved this problem
	 * Difficulty rating: 40%
	 * Runtime: Less than 1 second
	 * */
}
