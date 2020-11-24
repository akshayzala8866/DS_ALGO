import java.util.*;

public class Practice_Graph {

	public static int n = 6;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public static void Add_node(int a, int b) {
		adj.get(a).add(b);
	}

	public static boolean isContainCycle(int v, int visited[], int recStack[]) {
		if (recStack[v] == 1) {
			return true;
		}

		if (visited[v] == 1) {
			return false;
		}

		visited[v] = 1;
		recStack[v] = 1;

		ArrayList<Integer> child = adj.get(v);

		for (int c : child) {
			if (visited[c] == 0) {
				if (isContainCycle(c, visited, recStack)) {
					return true;
				}
			}
		}

		recStack[v] = 0;
		return false;
	}

	public static boolean isCyclic() {
		int visited[] = new int[n];
		int recStack[] = new int[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0 && isContainCycle(i, visited, recStack)) {
				return true;
			}
		}

		return false;
	}

	public static void printGraph() {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println("");
		}
	}

	public static void UtilFun(int v, int visited[], Stack<Integer> s) {
		visited[v] = 1;

		ArrayList<Integer> child = adj.get(v);

		for  (int c : child) {
			if (visited[c] == 0) {
				UtilFun(c, visited, s);
			}
		}

		s.push(v);
	}

	public static void topologicalSorting() {
		Stack<Integer> s = new Stack<>();
		int visited[] = new int[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				UtilFun(i, visited, s);
			}
		}

		while (!s.isEmpty()) {
			int top = s.pop();
			System.out.print(top + " ");
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		Add_node(5, 0);
		Add_node(5, 2);
		Add_node(4, 0);
		Add_node(4, 1);
		Add_node(2, 3);
		Add_node(3, 1);

		printGraph();

		if (isCyclic()) {
			System.out.println(":(");
		} else {
			topologicalSorting();
		}
	}
}