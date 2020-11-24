public class Hamiltonian_Cycle {

	public static int V = 4;

	public static void PrintPath(int visited[]) {
		System.out.println("");
		for (int i : visited) {
			System.out.print(i +", ");
		}
		System.out.println("");
	}

	public static boolean isSafe(int mArray[][], int visited[], int v, int pos) {
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
 
	public static boolean ifPathSafe(int mArray[][], int visited[], int pos) {
		if (pos == V) {
			if (mArray[visited[pos - 1]][visited[0]] == 1) {
				PrintPath(visited);
				// return true;
			} else {
				return false;
			}
		}

		for (int v = 1; v < V; v++) {
			if (isSafe(mArray, visited, v, pos)) {
				visited[pos] = v;
				if (ifPathSafe(mArray, visited, pos + 1)) {
					return true;
				}
				visited[pos] = -1;
			}
		}

		return false;
	}

	public static void FindPath(int mArray[][], int visited[]) {
		visited[0] = 0;

		ifPathSafe(mArray, visited, 1);
	}

	public static void main(String[] args) {
		
		int mArray[][] = { {0, 1, 0, 1},
		 				   {1, 0, 1, 0},
		 				   {0, 1, 0, 1},
		 				   {1, 0, 1, 0} };
		int visited[] = new int[V];

		FindPath(mArray, visited);

	}
}