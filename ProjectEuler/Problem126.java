package eulerProject121to150;

import java.util.*;

public class Problem126 implements Comparable<Problem126> {
	long n;
	int c = 1;
	
	public Problem126(long n) {
		this.n = n;
	}
	
	@Override
	public int compareTo(Problem126 o) {
		if (this.n < o.n) {
			return -1;
		} else if (this.n > o.n) {
			return 1;
		}
		return 0;
	}
	
	public static long cuboidLayers(int target) {
		for (long i = 22; true ; i++) {
			int total = 0;
			for (int j = 1; j < (i - 2) / 4; j++) {
				boolean stop = false;
				for (int k = 1; k <= j; k++) {
					if (i <= 2 * j * k) {
						stop = true;
						break;
					} else if (cuboidSolution(j, k, i)) {
						total++;
					}
				}
				if (stop) {
					break;
				}
			}
			if (total >= target) {
				return i;
			}
		}
	}
	
	public static boolean cuboidSolution(int b, int c, long n) {
		long divider = 2 * (b + c);
		long upper = n - 2 * b * c;
		long a = upper / divider;
		return (a * divider == upper && a > b);
	}
	
	public static long cuboidLayersTwo(int target) {
		ArrayList<Problem126> array = new ArrayList<>();
		for (int i = 1; true; i++) {
			// System.out.println(i);
			long limit = cuboidN(i, 1, 1);
			for (int j = 0; j < array.size(); j++) {
				if (array.get(j).n < limit) {
					Problem126 temp = array.get(j);
					if (temp.c >= target) {
						/*
						for (int k = 0; k < array.size(); k++) {
							Problem126 temp2 = array.get(k);
							System.out.println(temp2.c + " " + temp2.n);
						}
						*/
						return temp.n;
					}
				}
			}
			for (int j = 1; j <= i; j++) {
				for (int k = 1; k <= j; k++) {
					long temp = cuboidN(i, j, k);
					// System.out.println(temp + " " + i + " " + j + " " + k);
					boolean incremented = false;
					for (int l = 0; l < array.size(); l++) {
						if (temp == array.get(l).n) {
							array.get(l).c++;
							incremented = true;
							break;
						}
					}
					if (!incremented) {
						Problem126 temp2 = new Problem126(temp);
						array.add(temp2);
						array.sort(null);
					}
				}
			}
		}
	}
	
	public static long cuboidN(int a, int b, int c) {
		return 2 * (a * b + b * c + a * c);
	}
	
	public class Problem126Two implements Comparable<Problem126Two> {
		int a;
		int b;
		int c;
		int layer;
		int currentLayer;
		int firstLayer;
		int sum = 0;
		
		public Problem126Two(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
			firstLayer = 2 * (a * b + b * c + a * c);
			layer = 0;
		}
		
		public long nextLayer() {
			layer++;
			if (layer == 1) {
				currentLayer = firstLayer;
				return firstLayer;
			} else {
				sum += layer - 2;
				currentLayer = firstLayer + 4 * (a + b + c) * (layer - 1) + sum * 8;
				return currentLayer;
			}
		}

		@Override
		public int compareTo(Problem126Two o) {
			if (this.currentLayer < o.currentLayer) {
				return -1;
			} else if (this.currentLayer > o.currentLayer) {
				return 1;
			}
			return 0;
		}
		
		public String toString() {
			return ("a: " + a + "\nb: " + b + "\nc: " + c + "\nCurrent layer: " + currentLayer + "\nLayer: " + layer);
		}
	}
	
	public static long cuboidLayersThree(int target) {
		ArrayList<Problem126Two> array2 = new ArrayList<>();
		Problem126 constructor = new Problem126(0);
		Map<Long, Integer> mapping = new HashMap<>();
		int i = 1;
		int j = 1;
		int k = 1;
		Problem126Two current = constructor.new Problem126Two(i, j, k);
		mapping.put(current.nextLayer(), 1);
		array2.add(current);
		i = 2;
		while (true) {
			// System.out.println(i + " " + j + " " + k);
			current = constructor.new Problem126Two(i, j, k);
			while (current.firstLayer > array2.getFirst().currentLayer) {
				long temp = array2.getFirst().nextLayer();
				if (mapping.containsKey(temp)) {
					mapping.put(temp, mapping.get(temp) + 1);
				} else {
					mapping.put(temp, 1);
				}
				if (mapping.get(temp) == target) {
					/*
					System.out.println(mapping);
					System.out.println(array2);
					*/
					return temp;
				}
				array2.sort(null);
			}
			long temp = current.nextLayer();
			if (mapping.containsKey(temp)) {
				mapping.put(temp, mapping.get(temp) + 1);
			} else {
				mapping.put(temp, 1);
			}
			if (mapping.get(temp) == target) {
				/*
				System.out.println(mapping);
				System.out.println(array2);
				*/
				return temp;
			}
			array2.add(current);
			array2.sort(null);
			if (j == k) {
				if (i == j) {
					i++;
					j = 1;
					k = 1;
				} else {
					j++;
					k = 1;
				}
			} else {
				k++;
			}
		}
	}
	
	public class Problem126Three {
		int a;
		int b;
		int c;
		int currentLayer = 0;
		int layer = 0;
		
		public Problem126Three(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		public long nextLayer() {
			layer++;
			if (layer == 1) {
				currentLayer = 2 * (a * b + b * c + a * c);
			} else {
				currentLayer += 4 * (a + b + c) + 8 * (layer - 2);
			}
			return currentLayer;
		}
		
		public String toString() {
			return "a: " + a + "\nb: " + b + "\nc: " + c + "\nCurrent layer: " + currentLayer + "\nLayer: " + layer +
					"\n";
		}
	}
	
	public static long cuboidLayersFour(int target) {
		int limit = 100;
		int i = 1;
		int j = 1;
		int k = 1;
		ArrayList<Problem126Three> array = new ArrayList<>();
		Map<Long, Integer> mapper = new HashMap<>();
		Problem126 constructor = new Problem126(0);
		Problem126Three toAdd = constructor.new Problem126Three(i, j, k);
		while (true) {
			System.out.println(limit);
			while (true) {
				long temp = toAdd.nextLayer();
				// System.out.println(temp);
				mapAdd(mapper, temp);
				/*
				if (temp == 46) {
					System.out.println(toAdd);
				}
				*/
				array.add(toAdd);
				if (j == k) {
					k = 1;
					if (i == j) {
						i++;
						j = 1;
					} else {
						j++;
					}
				} else {
					k++;
				}
				toAdd = constructor.new Problem126Three(i, j, k);
				if ((i * 2 + 1) * 2 > limit) {
					break;
				}
			}
			// System.out.println("Test 1");
			/*
			if (array.size() > 10) {
				System.out.println(mapper);
				System.out.println(array);
				return 0;
			}
			*/
			for (int l = 0; l < array.size(); l++) {
				Problem126Three temp = array.get(l);
				while (temp.currentLayer <= limit) {
					long temp2 = temp.nextLayer();
					mapAdd(mapper, temp2);
					/*
					if (temp2 == 46) {
						System.out.println(temp);
					}
					*/
				}
			}
			/*
			if (array.size() > 10) {
				System.out.println(mapper);
				System.out.println(array);
				return 0;
			}
			*/
			long toReturn = 0;
			ArrayList<Long> temp = new ArrayList<>();
			for (long l: mapper.keySet()) {
				if (mapper.get(l) == target && l < limit) {
					if (toReturn == 0) {
						toReturn = l;
					} else if (toReturn > l) {
						toReturn = l;
					}
				}
				if (l < limit)
				temp.add(l);
			}
			for (int m = 0; m < temp.size(); m++) {
				mapper.remove(temp.get(i));
			}
			if (toReturn > 0) {
				// System.out.println(array);
				// System.out.println(mapper);
				return toReturn;
			} else {
				limit *= 2;
			}
		}
	}
	
	public static void mapAdd(Map<Long, Integer> mapper, long toAdd) {
		if (mapper.containsKey(toAdd)) {
			mapper.put(toAdd, mapper.get(toAdd) + 1);
		} else {
			mapper.put(toAdd, 1);
		}
	}
	
	public static long cuboidLayersFive(int target, long limit) {
		Map<Long, Integer> mapper = new HashMap<>();
		Problem126 constructor = new Problem126(0);
		for (int i = 1; (i * 2 + 1) * 2 <= limit; i++) {
			for (int j = 1; j <= i && 2 * (i * j + i + j) <= limit; j++) {
				for (int k = 1; k <= j && 2 * (i * j + i * k + j * k) <= limit; k++) {
					Problem126Three currentObject = constructor.new Problem126Three(i, j, k);
					long temp = currentObject.nextLayer();
					while (temp <= limit) {
						mapAdd(mapper, temp);
						temp = currentObject.nextLayer();
					}
				}
			}
		}
		long toReturn = 0;
		for (long i : mapper.keySet()) {
			if (mapper.get(i) == target) {
				if (toReturn == 0) {
					toReturn = i;
				} else if (toReturn > i) {
					toReturn = i;
				}
			}
			// System.out.println(i + " " + mapper.get(i));
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + cuboidLayersFive(1000, 20000));
		/*
		Problem126 constructor = new Problem126(0);
		Problem126Three test = constructor.new Problem126Three(3, 2, 1);
		for (int i = 0; i < 5; i++) {
			System.out.println(test.nextLayer());
		}
		*/
	}
	
	/* Remark: This problem took a lot of time and also a lot of unnecessary effort. I thought I was being smart by
	 * making use of dynamic programming, because that should save time, but it turns out the brute-force method works
	 * just fine, and in fact, it's faster than dynamic programming.
	 * Problem solved
	 * 5521st person to have solved this problem
	 * Difficulty rating: 55%
	 * Runtime: Less than 1 second
	 * */
}
