import java.util.*;

public class Kosarajus_Strongly_Connected_components {
	public int v;
	public ArrayList<ArrayList<Integer>> adj;
	Kosarajus_Strongly_Connected_components(int V) {
		v = V;
		adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public void Add_node(int a, int b) {
		adj.get(a).add(b);
	}

	public void DFS_1(int i, int visited[], Stack<Integer> s) {
		visited[i] = 1;

		ArrayList<Integer> child = adj.get(i);
		for (int c : child) {
			if (visited[c] == 0) {
				DFS_1(c, visited, s);
			}
		}
		s.push(i);
	}

	public Kosarajus_Strongly_Connected_components getTranspose() {
		Kosarajus_Strongly_Connected_components trans_G = new Kosarajus_Strongly_Connected_components(5);
		for (int i = 0; i < v; i++) {
			ArrayList<Integer> child = adj.get(i);
			for (int c : child) {
				trans_G.adj.get(c).add(i);
			}
		}
		return trans_G;
	}

	public void DFS_2(int v_top, int visited[]) {
		visited[v_top] = 1;

		System.out.print(v_top + " ");

		ArrayList<Integer> child = adj.get(v_top);

		for (int c : child) {
			if (visited[c] == 0) {
				DFS_2(c, visited);
			}
		}
	}

	public void FindSCCs(Kosarajus_Strongly_Connected_components graph) {
		int visited[] = new int[v];
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < v; i++) {
			if (visited[i] == 0) {
				graph.DFS_1(i, visited, s);
			}
		}

		Kosarajus_Strongly_Connected_components trans_G = graph.getTranspose();

		Arrays.fill(visited, 0);

		while (!s.isEmpty()) {
			int v_top = (int) s.pop();

			if (visited[v_top] == 0) {
				trans_G.DFS_2(v_top, visited);
				System.out.println("");
			}
		}
	}

	public static void main(String[] args) {
		Kosarajus_Strongly_Connected_components graph = new Kosarajus_Strongly_Connected_components(5);

		graph.Add_node(0, 2);
		graph.Add_node(0, 3);
		graph.Add_node(1, 0);
		graph.Add_node(2, 1);
		graph.Add_node(3, 4);

		graph.FindSCCs(graph);
	}	
}