public class Cycle_Present_Or_Not {

	public static int n = 4;
	public static int mArray[][] = new int[n][n];

	public static void Add_Node(int node1, int node2) {
		if (node1 < mArray.length && node2 < mArray.length) {
			mArray[node1][node2] = 1;
			mArray[node2][node1] = 1;
		} else {
			System.out.println("check again :(");
		}
	}

	public static void PrintGraph(int mArray[][]) {
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				System.out.print(mArray[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void printCycle(int cycle[]) {
		for (int i : cycle) {
			System.out.print(i + " ");
		} 
		System.out.print(cycle[0] + "");
		System.out.println("");
	} 

	public static void FindCycle(int visited[], int current, int count, int start, int cycle[]) {
		
		visited[current] = 1;
		cycle[count - 1] = current;

		if (count == visited.length) {
			if (mArray[current][start] == 1) {
				System.out.println("Cycle is present in graph :(");
				printCycle(cycle);

				return;
			} else {
				System.out.println("Cycle is not-present in graph :)");

				return;
			}
		}

		for (int i = 0; i < visited.length; i++) {
			if (mArray[current][i] == 1 && visited[i] == 0) {
				FindCycle(visited, i, count + 1, start, cycle);
			}
		}
	} 

	public static void main(String[] args) {
		int visited[] = new int[n]; 
		int cycle[] = new int[n];
		Add_Node(0, 1);
		Add_Node(1, 2);
		Add_Node(2, 3);
		Add_Node(3, 0);

		PrintGraph(mArray);
		FindCycle(visited, 0, 1, 0, cycle);
	}
}