public class hamiltonian_Cycle {
	public static int n = 4;
	public static int mArray[][] = new int[n][n];

	public static void addNode(int node1, int node2) {
		if (node1 < mArray.length && node2 < mArray[0].length) {
			mArray[node2][node1] = 1;
			mArray[node1][node2] = 1;
		} else {
			System.out.println("Try again :(");
		}
	}

	public static void PrintGraph() {
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				System.out.print(mArray[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void Printcycle(int visited[]) {
		for (int i : visited) {
			System.out.print(i + " ");
		}
		System.out.print(visited[0]);
	} 

	public static boolean isSafe(int visited[], int pos, int v) {
		if (mArray[visited[pos - 1]][v] == 0) {
			return false;
		}

		for (int i = 0; i < pos; i++) {
			if (visited[i] == v) {
				return false;
			}
 		}

 		return true;
	}

	public static boolean findCycle(int visited[], int pos, int start) {

		if (pos == n) {
			if (mArray[pos - 1][visited[start]] == 1) {
				Printcycle(visited);
				return true;
			} else {
				return false;
			}
		}

		for (int v = 0; v < n; v++) {
			if (isSafe(visited, pos, v)) {
				visited[pos] = v;
				if (findCycle(visited, pos + 1, start)) {
					return true;
				}
				visited[pos] = Integer.MAX_VALUE;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		addNode(0, 1);
		addNode(0, 3);
		addNode(1, 2);
		addNode(3, 2);	

		PrintGraph();

		int visited[] = new int[n];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = Integer.MAX_VALUE;
		} 
		int start = 2;
		visited[0] = start;
		findCycle(visited, 1, start);
	}
}