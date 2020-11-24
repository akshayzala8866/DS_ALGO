import java.util.*;

public class Find_Sortest_Path {
	public static int n = 4;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public static void Add_Node(int a, int b) {
		adj.get(a).add(b);
		adj.get(b).add(a);
	}

	public static void findSortestPath(int source, int dest) {
		int visited[] = new int[n];
		int distance[] = new int[n];
		int predessor[] = new int[n];

		Arrays.fill(predessor, -1);

		if (BFS(source, dest, visited, distance, predessor) == false) {
			System.out.println(":(");
		} else {
			System.out.println(":)");
		}
	}

	public static boolean BFS(int source, int dest, int visited, int distance, int predessor) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[source] = 1;
		distance[source] = 0;
		q.add(source);

		while (!q.isEmpty()) {
			int parent_node = q.poll();
			ArrayList<Integer> child = adj.get(parent_node);
			for (int c : child) {
				if (visited[c] == 0) {
					visited[c] = 1;
					distance[c] = distance[parent_node] + 1;
					predessor[c] = parent_node;

					if (c == dest) {
						return true;
					}
				}
			} 
		}
	}

	public static void main(String[] args) {

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>()); 
		}

		Add_Node(0, 1);
		Add_Node(1, 2);
		Add_Node(2, 3);
		Add_Node(0, 2);

		int source = 0;
		int dest = 2;
		findSortestPath(source, dest);
	}
}