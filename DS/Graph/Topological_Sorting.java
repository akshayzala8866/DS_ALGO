import java.util.*;

public class Topological_Sorting {
	public static int n = 6;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 

	public static void Add_node(int s, int d) {
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
			if (isContainCycle(c, visited, recStack)) {
				return true;
			}
		}
		recStack[v] = 0;
		return false;
	}

	public static boolean isCyclic() {
		int visited[] = new int[n];
		int recStack[] = new int[n];

		for (int v = 0; v < n; v++) {
			if (visited[v] == 0 && isContainCycle(v, visited, recStack)) {
				return true;
			}
		}

		return false;
	}

	public static void TopologicalUtil(int v, int visited[], Stack<Integer> s) {
		visited[v] = 1;

		ArrayList<Integer> child = adj.get(v);

		for (int c : child) {
			if (visited[c] == 0) {
				TopologicalUtil(c, visited, s);
			}
		}

		s.push(v);
	}

	public static void topologicalSorting() {
		Stack<Integer> s = new Stack<>();
		int visited[] = new int[n];
		for (int v = 0; v < n; v++) {
			if (visited[v] == 0) {
				TopologicalUtil(v, visited, s);
			}
		}

		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
	 	
	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}	

		Add_node(5, 0);
		Add_node(5, 2);
		Add_node(4, 0);
		Add_node(4, 1);
		Add_node(2, 3);
		Add_node(3, 1);


		PrintGraph();

		if (isCyclic()) {
			System.out.println("Topological sorting is not possible..!");
		} else {
			System.out.println("Topological sorting is possible..!");
			
			topologicalSorting();
		}
	}	
}