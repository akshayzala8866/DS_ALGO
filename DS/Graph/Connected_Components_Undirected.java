import java.util.*;

public class Connected_Components_Undirected {
	public static int n = 5;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public static void Add_node(int a, int b) {
		adj.get(a).add(b);
		adj.get(b).add(a);
	}

	public static void DFS(int v, int visited[]) {
		visited[v] = 1;
		System.out.print(v + " ");

		ArrayList<Integer> child = adj.get(v);

		for (int c : child) {
			if (visited[c] == 0) {
				DFS(c, visited);
			}
		}
	}

	public static void FindCCs() {
		int visited[] = new int[n];

		for (int v = 0; v < n; v++) {
			if (visited[v] == 0) {
				DFS(v, visited);
				System.out.println("");
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}			

		Add_node(0, 1);
		Add_node(1, 2);
		Add_node(3, 4);

		FindCCs();
	}
}