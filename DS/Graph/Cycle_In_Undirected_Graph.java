import java.util.*;

public class Cycle_In_Undirected_Graph {
	public static int n = 4;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public static void Add_Node(int a, int b) {
		adj.get(a).add(b);
		adj.get(b).add(a);
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

	public static boolean isContainCycle(int start, int visited[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = 1;
		q.add(start);
		int parents[] = new int[n];

		while (!q.isEmpty()) {
			int temp = q.poll();

			ArrayList<Integer> child = adj.get(temp);

			for (int c : child) {
				System.out.println(c);
				if (visited[c] == 0) {
					visited[c] = 1;
					q.add(c);
					parents[c] = temp;
				} else if (parents[temp] != c) {
					return true;
				}							
			}
		}
		return false;
	}

	public static boolean isCycle() {
		int visited[] = new int[n];
		Arrays.fill(visited, 0);
		for (int i = 0; i < n; i++) {
			if (isContainCycle(i, visited) && visited[i] == 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}

		Add_Node(0, 1);
		// Add_Node(0, 2);
		Add_Node(1, 2);
		Add_Node(3, 2);

		PrintGraph();
		
		if (isCycle()) {
			System.out.println("Cyclic undirected graph");
		} else {
			System.out.println("Acyclic undirected graph");
		}
	}
}