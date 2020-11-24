import java.util.*;

public class Find_Sortest_Path {
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

	public static void FindSortestPath(int source, int dest) {
		int visited[] = new int[n];
		int distance[] = new int[n];
		int predessor[] = new int[n];

		Arrays.fill(predessor, -1);

		if (BFS(source, dest, visited, distance, predessor) == false) {
			System.out.println(":(");
			return;
		}
		
		ArrayList<Integer> path = new ArrayList<>();
		int current_node = dest;
		path.add(current_node);
		while (predessor[current_node] != -1) {
			path.add(predessor[current_node]);
			current_node = predessor[current_node];
		}

		System.out.println(path);	
	}

	public static boolean BFS(int source, int dest, int visited[], int distance[], int predessor[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		visited[source] = 1;
		distance[source] = 0;

		while (!q.isEmpty()) {
			int parent_node = q.poll();

			ArrayList<Integer> child = adj.get(parent_node);

			for (int c : child) {
				if (visited[c] == 0) {
					visited[c] = 1;
					distance[c] = distance[parent_node] + 1;
					predessor[c] = parent_node;
					
					q.add(c);

					if (c == dest) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}

		Add_Node(0, 1);
		Add_Node(0, 2);
		Add_Node(1, 2);
		Add_Node(2, 3);

		PrintGraph();

		int source = 0;
		int dest = 3;
		FindSortestPath(source, dest);
	}
}