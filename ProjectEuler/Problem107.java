package eulerProject91to120;

import java.io.*;
import java.util.ArrayList;

public class Problem107 {
	int firstVertex;
	int secondVertex;
	long distance;
	
	public Problem107(int firstVertex, int secondVertex, long distance) {
		this.firstVertex = firstVertex;
		this.secondVertex = secondVertex;
		this.distance = distance;
	}
	
	public String toString() {
		return firstVertex + " " + secondVertex + " " + distance;
	}
	
	public static ArrayList<Problem107> network(int[][] matrix) {
		boolean[] visited = new boolean[matrix.length];
		ArrayList<Problem107> edges = new ArrayList<>();
		visited[0] = true;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				/*
				String line = i + " " + j;
				for (int k = 0; k < visited.length; k++) {
					line += " " + visited[k];
				}
				System.out.println(line);
				*/
				if (matrix[i][j] > 0) {
					edges.add(new Problem107(i, j, matrix[i][j]));
					if (visited[j]) {
						/*
						for (int k = 0; k < edges.size(); k++) {
							System.out.println(edges.get(k).toString());
						}
						*/
						ArrayList<Integer> toCheck = loop(i, j, new ArrayList<>(), new ArrayList<>(), edges);
						if (toCheck == null) {
							continue;
						}
						toCheck.add(edges.size() - 1);
						int biggestEdge = toCheck.getFirst();
						for (int k = 0; k < toCheck.size(); k++) {
							if (edges.get(biggestEdge).distance < edges.get(toCheck.get(k)).distance) {
								biggestEdge = toCheck.get(k);
							}
						}
						edges.remove(biggestEdge);
					} else {
						visited[j] = true;
					}
				}
			}
		}
		return edges;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Integer> loop(int currentNode, int goalNode, ArrayList<Integer> passedNode,
			ArrayList<Integer> edgesToCheck, ArrayList<Problem107> edges) {
		// System.out.println(currentNode + " " + goalNode + " " + passedNode + " " + edgesToCheck);
		if (currentNode == goalNode) {
			return edgesToCheck;
		}
		ArrayList<Integer> possibleEdges = new ArrayList<>();
		for (int i = 0; i < edges.size() - 1; i++) {
			Problem107 temp = edges.get(i);
			if ((temp.firstVertex == currentNode || temp.secondVertex == currentNode) &&
					(!passedNode.contains(temp.firstVertex) && !passedNode.contains(temp.secondVertex))) {
				possibleEdges.add(i);
			}
		}
		if (possibleEdges.size() == 1) {
			edgesToCheck.add(possibleEdges.getFirst());
			passedNode.add(currentNode);
			Problem107 edgeInQuestion = edges.get(possibleEdges.getFirst());
			int nextNode = 0;
			if (currentNode == edgeInQuestion.firstVertex) {
				nextNode = edgeInQuestion.secondVertex;
			} else {
				nextNode = edgeInQuestion.firstVertex;
			}
			return loop(nextNode, goalNode, passedNode, edgesToCheck, edges);
		} else if (possibleEdges.size() == 0) {
			return null;
		} else {
			for (int i = 0; i < possibleEdges.size(); i++) {
				ArrayList<Integer> edgesToCheckCopy = (ArrayList<Integer>) edgesToCheck.clone();
				edgesToCheckCopy.add(possibleEdges.get(i));
				ArrayList<Integer> passedNodeCopy = (ArrayList<Integer>) passedNode.clone();
				passedNodeCopy.add(currentNode);
				Problem107 edgeInQuestion = edges.get(possibleEdges.get(i));
				int nextNode = 0;
				if (currentNode == edgeInQuestion.firstVertex) {
					nextNode = edgeInQuestion.secondVertex;
				} else {
					nextNode = edgeInQuestion.firstVertex;
				}
				ArrayList<Integer> temp = loop(nextNode, goalNode, passedNodeCopy, edgesToCheckCopy, edges);
				if (temp != null) {
					return temp;
				}
			}
		}
		return null;
	}
	
	public static long sum(int[][] matrix) {
		long sumMatrix = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				sumMatrix += matrix[i][j];
			}
		}
		return sumMatrix / 2;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[40][40];
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("0107_network.txt")))) {
			int i = 0;
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				for (int j = 0; line.contains(","); line = line.substring(line.indexOf(',') + 1)) {
					String temp = line.substring(0, line.indexOf(','));
					if (!temp.contains("-")) {
						matrix[i][j] = Integer.valueOf(temp);
					}
					j++;
				}
				if (!line.contains("-")) {
					matrix[i][39] = Integer.valueOf(line);
				}
				i++;
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		long sumMatrix = sum(matrix);
		/*
		int[][] test2 = new int[7][7];
		test2[0][1] = 16;
		test2[0][2] = 12;
		test2[0][3] = 21;
		test2[1][0] = 16;
		test2[1][3] = 17;
		test2[1][4] = 20;
		test2[2][0] = 12;
		test2[2][3] = 28;
		test2[2][5] = 31;
		test2[3][0] = 21;
		test2[3][1] = 17;
		test2[3][2] = 28;
		test2[3][4] = 18;
		test2[3][5] = 19;
		test2[3][6] = 23;
		test2[4][1] = 20;
		test2[4][3] = 18;
		test2[4][6] = 11;
		test2[5][2] = 31;
		test2[5][3] = 19;
		test2[5][6] = 27;
		test2[6][3] = 23;
		test2[6][4] = 11;
		test2[6][5] = 27;
		*/
		ArrayList<Problem107> result = network(matrix);
		long resultNetwork = 0;
		for (int i = 0; i < result.size(); i++) {
			resultNetwork += result.get(i).distance;
		}
		System.out.println("Ausgabe: " + (sumMatrix - resultNetwork));
	}
	
	/* Remark: This problem took a disproportionate amount of my time to solve. My first two solutions involving some
	 * bruteforce took forever to complete, so I had to look up a better way to do this. I did eventually find a more
	 * time-efficient algorithm and solution, which I employed and then finished this mess in 1 second.
	 * Problem solved
	 * 12384th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: 1 second
	 * */
}
