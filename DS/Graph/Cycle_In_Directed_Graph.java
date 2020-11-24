import java.util.ArrayList;
import java.util.LinkedList;

public class Cycle_In_Directed_Graph {
	public static int n = 4;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public static void Add_Edge(int s, int d) {
		adj.get(s).add(d);
	}

	public static void PrintGraph() {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println("");
		}
	}

	public static boolean isSafe(int i, int visited[], int revStack[]) {

		if (revStack[i] == 1) {
			return true;
		}
		if (visited[i] == 1) {
			return false;
		}

		visited[i] = 1;
		revStack[i] = 1;

		ArrayList<Integer> child = adj.get(i);
		for (int c : child) {
			if (isSafe(c, visited, revStack)) {
				return true;
			}
		}
		revStack[i] = 0;
		return false;
	}

	public static boolean CyclePresent() {
		int visited[] = new int[n];
		int revStack[] = new int[n];

		for (int i = 0; i < n; i++) {
			if (isSafe(i, visited, revStack)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		Add_Edge(0, 1);
		Add_Edge(0, 2); 
        Add_Edge(1, 2); 
        Add_Edge(2, 0); 
        Add_Edge(2, 3); 
        Add_Edge(3, 3); 

		if (CyclePresent()) {
			System.out.println("Graph is cyclic graph");
		} else {
			System.out.println("Graph is acyclic graph");
		}
	}
}